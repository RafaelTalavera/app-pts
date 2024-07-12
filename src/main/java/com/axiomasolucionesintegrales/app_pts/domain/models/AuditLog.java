package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "audits_logs")
@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // El usuario que realizó la acción

    private String action; // Ej. CREATED, APPROVED, SUSPENDED, CANCELLED

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "workPermit_id")
    private WorkPermit workPermit; // El PTS al que se refiere la auditoría
}


