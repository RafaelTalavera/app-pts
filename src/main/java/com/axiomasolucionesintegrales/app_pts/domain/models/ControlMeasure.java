package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Table(name= "control_measure")
@Entity
public class ControlMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String prevention;

    @NotEmpty
    private String requiredPPE;

    @ManyToOne
    @JoinColumn(name = "work_permit_id")
    private WorkPermit workPermit;

    public ControlMeasure() {
    }

    public ControlMeasure(Long id, String prevention, String requiredPPE, WorkPermit workPermit) {
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
