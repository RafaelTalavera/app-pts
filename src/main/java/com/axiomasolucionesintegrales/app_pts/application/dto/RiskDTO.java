package com.axiomasolucionesintegrales.app_pts.application.dto;

import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;

public class RiskDTO {
    private Long id;
    private String identification;
    private String evaluation;
    WorkPermit workPermit;

    public RiskDTO() {
    }

    public RiskDTO(Long id, String identification, String evaluation, WorkPermit workPermit) {
        this.id = id;
        this.identification = identification;
        this.evaluation = evaluation;
        this.workPermit = workPermit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public WorkPermit getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(WorkPermit workPermit) {
        this.workPermit = workPermit;
    }
}
