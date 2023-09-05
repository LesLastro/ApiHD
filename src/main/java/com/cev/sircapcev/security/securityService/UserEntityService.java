package com.cev.sircapcev.security.securityService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.utils.Operations;
import com.cev.sircapcev.security.jwt.JwtProvider;
import com.cev.sircapcev.security.securityDTO.CreateUserDTO;
import com.cev.sircapcev.security.securityDTO.JwtTokenDTO;
import com.cev.sircapcev.security.securityDTO.LoginUserDTO;
import com.cev.sircapcev.security.securityEntity.UserEntity;
import com.cev.sircapcev.security.securityEnums.RoleEnum;
import com.cev.sircapcev.security.securityRespository.UserEntityRepository;

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
    
    public UserEntity create(CreateUserDTO dto) throws AttributeException{
        if (userEntityRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("Username already in use");
        if (userEntityRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("Email already in use");
        if (dto.getRoles().isEmpty())
            throw new AttributeException("Roles are mandatory");
        return userEntityRepository.save(mapUserFromDto(dto));
    }

    public UserEntity createAdmin(CreateUserDTO dto) throws AttributeException{
        if (userEntityRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("Username already in use");
        if (userEntityRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("Email already in use");
        List<String> roles = Arrays.asList("ROLE_ADMIN", "ROLE_USER");
        dto.setRoles(roles);
        return userEntityRepository.save(mapUserFromDto(dto));
    }

        public UserEntity createUser(CreateUserDTO dto) throws AttributeException{
        if (userEntityRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("Username already in use");
        if (userEntityRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("Email already in use");
        List<String> roles = Arrays.asList("ROLE_USER");
        dto.setRoles(roles);
        return userEntityRepository.save(mapUserFromDto(dto));
    }

    public JwtTokenDTO login(LoginUserDTO dto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new JwtTokenDTO(token);
      
    }
    

    private UserEntity mapUserFromDto(CreateUserDTO dto) {
        int id = Operations.autoIncrement(userEntityRepository.findAll());
        String password = passwordEncoder.encode(dto.getPassword());
        List<RoleEnum> roles = dto.getRoles().stream().map(rol -> RoleEnum.valueOf(rol)).collect(Collectors.toList());
        return new UserEntity(id, dto.getUsername(), dto.getEmail(), password,roles);       
    }
}
