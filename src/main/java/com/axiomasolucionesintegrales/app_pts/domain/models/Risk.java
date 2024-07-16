package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Table(name= "risks")
@Entity
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String identification;

    @NotEmpty
    private String evaluation;

    @ManyToOne
    @JoinColumn(name = "work_permit_id")
    WorkPermit workPermit;

    public Risk() {
    }

    public Risk(Long id, String identification, String evaluation, WorkPermit workPermit) {
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