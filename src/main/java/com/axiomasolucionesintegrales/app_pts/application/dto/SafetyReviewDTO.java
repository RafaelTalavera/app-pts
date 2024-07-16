package com.axiomasolucionesintegrales.app_pts.application.dto;

import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermit;


import java.time.LocalDateTime;


public class SafetyReviewDTO {
    private Long id;
    private LocalDateTime reviewDate;
    private String reviewer;
    private String observations;
    private WorkPermit workPermit;

    public SafetyReviewDTO() {
    }

    public SafetyReviewDTO(Long id, LocalDateTime reviewDate, String reviewer, String observations, WorkPermit workPermit) {
        this.id = id;
        this.reviewDate = reviewDate;
        this.reviewer = reviewer;
        this.observations = observations;
        this.workPermit = workPermit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public WorkPermit getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(WorkPermit workPermit) {
        this.workPermit = workPermit;
    }
}
