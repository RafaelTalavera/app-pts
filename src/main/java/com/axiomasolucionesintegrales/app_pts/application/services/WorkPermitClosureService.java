package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitClosureDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.WorkPermitClosureMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermitClosure;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.WorkPermitClosureRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.IWorkPermitClosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WorkPermitClosureService implements IWorkPermitClosureService {

    @Autowired
    private WorkPermitClosureRepository workPermitClosureRepository;

    @Autowired
    private WorkPermitClosureMapper workPermitClosureMapper;

    @Override
    public List<WorkPermitClosureDTO> findAll() {
        Iterable<WorkPermitClosure> workPermitClosures = workPermitClosureRepository.findAll();
        return StreamSupport.stream(workPermitClosures.spliterator(), false)
                .map(workPermitClosureMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WorkPermitClosureDTO> findById(Long id) {
        return workPermitClosureRepository.findById(id)
                .map(workPermitClosureMapper::toDTO);
    }

    @Override
    public WorkPermitClosureDTO createWorkPermitClosure(WorkPermitClosureDTO workPermitClosureDTO) {
        WorkPermitClosure workPermitClosure = workPermitClosureMapper.toEntity(workPermitClosureDTO);
        workPermitClosure = workPermitClosureRepository.save(workPermitClosure);
        return workPermitClosureMapper.toDTO(workPermitClosure);
    }

    @Override
    public WorkPermitClosureDTO update(Long id, WorkPermitClosureDTO workPermitClosureDTO) {
        Optional<WorkPermitClosure> existingClosure = workPermitClosureRepository.findById(id);
        if (existingClosure.isPresent()) {
            WorkPermitClosure workPermitClosure = workPermitClosureMapper.toEntity(workPermitClosureDTO);
            workPermitClosure.setId(id);
            workPermitClosure = workPermitClosureRepository.save(workPermitClosure);
            return workPermitClosureMapper.toDTO(workPermitClosure);
        } else {
            return null; // o lanzar una excepción
        }
    }

    @Override
    public void deletedById(Long id) {
        workPermitClosureRepository.deleteById(id);
    }
}