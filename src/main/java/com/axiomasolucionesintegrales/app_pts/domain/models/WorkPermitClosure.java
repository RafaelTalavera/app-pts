package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

@Table(name= "works_permits_closure")
@Entity
public class WorkPermitClosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime completionDate;

    private String conditionVerification;

    private String closureSignature;

    public WorkPermitClosure() {
    }

    public WorkPermitClosure(Long id, LocalDateTime completionDate, String conditionVerification, String closureSignature) {
        this.id = id;
        this.completionDate = completionDate;
        this.conditionVerification = conditionVerification;
        this.closureSignature = closureSignature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public String getConditionVerification() {
        return conditionVerification;
    }

    public void setConditionVerification(String conditionVerification) {
        this.conditionVerification = conditionVerification;
    }

    public String getClosureSignature() {
        return closureSignature;
    }

    public void setClosureSignature(String closureSignature) {
        this.closureSignature = closureSignature;
    }
}
