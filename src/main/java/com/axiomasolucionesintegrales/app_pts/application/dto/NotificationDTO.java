package com.axiomasolucionesintegrales.app_pts.application.dto;



import java.time.LocalDateTime;


public class NotificationDTO {
    private Long id;
    private String message;
    private String recipientEmail;
    private LocalDateTime sentAt;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, String message, String recipientEmail, LocalDateTime sentAt) {
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
