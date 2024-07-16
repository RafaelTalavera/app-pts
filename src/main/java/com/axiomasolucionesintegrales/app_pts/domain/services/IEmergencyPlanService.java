package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.EmergencyPlanDTO;

import java.util.List;
import java.util.Optional;

public interface IEmergencyPlanService {

    public List<EmergencyPlanDTO> findAll();

    public Optional<EmergencyPlanDTO> findById(Long id);

    public EmergencyPlanDTO createEmergencyPlanDTO(EmergencyPlanDTO emergencyPlanDTO);

    EmergencyPlanDTO update(Long id, EmergencyPlanDTO emergencyPlanDTO);

    public void deletedById(Long id);
}
