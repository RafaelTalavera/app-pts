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

    // Métodos Getters y Setters
}
