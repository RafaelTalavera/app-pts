package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.SafetyReviewDTO;
import com.axiomasolucionesintegrales.app_pts.application.services.SafetyReviewServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/safety-reviews")
public class SafetyReviewController {

    @Autowired
    private SafetyReviewServiceImplements safetyReviewService;

    @GetMapping
    public ResponseEntity<List<SafetyReviewDTO>> getAllSafetyReviews() {
        List<SafetyReviewDTO> safetyReviews = safetyReviewService.findAll();
        return ResponseEntity.ok(safetyReviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafetyReviewDTO> getSafetyReviewById(@PathVariable Long id) {
        Optional<SafetyReviewDTO> safetyReview = safetyReviewService.findById(id);
        return safetyReview.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<SafetyReviewDTO> createSafetyReview(@RequestBody SafetyReviewDTO safetyReviewDTO) {
        SafetyReviewDTO createdSafetyReview = safetyReviewService.createSafetyReview(safetyReviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSafetyReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SafetyReviewDTO> updateSafetyReview(@PathVariable Long id, @RequestBody SafetyReviewDTO safetyReviewDTO) {
        SafetyReviewDTO updatedSafetyReview = safetyReviewService.update(id, safetyReviewDTO);
        if (updatedSafetyReview != null) {
            return ResponseEntity.ok(updatedSafetyReview);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSafetyReview(@PathVariable Long id) {
        safetyReviewService.deletedById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}