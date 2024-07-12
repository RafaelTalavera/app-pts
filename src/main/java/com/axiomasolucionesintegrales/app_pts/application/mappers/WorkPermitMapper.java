package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses =
        {UserMapper.class,
                CompanyMapper.class,
                RiskMapper.class,
                ControlMeasureMapper.class,
                EmergencyPlanMapper.class,
                SafetyReviewMapper.class,
                WorkPermitClosureMapper.class,
                ToolsAndEquipmentMapper.class})
public interface WorkPermitMapper {
    WorkPermitDTO toDTO(WorkPermit workPermit);
    WorkPermit toEntity(WorkPermitDTO workPermitDTO);
}

