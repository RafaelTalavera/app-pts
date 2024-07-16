package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitClosureDTO;

import java.util.List;
import java.util.Optional;

public interface IWorkPermitClosureService {

    public List<WorkPermitClosureDTO> findAll();

    public Optional<WorkPermitClosureDTO> findById(Long id);

    public WorkPermitClosureDTO createWorkPermitClosure(WorkPermitClosureDTO workPermitClosureDTO);

    WorkPermitClosureDTO update(Long id, WorkPermitClosureDTO workPermitClosureDTO);

    public void deletedById(Long id);
}
