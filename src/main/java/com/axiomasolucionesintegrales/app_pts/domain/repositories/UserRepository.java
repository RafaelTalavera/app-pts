package com.axiomasolucionesintegrales.app_pts.domain.repositories;

import com.axiomasolucionesintegrales.app_pts.domain.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
