package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.RiskDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.RiskMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.Risk;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.RiskRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.IRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RiskServiceImplements implements IRiskService {

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private RiskMapper riskMapper;

    @Override
    public List<RiskDTO> findAll() {
        Iterable<Risk> risks = riskRepository.findAll();
        return StreamSupport.stream(risks.spliterator(), false)
                .map(riskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RiskDTO> findById(Long id) {
        return riskRepository.findById(id)
                .map(riskMapper::toDTO);
    }

    @Override
    public RiskDTO createRisk(RiskDTO riskDTO) {
        Risk risk = riskMapper.toEntity(riskDTO);
        risk = riskRepository.save(risk);
        return riskMapper.toDTO(risk);
    }

    @Override
    public RiskDTO updateRisk(Long id, RiskDTO riskDTO) {
        Optional<Risk> existingRisk = riskRepository.findById(id);
        if (existingRisk.isPresent()) {
            Risk risk = riskMapper.toEntity(riskDTO);
            risk.setId(id);
            risk = riskRepository.save(risk);
            return riskMapper.toDTO(risk);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRisk(Long id) {
        riskRepository.deleteById(id);
    }
}