package com.axiomasolucionesintegrales.app_pts.application.services;

import com.axiomasolucionesintegrales.app_pts.application.dto.UserDTO;
import com.axiomasolucionesintegrales.app_pts.application.mappers.UserMapper;
import com.axiomasolucionesintegrales.app_pts.domain.models.User;
import com.axiomasolucionesintegrales.app_pts.domain.repositories.UserRepository;
import com.axiomasolucionesintegrales.app_pts.domain.services.IUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImplements implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    @Override
    public List<UserDTO> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO);
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDTO.getName());
            user.setLastname(userDTO.getLastname());
            user.setJob(userDTO.getJob());
            user.setPassword(userDTO.getPassword());
            user.setSignature(userDTO.getSignature());
            user.setUsername(userDTO.getUsername());
            user.setPhone(userDTO.getPhone());
            user.setRole(userDTO.getRole());
            user.setCompany(userDTO.getCompany());
            user = userRepository.save(user);
            return userMapper.toDTO(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    @Transactional
    public void deletedById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public String extractUserEmailFromToken(String token) {
        try {
            // Remover la palabra "Bearer " del inicio del token
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            String email = claims.getSubject(); // Assuming the email is stored as the subject in the token
            System.out.println("Email extraído del token: " + email); // Imprimir el email extraído del token
            return email;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el correo electrónico del token", e);
        }
    }

    @Override
    public Long extractUserIdFromToken(String token) {
        try {
            // Remover la palabra "Bearer " del inicio del token
            String jwtToken = token.replace("Bearer ", "");
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();
            Long userId = claims.get("userId", Long.class);
            System.out.println("User ID extraído del token: " + userId); // Imprimir el userId extraído del token
            return userId;
        } catch (Exception e) {
            throw new RuntimeException("Error al extraer el user ID del token", e);
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
