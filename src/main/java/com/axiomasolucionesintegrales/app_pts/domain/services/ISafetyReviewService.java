package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.SafetyReviewDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.SafetyReview;

import java.util.List;
import java.util.Optional;

public interface ISafetyReviewService {

    public List<SafetyReviewDTO> findAll();

    public Optional<SafetyReviewDTO> findById(Long id);

    public SafetyReviewDTO createSafetyReview(SafetyReviewDTO safetyReviewDTO);

    SafetyReviewDTO update(Long id, SafetyReviewDTO safetyReviewDTO);

    public void deletedById(Long id);

}
