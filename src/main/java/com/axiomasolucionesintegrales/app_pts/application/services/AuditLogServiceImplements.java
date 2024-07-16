package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.AuditLogDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.AuditLogMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.AuditLog;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.AuditLogRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.IAuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuditLogServiceImplements implements IAuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private AuditLogMapper auditLogMapper;

    @Override
    public List<AuditLogDTO> findAll() {
        Iterable<AuditLog> auditLogs = auditLogRepository.findAll();
        return StreamSupport.stream(auditLogs.spliterator(), false)
                .map(auditLogMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AuditLogDTO> findById(Long id) {
        Optional<AuditLog> auditLog = auditLogRepository.findById(id);
        return auditLog.map(auditLogMapper::toDTO);
    }

    @Override
    public AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = auditLogMapper.toEntity(auditLogDTO);
        AuditLog savedAuditLog = auditLogRepository.save(auditLog);
        return auditLogMapper.toDTO(savedAuditLog);
    }

    @Override
    public AuditLogDTO update(Long id, AuditLogDTO auditLogDTO) {
        Optional<AuditLog> existingAuditLog = auditLogRepository.findById(id);
        if (existingAuditLog.isPresent()) {
            AuditLog auditLog = auditLogMapper.toEntity(auditLogDTO);
            auditLog.setId(id);
            AuditLog updatedAuditLog = auditLogRepository.save(auditLog);
            return auditLogMapper.toDTO(updatedAuditLog);
        } else {
            // Manejar el caso donde el registro no existe
            return null; // O lanzar una excepción
        }
    }

    @Override
    public void deletedById(Long id) {
        auditLogRepository.deleteById(id);
    }
}