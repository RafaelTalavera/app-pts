package com.axiomasolucionesintegrales.app_pts.domain.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<UserDTO> findAll();

    public Optional<UserDTO> findById(Long id);

    public UserDTO createUser(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);

    public void deletedById(Long id);

    public String extractUserEmailFromToken(String token);

    public Long extractUserIdFromToken(String token);

    boolean existsByUsername(String username);
}
