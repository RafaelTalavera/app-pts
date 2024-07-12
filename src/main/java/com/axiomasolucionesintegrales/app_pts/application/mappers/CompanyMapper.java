package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.CompanyDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO toDTO(Company company);
    Company toEntity(CompanyDTO companyDTO);
}