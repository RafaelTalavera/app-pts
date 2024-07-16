package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.RiskDTO;
import com.axiomasolucionesintegrales.app_pts.application.services.RiskServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/risks")
public class RiskController {

    @Autowired
    private RiskServiceImplements riskService;

    @GetMapping
    public ResponseEntity<List<RiskDTO>> getAllRisks() {
        List<RiskDTO> risks = riskService.findAll();
        return ResponseEntity.ok(risks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskDTO> getRiskById(@PathVariable Long id) {
        Optional<RiskDTO> risk = riskService.findById(id);
        return risk.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<RiskDTO> createRisk(@RequestBody RiskDTO riskDTO) {
        RiskDTO createdRisk = riskService.createRisk(riskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRisk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskDTO> updateRisk(@PathVariable Long id, @RequestBody RiskDTO riskDTO) {
        RiskDTO updatedRisk = riskService.updateRisk(id, riskDTO);
        if (updatedRisk != null) {
            return ResponseEntity.ok(updatedRisk);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRisk(@PathVariable Long id) {
        riskService.deleteRisk(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}