package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.AuditLogDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.AuditLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditLogMapper {
    AuditLogDTO toDTO(AuditLog auditLog);
    AuditLog toEntity(AuditLogDTO auditLogDTO);

}
