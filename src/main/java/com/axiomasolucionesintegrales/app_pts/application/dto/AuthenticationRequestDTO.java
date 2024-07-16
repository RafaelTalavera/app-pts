package com.axiomasolucionesintegrales.app_pts.application.dto;

public record AuthenticationRequestDTO(
        String username,
        String password
) {
}