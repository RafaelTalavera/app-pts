package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.WorkPermitMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.WorkPermitRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.IWorkPemitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WorkPemitServiceImplements implements IWorkPemitService {

    @Autowired
    private WorkPermitRepository workPermitRepository;

    @Autowired
    private WorkPermitMapper workPermitMapper;

    @Override
    public List<WorkPermitDTO> findAll() {
        return StreamSupport.stream(workPermitRepository.findAll().spliterator(), false)
                .map(workPermitMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WorkPermitDTO> findById(Long id) {
        return workPermitRepository.findById(id)
                .map(workPermitMapper::toDTO);
    }

    @Override
    @Transactional
    public WorkPermitDTO createWorkPermitDTO(WorkPermitDTO workPermitDTO) {
        WorkPermit workPermit = workPermitMapper.toEntity(workPermitDTO);
        workPermit = workPermitRepository.save(workPermit);
        return workPermitMapper.toDTO(workPermit);
    }

    @Override
    @Transactional
    public WorkPermitDTO update(Long id, WorkPermitDTO workPermitDTO) {
        Optional<WorkPermit> workPermitOptional = workPermitRepository.findById(id);
        if (workPermitOptional.isPresent()) {
            WorkPermit workPermit = workPermitOptional.get();
            // Actualizar los campos del workPermit con los valores del DTO

            return workPermitMapper.toDTO(workPermit);
        } else {
            throw new RuntimeException("WorkPermit not found");
        }
    }

    @Override
    @Transactional
    public void deletedById(Long id) {
        workPermitRepository.deleteById(id);
    }
}
