package com.axiomasolucionesintegrales.app_pts.domain.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;


@Table(name= "notifications")
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String recipientEmail;
    private LocalDateTime sentAt;

    public Notification() {
    }

    public Notification(Long id, String message, String recipientEmail, LocalDateTime sentAt) {
        this.id = id;
        this.message = message;
        this.recipientEmail = recipientEmail;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
