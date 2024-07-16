package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Table(name= "emergencys_plans")
@Entity
public class EmergencyPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String planDescription;

    private String rescueEquipment;

    private String contact;

    @OneToOne(mappedBy = "emergencyPlan")
    private WorkPermit workPermit;

    public EmergencyPlan() {
    }

    public EmergencyPlan(Long id, String planDescription, String rescueEquipment, String contact, WorkPermit workPermit) {
        this.id = id;
        this.planDescription = planDescription;
        this.rescueEquipment = rescueEquipment;
        this.contact = contact;
        this.workPermit = workPermit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public String getRescueEquipment() {
        return rescueEquipment;
    }

    public void setRescueEquipment(String rescueEquipment) {
        this.rescueEquipment = rescueEquipment;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public WorkPermit getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(WorkPermit workPermit) {
        this.workPermit = workPermit;
    }
}
