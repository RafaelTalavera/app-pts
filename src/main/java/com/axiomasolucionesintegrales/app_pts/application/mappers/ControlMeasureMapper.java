package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.ControlMeasureDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.ControlMeasure;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ControlMeasureMapper {
    ControlMeasureDTO toDTO(ControlMeasure controlMeasure);
    ControlMeasure toEntity(ControlMeasureDTO controlMeasureDTO);
}
