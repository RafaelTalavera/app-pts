package com.axiomasolucionesintegrales.app_pts.infrastructure.controllers;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/work-permits")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorkPermitRestController {

    @Autowired
    private IWorkPermitService workPermitService;

    @GetMapping
    public ResponseEntity<List<WorkPermitDTO>> getAllWorkPermits() {
        List<WorkPermitDTO> workPermits = workPermitService.findAll();
        return ResponseEntity.ok(workPermits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkPermitDTO> getWorkPermitById(@PathVariable Long id) {
        Optional<WorkPermitDTO> workPermit = workPermitService.findById(id);
        return workPermit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<WorkPermitDTO> createWorkPermit(@RequestBody WorkPermitDTO workPermitDTO) {
        WorkPermitDTO createdWorkPermit = workPermitService.createWorkPermitDTO(workPermitDTO);
        return new ResponseEntity<>(createdWorkPermit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkPermitDTO> updateWorkPermit(@PathVariable Long id, @RequestBody WorkPermitDTO workPermitDTO) {
        WorkPermitDTO updatedWorkPermit = workPermitService.update(id, workPermitDTO);
        return ResponseEntity.ok(updatedWorkPermit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkPermit(@PathVariable Long id) {
        workPermitService.deletedById(id);
        return ResponseEntity.noContent().build();
    }
}
