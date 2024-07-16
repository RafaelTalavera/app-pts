package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.ControlMeasureDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.ControlMeasure;

import java.util.List;
import java.util.Optional;

public interface IControlMeasureService {

    public List<ControlMeasureDTO> findAll();

    public Optional<ControlMeasureDTO> findById(Long id);

    public ControlMeasureDTO createControlMeasure(ControlMeasureDTO controlMeasureDTO);

    ControlMeasureDTO update(Long id, ControlMeasureDTO controlMeasureDTO);

    public void deletedById(Long id);
}
