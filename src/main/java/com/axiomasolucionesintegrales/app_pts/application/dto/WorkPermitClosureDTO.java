package com.axiomasolucionesintegrales.app_pts.application.dto;

import java.time.LocalDateTime;


public class WorkPermitClosureDTO {
    private Long id;
    private LocalDateTime completionDate;
    private String conditionVerification;
    private String closureSignature;

    public WorkPermitClosureDTO() {
    }

    public WorkPermitClosureDTO(Long id, LocalDateTime completionDate, String conditionVerification, String closureSignature) {
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
