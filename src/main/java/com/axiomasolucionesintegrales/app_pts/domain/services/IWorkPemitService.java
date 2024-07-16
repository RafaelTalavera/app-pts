package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitDTO;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface IWorkPemitService {

    public List<WorkPermitDTO> findAll();

    public Optional<WorkPermitDTO> findById(Long id);

    WorkPermitDTO createWorkPermitDTO(WorkPermitDTO workPermitDTO);

    WorkPermitDTO update(Long id, WorkPermitDTO workPermitDTO);

    public void deletedById(Long id);

}
