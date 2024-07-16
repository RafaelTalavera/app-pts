package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;



@Table(name= "safety_reviews")
@Entity
public class SafetyReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reviewDate;

    private String reviewer;

    private String observations;

    @ManyToOne
    @JoinColumn(name = "work_permit_id")
    private WorkPermit workPermit;

    public SafetyReview() {
    }

    public SafetyReview(Long id, LocalDateTime reviewDate, String reviewer, String observations, WorkPermit workPermit) {
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
