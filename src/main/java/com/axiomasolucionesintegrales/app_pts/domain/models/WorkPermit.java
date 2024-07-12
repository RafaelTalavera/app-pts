package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "workers_permits")
@Entity
public class WorkPermit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    private String permitNumber;

    private LocalDateTime issueDate;

    private LocalDateTime expirationDate;

    private String workDescription;

    private String workLocation;

    private String gpsLocation;

    @OneToMany
    private List<ToolsAndEquipment> toolsAndEquipment;

    @ManyToMany
    private List<User> workers;

    @ManyToMany
    private List<User> supervisors;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Risk> risks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ControlMeasure> controlMeasures;

    @OneToOne
    private EmergencyPlan emergencyPlan;

    @OneToMany
    private List<SafetyReview> safetyReviews;

    @OneToOne
    private WorkPermitClosure closure;

    @OneToMany
    private List<AuditLog> auditLogs;

    // Métodos Getters y Setters
}

