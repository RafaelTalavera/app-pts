package com.axiomasolucionesintegrales.app_pts.application.dto;

import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;


public class ControlMeasureDTO {
    private Long id;
    private String prevention;
    private String requiredPPE;
    private WorkPermit workPermit;

    public ControlMeasureDTO() {
    }

    public ControlMeasureDTO(Long id, String prevention, String requiredPPE, WorkPermit workPermit) {
        this.id = id;
        this.prevention = prevention;
        this.requiredPPE = requiredPPE;
        this.workPermit = workPermit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public String getRequiredPPE() {
        return requiredPPE;
    }

    public void setRequiredPPE(String requiredPPE) {
        this.requiredPPE = requiredPPE;
    }

    public WorkPermit getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(WorkPermit workPermit) {
        this.workPermit = workPermit;
    }
}
