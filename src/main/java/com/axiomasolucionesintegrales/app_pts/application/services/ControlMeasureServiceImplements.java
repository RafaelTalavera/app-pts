package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.ControlMeasureDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.ControlMeasureMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.ControlMeasure;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.ControlMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ControlMeasureServiceImplements {

    @Autowired
    private ControlMeasureRepository controlMeasureRepository;

    @Autowired
    private ControlMeasureMapper controlMeasureMapper;

    public List<ControlMeasureDTO> findAll() {
        Iterable<ControlMeasure> controlMeasures = controlMeasureRepository.findAll();
        return StreamSupport.stream(controlMeasures.spliterator(), false)
                .map(controlMeasureMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ControlMeasureDTO> findById(Long id) {
        return controlMeasureRepository.findById(id)
                .map(controlMeasureMapper::toDTO);
    }

    public ControlMeasureDTO createControlMeasure(ControlMeasureDTO controlMeasureDTO) {
        ControlMeasure controlMeasure = controlMeasureMapper.toEntity(controlMeasureDTO);
        controlMeasure = controlMeasureRepository.save(controlMeasure);
        return controlMeasureMapper.toDTO(controlMeasure);
    }

    public ControlMeasureDTO updateControlMeasure(Long id, ControlMeasureDTO controlMeasureDTO) {
        Optional<ControlMeasure> existingControlMeasure = controlMeasureRepository.findById(id);
        if (existingControlMeasure.isPresent()) {
            ControlMeasure controlMeasure = controlMeasureMapper.toEntity(controlMeasureDTO);
            controlMeasure.setId(id);
            controlMeasure = controlMeasureRepository.save(controlMeasure);
            return controlMeasureMapper.toDTO(controlMeasure);
        } else {
            return null;
        }
    }

    public void deleteControlMeasure(Long id) {
        controlMeasureRepository.deleteById(id);
    }
}