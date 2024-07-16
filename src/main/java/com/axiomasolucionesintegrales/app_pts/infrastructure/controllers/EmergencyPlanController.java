package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.EmergencyPlanDTO;
import com.axiomasolucionesintegrales.app_pts.application.services.EmergencyPlanServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emergencyPlans")
public class EmergencyPlanController {

    @Autowired
    private EmergencyPlanServiceImplements emergencyPlanService;

    @GetMapping
    public ResponseEntity<List<EmergencyPlanDTO>> getAllEmergencyPlans() {
        List<EmergencyPlanDTO> emergencyPlans = emergencyPlanService.findAll();
        return ResponseEntity.ok(emergencyPlans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyPlanDTO> getEmergencyPlanById(@PathVariable Long id) {
        Optional<EmergencyPlanDTO> emergencyPlan = emergencyPlanService.findById(id);
        return emergencyPlan.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<EmergencyPlanDTO> createEmergencyPlan(@RequestBody EmergencyPlanDTO emergencyPlanDTO) {
        EmergencyPlanDTO createdEmergencyPlan = emergencyPlanService.createEmergencyPlan(emergencyPlanDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmergencyPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyPlanDTO> updateEmergencyPlan(@PathVariable Long id, @RequestBody EmergencyPlanDTO emergencyPlanDTO) {
        EmergencyPlanDTO updatedEmergencyPlan = emergencyPlanService.updateEmergencyPlan(id, emergencyPlanDTO);
        if (updatedEmergencyPlan != null) {
            return ResponseEntity.ok(updatedEmergencyPlan);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencyPlan(@PathVariable Long id) {
        emergencyPlanService.deleteEmergencyPlan(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
