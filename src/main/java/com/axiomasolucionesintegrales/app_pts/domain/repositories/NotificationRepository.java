package com.axiomasolucionesintegrales.app_pts.domain.repositories;

import com.axiomasolucionesintegrales.app_pts.domain.models.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {
}
