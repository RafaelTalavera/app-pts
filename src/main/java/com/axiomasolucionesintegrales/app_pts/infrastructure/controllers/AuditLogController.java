package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.AuditLogDTO;
import com.axiomasolucionesintegrales.app_pts.application.services.AuditLogServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auditLogs")
public class AuditLogController {

    @Autowired
    private AuditLogServiceImplements auditLogService;

    @GetMapping
    public ResponseEntity<List<AuditLogDTO>> getAllAuditLogs() {
        List<AuditLogDTO> auditLogs = auditLogService.findAll();
        return ResponseEntity.ok(auditLogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLogDTO> getAuditLogById(@PathVariable Long id) {
        Optional<AuditLogDTO> auditLog = auditLogService.findById(id);
        return auditLog.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<AuditLogDTO> createAuditLog(@RequestBody AuditLogDTO auditLogDTO) {
        AuditLogDTO createdAuditLog = auditLogService.createAuditLog(auditLogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuditLog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditLogDTO> updateAuditLog(@PathVariable Long id, @RequestBody AuditLogDTO auditLogDTO) {
        AuditLogDTO updatedAuditLog = auditLogService.update(id, auditLogDTO);
        if (updatedAuditLog != null) {
            return ResponseEntity.ok(updatedAuditLog);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditLog(@PathVariable Long id) {
        auditLogService.deletedById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}