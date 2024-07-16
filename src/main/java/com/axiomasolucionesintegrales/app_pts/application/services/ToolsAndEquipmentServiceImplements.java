package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.ToolsAndEquipmentDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.ToolsAndEquipmentMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.ToolsAndEquipment;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.ToolsAndEquipmentRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.IToolsAndEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ToolsAndEquipmentServiceImplements implements IToolsAndEquipmentService {

    @Autowired
    private ToolsAndEquipmentRepository toolsAndEquipmentRepository;

    @Autowired
    private ToolsAndEquipmentMapper toolsAndEquipmentMapper;

    @Override
    public List<ToolsAndEquipmentDTO> findAll() {
        Iterable<ToolsAndEquipment> toolsAndEquipments = toolsAndEquipmentRepository.findAll();
        return StreamSupport.stream(toolsAndEquipments.spliterator(), false)
                .map(toolsAndEquipmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ToolsAndEquipmentDTO> findById(Long id) {
        return toolsAndEquipmentRepository.findById(id)
                .map(toolsAndEquipmentMapper::toDTO);
    }

    @Override
    public ToolsAndEquipmentDTO createToolsAndEquipment(ToolsAndEquipmentDTO toolsAndEquipmentDTO) {
        ToolsAndEquipment toolsAndEquipment = toolsAndEquipmentMapper.toEntity(toolsAndEquipmentDTO);
        toolsAndEquipment = toolsAndEquipmentRepository.save(toolsAndEquipment);
        return toolsAndEquipmentMapper.toDTO(toolsAndEquipment);
    }

    @Override
    public ToolsAndEquipmentDTO update(Long id, ToolsAndEquipmentDTO toolsAndEquipmentDTO) {
        Optional<ToolsAndEquipment> existingToolsAndEquipment = toolsAndEquipmentRepository.findById(id);
        if (existingToolsAndEquipment.isPresent()) {
            ToolsAndEquipment toolsAndEquipment = toolsAndEquipmentMapper.toEntity(toolsAndEquipmentDTO);
            toolsAndEquipment.setId(id);
            toolsAndEquipment = toolsAndEquipmentRepository.save(toolsAndEquipment);
            return toolsAndEquipmentMapper.toDTO(toolsAndEquipment);
        } else {
            return null; // o lanzar una excepción
        }
    }
}