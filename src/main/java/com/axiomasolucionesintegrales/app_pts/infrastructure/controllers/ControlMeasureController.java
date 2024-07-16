package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.ControlMeasureDTO;
import com.axiomasolucionesintegrales.app_pts.application.services.ControlMeasureServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/controlMeasures")
public class ControlMeasureController {

    @Autowired
    private ControlMeasureServiceImplements controlMeasureService;

    @GetMapping
    public ResponseEntity<List<ControlMeasureDTO>> getAllControlMeasures() {
        List<ControlMeasureDTO> controlMeasures = controlMeasureService.findAll();
        return ResponseEntity.ok(controlMeasures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlMeasureDTO> getControlMeasureById(@PathVariable Long id) {
        Optional<ControlMeasureDTO> controlMeasure = controlMeasureService.findById(id);
        return controlMeasure.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ControlMeasureDTO> createControlMeasure(@RequestBody ControlMeasureDTO controlMeasureDTO) {
        ControlMeasureDTO createdControlMeasure = controlMeasureService.createControlMeasure(controlMeasureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdControlMeasure);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlMeasureDTO> updateControlMeasure(@PathVariable Long id, @RequestBody ControlMeasureDTO controlMeasureDTO) {
        ControlMeasureDTO updatedControlMeasure = controlMeasureService.updateControlMeasure(id, controlMeasureDTO);
        if (updatedControlMeasure != null) {
            return ResponseEntity.ok(updatedControlMeasure);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControlMeasure(@PathVariable Long id) {
        controlMeasureService.deleteControlMeasure(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
