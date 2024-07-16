package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.NotificationDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.NotificationMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.Notification;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.NotificationRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotificationServiceImplements implements INotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public List<NotificationDTO> findAll() {
        Iterable<Notification> notifications = notificationRepository.findAll();
        return StreamSupport.stream(notifications.spliterator(), false)
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NotificationDTO> findById(Long id) {
        return notificationRepository.findById(id)
                .map(notificationMapper::toDTO);
    }

    @Override
    public NotificationDTO createNotificationDTO(NotificationDTO notificationDTO) {
        Notification notification = notificationMapper.toEntity(notificationDTO);
        notification = notificationRepository.save(notification);
        return notificationMapper.toDTO(notification);
    }

    @Override
    public NotificationDTO update(Long id, NotificationDTO notificationDTO) {
        Optional<Notification> existingNotification = notificationRepository.findById(id);
        if (existingNotification.isPresent()) {
            Notification notification = notificationMapper.toEntity(notificationDTO);
            notification.setId(id);
            notification = notificationRepository.save(notification);
            return notificationMapper.toDTO(notification);
        } else {
            return null;
        }
    }

    @Override
    public void deletedById(Long id) {
        notificationRepository.deleteById(id);
    }
}