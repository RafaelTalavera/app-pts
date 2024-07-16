package com.axiomasolucionesintegrales.app_pts.domain.repositories;

import com.axiomasolucionesintegrales.app_pts.domain.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long> {
}
