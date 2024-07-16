package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Table(name= "audits_logs")
@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // El usuario que realizó la acción

    private String action; // Ej. CREATED, APPROVED, SUSPENDED, CANCELLED

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "workPermit_id")
    private WorkPermit workPermit; // El PTS al que se refiere la auditoría

    public void setId(Long id) {
        this.id = id;
    }

    public AuditLog() {
    }

    public AuditLog(Long id, User user, String action, LocalDateTime timestamp, WorkPermit workPermit) {
        this.id = id;
        this.user = user;
        this.action = action;
        this.timestamp = timestamp;
        this.workPermit = workPermit;
    }

    public Long getId() {
        return id;
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


