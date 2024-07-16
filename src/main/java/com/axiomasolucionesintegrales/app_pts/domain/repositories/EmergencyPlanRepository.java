package com.axiomasolucionesintegrales.app_pts.domain.repositories;

import com.axiomasolucionesintegrales.app_pts.domain.models.EmergencyPlan;
import org.springframework.data.repository.CrudRepository;


public interface EmergencyPlanRepository extends CrudRepository<EmergencyPlan,Long> {
}
