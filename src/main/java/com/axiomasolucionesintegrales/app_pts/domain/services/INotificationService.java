package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.NotificationDTO;

import java.util.List;
import java.util.Optional;

public interface INotificationService {

    public List<NotificationDTO> findAll();

    public Optional<NotificationDTO> findById(Long id);

    public NotificationDTO createNotificationDTO(NotificationDTO notificationDTO);

    NotificationDTO update(Long id, NotificationDTO notificationDTO);

    public void deletedById(Long id);
}
