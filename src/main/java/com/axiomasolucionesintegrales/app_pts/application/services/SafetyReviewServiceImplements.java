package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.SafetyReviewDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.SafetyReviewMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.SafetyReview;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.SafetyReviewRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.ISafetyReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SafetyReviewServiceImplements implements ISafetyReviewService {

    @Autowired
    private SafetyReviewRepository safetyReviewRepository;

    @Autowired
    private SafetyReviewMapper safetyReviewMapper;

    @Override
    public List<SafetyReviewDTO> findAll() {
        Iterable<SafetyReview> safetyReviews = safetyReviewRepository.findAll();
        return StreamSupport.stream(safetyReviews.spliterator(), false)
                .map(safetyReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SafetyReviewDTO> findById(Long id) {
        return safetyReviewRepository.findById(id)
                .map(safetyReviewMapper::toDTO);
    }

    @Override
    public SafetyReviewDTO createSafetyReview(SafetyReviewDTO safetyReviewDTO) {
        SafetyReview safetyReview = safetyReviewMapper.toEntity(safetyReviewDTO);
        safetyReview = safetyReviewRepository.save(safetyReview);
        return safetyReviewMapper.toDTO(safetyReview);
    }

    @Override
    public SafetyReviewDTO update(Long id, SafetyReviewDTO safetyReviewDTO) {
        Optional<SafetyReview> existingSafetyReview = safetyReviewRepository.findById(id);
        if (existingSafetyReview.isPresent()) {
            SafetyReview safetyReview = safetyReviewMapper.toEntity(safetyReviewDTO);
            safetyReview.setId(id);
            safetyReview = safetyReviewRepository.save(safetyReview);
            return safetyReviewMapper.toDTO(safetyReview);
        } else {
            return null;
        }
    }

    @Override
    public void deletedById(Long id) {
        safetyReviewRepository.deleteById(id);
    }
}