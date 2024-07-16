package com.axiomasolucionesintegrales.app_pts.domain.repositories;

import com.axiomasolucionesintegrales.app_pts.domain.models.AuditLog;
import org.springframework.data.repository.CrudRepository;

public interface AuditLogRepository extends CrudRepository<AuditLog, Long> {
}
