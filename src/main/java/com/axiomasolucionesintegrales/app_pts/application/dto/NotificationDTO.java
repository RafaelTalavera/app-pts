package com.axiomasolucionesintegrales.app_pts.application.dto;

import java.time.LocalDateTime;

public class NotificationDTO {
    private Long id;
    private String message;
    private String recipientEmail;
    private LocalDateTime sentAt;
}
