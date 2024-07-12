package com.axiomasolucionesintegrales.app_pts.application.mappers;

import com.axiomasolucionesintegrales.app_pts.application.dto.WorkPermitClosureDTO;
import com.axiomasolucionesintegrales.app_pts.domain.models.WorkPermitClosure;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkPermitClosureMapper {
    WorkPermitClosureDTO toDTO(WorkPermitClosure workPermitClosure);
    WorkPermitClosure toEntity(WorkPermitClosureDTO workPermitClosureDTO);
}

