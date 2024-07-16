package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.EmergencyPlanDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.EmergencyPlanMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.EmergencyPlan;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.EmergencyPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class EmergencyPlanServiceImplements {

    @Autowired
    private EmergencyPlanRepository emergencyPlanRepository;

    @Autowired
    private EmergencyPlanMapper emergencyPlanMapper;

    public List<EmergencyPlanDTO> findAll() {
        Iterable<EmergencyPlan> emergencyPlans = emergencyPlanRepository.findAll();
        return StreamSupport.stream(emergencyPlans.spliterator(), false)
                .map(emergencyPlanMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmergencyPlanDTO> findById(Long id) {
        return emergencyPlanRepository.findById(id)
                .map(emergencyPlanMapper::toDTO);
    }

    public EmergencyPlanDTO createEmergencyPlan(EmergencyPlanDTO emergencyPlanDTO) {
        EmergencyPlan emergencyPlan = emergencyPlanMapper.toEntity(emergencyPlanDTO);
        emergencyPlan = emergencyPlanRepository.save(emergencyPlan);
        return emergencyPlanMapper.toDTO(emergencyPlan);
    }

    public EmergencyPlanDTO updateEmergencyPlan(Long id, EmergencyPlanDTO emergencyPlanDTO) {
        Optional<EmergencyPlan> existingEmergencyPlan = emergencyPlanRepository.findById(id);
        if (existingEmergencyPlan.isPresent()) {
            EmergencyPlan emergencyPlan = emergencyPlanMapper.toEntity(emergencyPlanDTO);
            emergencyPlan.setId(id);
            emergencyPlan = emergencyPlanRepository.save(emergencyPlan);
            return emergencyPlanMapper.toDTO(emergencyPlan);
        } else {
            return null;
        }
    }

    public void deleteEmergencyPlan(Long id) {
        emergencyPlanRepository.deleteById(id);
    }
}
