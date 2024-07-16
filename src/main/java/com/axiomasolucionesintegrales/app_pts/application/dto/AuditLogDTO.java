package com.axiomasolucionesintegrales.app_pts.application.dto;

import com.axiomasolucionesintegrales.app_pts.domain.models.User;
import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;

import java.time.LocalDateTime;


public class AuditLogDTO {

    private Long id;
    private User user;
    private String action;
    private LocalDateTime timestamp;
    private WorkPermit workPermit;

    public AuditLogDTO() {
    }

    public AuditLogDTO(Long id, User user, String action, LocalDateTime timestamp, WorkPermit workPermit) {
        this.id = id;
        this.user = user;
        this.action = action;
        this.timestamp = timestamp;
        this.workPermit = workPermit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public WorkPermit getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(WorkPermit workPermit) {
        this.workPermit = workPermit;
    }
}

