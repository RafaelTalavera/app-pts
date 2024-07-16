package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.AuditLogDTO;

import java.util.List;
import java.util.Optional;

public interface IAuditLogService {

    public List<AuditLogDTO> findAll();

    public Optional<AuditLogDTO> findById(Long id);

    public AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO);

    AuditLogDTO update(Long id, AuditLogDTO auditLogDTO);

    public void deletedById(Long id);

}
