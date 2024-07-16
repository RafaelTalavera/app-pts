package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.ToolsAndEquipmentDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.ToolsAndEquipment;

import java.util.List;
import java.util.Optional;

public interface IToolsAndEquipmentService {

    public List<ToolsAndEquipmentDTO> findAll();

    public Optional<ToolsAndEquipmentDTO> findById(Long id);

    public ToolsAndEquipmentDTO createToolsAndEquipment(ToolsAndEquipmentDTO toolsAndEquipmentDTO);

    ToolsAndEquipmentDTO update(Long id, ToolsAndEquipmentDTO toolsAndEquipmentDTO);


}
