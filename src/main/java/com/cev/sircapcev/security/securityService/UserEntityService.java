package com.cev.sircapcev.security.securityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.security.jwt.JwtProvider;
import com.cev.sircapcev.security.securityDTO.CreateUserDTO;
import com.cev.sircapcev.security.securityDTO.JwtTokenDTO;
import com.cev.sircapcev.security.securityDTO.LoginUserDTO;
import com.cev.sircapcev.security.securityEntity.RoleEntity;
import com.cev.sircapcev.security.securityEntity.UserEntity;
import com.cev.sircapcev.security.securityRespository.UserEntityRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityService {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    public UserEntity create(CreateUserDTO dto) throws AttributeException {
        validateUserAttributes(dto.getUsername(), dto.getEmail(), dto.getRoles());
        return userEntityRepository.save(mapUserFromDto(dto));
    }

    public UserEntity createAdmin(CreateUserDTO dto) throws AttributeException {
        validateUserAttributes(dto.getUsername(), dto.getEmail(), Collections.singletonList("ROLE_ADMIN"));
        return userEntityRepository.save(mapUserFromDto(dto));
    }

    public UserEntity createUser(CreateUserDTO dto) throws AttributeException {
        validateUserAttributes(dto.getUsername(), dto.getEmail(), Collections.singletonList("ROLE_USER"));
        return userEntityRepository.save(mapUserFromDto(dto));
    }

    public JwtTokenDTO login(LoginUserDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new JwtTokenDTO(token);
    }

    private UserEntity mapUserFromDto(CreateUserDTO dto) {
        String password = passwordEncoder.encode(dto.getPassword());
        List<RoleEntity> roles = dto.getRoles().stream()
                .map(roleName -> new RoleEntity(null, roleName, null)) // Aquí creas objetos RoleEntity basados en los nombres de roles
                .collect(Collectors.toList());
        return new UserEntity(dto.getId(), dto.getUsername(), dto.getEmail(), password, roles);
    }

    private void validateUserAttributes(String username, String email, List<String> roles) throws AttributeException {
        if (userEntityRepository.existsByUsername(username)) {
            throw new AttributeException("Username already in use");
        }
        if (userEntityRepository.existsByEmail(email)) {
            throw new AttributeException("Email already in use");
        }
        if (roles == null || roles.isEmpty()) {
            throw new AttributeException("Roles are mandatory");
        }
    }
}
