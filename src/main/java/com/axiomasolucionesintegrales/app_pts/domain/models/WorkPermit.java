package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;


@Table(name= "workers_permits")
@Entity
public class WorkPermit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String permitNumber;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    private String workDescription;

    private String workLocation;

    private String gpsLocation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "work_permit_id")
    private List<ToolsAndEquipment> toolsAndEquipment;

    @ManyToMany
    @JoinTable(
            name = "work_permit_workers",
            joinColumns = @JoinColumn(name = "work_permit_id"),
            inverseJoinColumns = @JoinColumn(name = "worker_id")
    )
    private List<User> workers;

    @ManyToMany
    @JoinTable(
            name = "work_permit_supervisors",
            joinColumns = @JoinColumn(name = "work_permit_id"),
            inverseJoinColumns = @JoinColumn(name = "supervisor_id")
    )
    private List<User> supervisors;

    @OneToMany(mappedBy = "workPermit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Risk> risks;

    @OneToMany(mappedBy = "workPermit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ControlMeasure> controlMeasures;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_plan_id", referencedColumnName = "id")
    private EmergencyPlan emergencyPlan;

    @OneToMany(mappedBy = "workPermit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SafetyReview> safetyReviews;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "closure_id", referencedColumnName = "id")
    private WorkPermitClosure closure;

    @OneToMany(mappedBy = "workPermit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuditLog> auditLogs;


    public WorkPermit() {
    }

    public WorkPermit(Long id, Company company, String permitNumber, LocalDateTime issueDate, LocalDateTime expirationDate, String workDescription, String workLocation, String gpsLocation, List<ToolsAndEquipment> toolsAndEquipment, List<User> workers, List<User> supervisors, List<Risk> risks, List<ControlMeasure> controlMeasures, EmergencyPlan emergencyPlan, List<SafetyReview> safetyReviews, WorkPermitClosure closure, List<AuditLog> auditLogs) {
        this.id = id;
        this.company = company;
        this.permitNumber = permitNumber;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.workDescription = workDescription;
        this.workLocation = workLocation;
        this.gpsLocation = gpsLocation;
        this.toolsAndEquipment = toolsAndEquipment;
        this.workers = workers;
        this.supervisors = supervisors;
        this.risks = risks;
        this.controlMeasures = controlMeasures;
        this.emergencyPlan = emergencyPlan;
        this.safetyReviews = safetyReviews;
        this.closure = closure;
        this.auditLogs = auditLogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public List<ToolsAndEquipment> getToolsAndEquipment() {
        return toolsAndEquipment;
    }

    public void setToolsAndEquipment(List<ToolsAndEquipment> toolsAndEquipment) {
        this.toolsAndEquipment = toolsAndEquipment;
    }

    public List<User> getWorkers() {
        return workers;
    }

    public void setWorkers(List<User> workers) {
        this.workers = workers;
    }

    public List<User> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<User> supervisors) {
        this.supervisors = supervisors;
    }

    public List<Risk> getRisks() {
        return risks;
    }

    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }

    public List<ControlMeasure> getControlMeasures() {
        return controlMeasures;
    }

    public void setControlMeasures(List<ControlMeasure> controlMeasures) {
        this.controlMeasures = controlMeasures;
    }

    public EmergencyPlan getEmergencyPlan() {
        return emergencyPlan;
    }

    public void setEmergencyPlan(EmergencyPlan emergencyPlan) {
        this.emergencyPlan = emergencyPlan;
    }

    public List<SafetyReview> getSafetyReviews() {
        return safetyReviews;
    }

    public void setSafetyReviews(List<SafetyReview> safetyReviews) {
        this.safetyReviews = safetyReviews;
    }

    public WorkPermitClosure getClosure() {
        return closure;
    }

    public void setClosure(WorkPermitClosure closure) {
        this.closure = closure;
    }

    public List<AuditLog> getAuditLogs() {
        return auditLogs;
    }

    public void setAuditLogs(List<AuditLog> auditLogs) {
        this.auditLogs = auditLogs;
    }
}
