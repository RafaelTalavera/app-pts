package com.axiomasolucionesintegrales.app_pts.application.dto;

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
}
