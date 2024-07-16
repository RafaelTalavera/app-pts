package com.axiomasolucionesintegrales.app_pts.application.dto;

import com.axiomasolucionesintegrales.app_pts.domain.models.Company;

import java.time.LocalDateTime;
import java.util.List;


public class WorkPermitDTO {

    private Long id;
    private Long companyId;
    private String permitNumber;
    private LocalDateTime issueDate;
    private LocalDateTime expirationDate;
    private String workDescription;
    private String workLocation;
    private String gpsLocation;
    private List<ToolsAndEquipmentDTO> toolsAndEquipment;
    private List<UserDTO> workers;
    private List<UserDTO> supervisors;
    private List<RiskDTO> risks;
    private List<ControlMeasureDTO> controlMeasures;
    private EmergencyPlanDTO emergencyPlan;
    private List<SafetyReviewDTO> safetyReviews;
    private WorkPermitClosureDTO closure;
    private List<AuditLogDTO> auditLogs;

    public WorkPermitDTO() {
    }

    public WorkPermitDTO(Long id, Long companyId, String permitNumber, LocalDateTime issueDate, LocalDateTime expirationDate, String workDescription, String workLocation, String gpsLocation, List<ToolsAndEquipmentDTO> toolsAndEquipment, List<UserDTO> workers, List<UserDTO> supervisors, List<RiskDTO> risks, List<ControlMeasureDTO> controlMeasures, EmergencyPlanDTO emergencyPlan, List<SafetyReviewDTO> safetyReviews, WorkPermitClosureDTO closure, List<AuditLogDTO> auditLogs) {
        this.id = id;
        this.companyId = companyId;
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

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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

    public List<ToolsAndEquipmentDTO> getToolsAndEquipment() {
        return toolsAndEquipment;
    }

    public void setToolsAndEquipment(List<ToolsAndEquipmentDTO> toolsAndEquipment) {
        this.toolsAndEquipment = toolsAndEquipment;
    }

    public List<UserDTO> getWorkers() {
        return workers;
    }

    public void setWorkers(List<UserDTO> workers) {
        this.workers = workers;
    }

    public List<UserDTO> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<UserDTO> supervisors) {
        this.supervisors = supervisors;
    }

    public List<RiskDTO> getRisks() {
        return risks;
    }

    public void setRisks(List<RiskDTO> risks) {
        this.risks = risks;
    }

    public List<ControlMeasureDTO> getControlMeasures() {
        return controlMeasures;
    }

    public void setControlMeasures(List<ControlMeasureDTO> controlMeasures) {
        this.controlMeasures = controlMeasures;
    }

    public EmergencyPlanDTO getEmergencyPlan() {
        return emergencyPlan;
    }

    public void setEmergencyPlan(EmergencyPlanDTO emergencyPlan) {
        this.emergencyPlan = emergencyPlan;
    }

    public List<SafetyReviewDTO> getSafetyReviews() {
        return safetyReviews;
    }

    public void setSafetyReviews(List<SafetyReviewDTO> safetyReviews) {
        this.safetyReviews = safetyReviews;
    }

    public WorkPermitClosureDTO getClosure() {
        return closure;
    }

    public void setClosure(WorkPermitClosureDTO closure) {
        this.closure = closure;
    }

    public List<AuditLogDTO> getAuditLogs() {
        return auditLogs;
    }

    public void setAuditLogs(List<AuditLogDTO> auditLogs) {
        this.auditLogs = auditLogs;
    }
}
