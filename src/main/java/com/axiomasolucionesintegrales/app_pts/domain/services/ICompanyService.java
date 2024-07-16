package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.CompanyDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {

    public List<Company> findAll();

    public Optional<Company> findById(Long id);

    public CompanyDTO creareCompany(CompanyDTO companyDTO);

    CompanyDTO update(Long id, CompanyDTO companyDTO);

    public void deletedById(Long id);

}
