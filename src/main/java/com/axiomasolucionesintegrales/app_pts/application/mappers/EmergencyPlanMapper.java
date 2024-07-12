package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.EmergencyPlanDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.EmergencyPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmergencyPlanMapper {
    EmergencyPlanDTO toDTO(EmergencyPlan emergencyPlan);
    EmergencyPlan toEntity(EmergencyPlanDTO emergencyPlanDTO);
}
