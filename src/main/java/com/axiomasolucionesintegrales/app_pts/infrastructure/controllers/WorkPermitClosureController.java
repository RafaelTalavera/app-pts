package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitClosureDTO;
import com.axiomasolucionesintegrales.app_pts.application.services.WorkPermitClosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/work-permit-closures")
public class WorkPermitClosureController {

    @Autowired
    private WorkPermitClosureService workPermitClosureService;

    @GetMapping
    public ResponseEntity<List<WorkPermitClosureDTO>> getAllWorkPermitClosures() {
        List<WorkPermitClosureDTO> closures = workPermitClosureService.findAll();
        return ResponseEntity.ok(closures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkPermitClosureDTO> getWorkPermitClosureById(@PathVariable Long id) {
        Optional<WorkPermitClosureDTO> closure = workPermitClosureService.findById(id);
        return closure.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<WorkPermitClosureDTO> createWorkPermitClosure(@RequestBody WorkPermitClosureDTO workPermitClosureDTO) {
        WorkPermitClosureDTO createdClosure = workPermitClosureService.createWorkPermitClosure(workPermitClosureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClosure);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkPermitClosureDTO> updateWorkPermitClosure(@PathVariable Long id, @RequestBody WorkPermitClosureDTO workPermitClosureDTO) {
        WorkPermitClosureDTO updatedClosure = workPermitClosureService.update(id, workPermitClosureDTO);
        if (updatedClosure != null) {
            return ResponseEntity.ok(updatedClosure);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkPermitClosure(@PathVariable Long id) {
        workPermitClosureService.deletedById(id);
        return ResponseEntity.noContent().build();
    }
}