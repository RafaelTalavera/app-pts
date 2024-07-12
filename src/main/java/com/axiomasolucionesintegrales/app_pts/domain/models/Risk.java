package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "user_id")
    WorkPermit workPermit;
}