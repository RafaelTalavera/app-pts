package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.SafetyReviewDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.SafetyReview;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SafetyReviewMapper {
    SafetyReviewDTO toDTO(SafetyReview safetyReview);
    SafetyReview toEntity(SafetyReviewDTO safetyReviewDTO);
}
