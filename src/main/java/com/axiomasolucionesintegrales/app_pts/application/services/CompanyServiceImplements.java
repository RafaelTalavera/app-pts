package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.CompanyDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.CompanyMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.Company;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompanyServiceImplements {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyDTO> findAll() {
        Iterable<Company> companies = companyRepository.findAll();
        return StreamSupport.stream(companies.spliterator(), false)
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CompanyDTO> findById(Long id) {
        return companyRepository.findById(id)
                .map(companyMapper::toDTO);
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = companyMapper.toEntity(companyDTO);
        company = companyRepository.save(company);
        return companyMapper.toDTO(company);
    }

    public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company company = companyMapper.toEntity(companyDTO);
            company.setId(id);
            company = companyRepository.save(company);
            return companyMapper.toDTO(company);
        } else {
            return null;
        }
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
