package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.ToolsAndEquipmentDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.ToolsAndEquipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToolsAndEquipmentMapper {
    ToolsAndEquipmentDTO toDTO(ToolsAndEquipment toolsAndEquipment);
    ToolsAndEquipment toEntity(ToolsAndEquipmentDTO toolsAndEquipmentDTO);
}
