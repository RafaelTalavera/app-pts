package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.RiskDTO;

import java.util.List;
import java.util.Optional;

public interface IRiskService {

    public List<RiskDTO> findAll();

    public Optional<RiskDTO> findById(Long id);

    public RiskDTO createRisk(RiskDTO riskDTO);

    public RiskDTO updateRisk(Long id, RiskDTO riskDTO);

    public void deleteRisk(Long id);
}
