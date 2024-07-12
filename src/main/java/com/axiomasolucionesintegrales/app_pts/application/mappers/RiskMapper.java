package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.RiskDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.Risk;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RiskMapper {
    RiskDTO toDTO(Risk risk);
    Risk toEntity(RiskDTO riskDTO);
}
