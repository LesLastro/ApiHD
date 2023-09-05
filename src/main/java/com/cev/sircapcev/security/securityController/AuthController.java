package com.cev.sircapcev.security.securityController;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cev.sircapcev.security.securityService.UserEntityService;
import com.cev.sircapcev.global.dto.MessageDto;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.security.securityDTO.CreateUserDTO;
import com.cev.sircapcev.security.securityDTO.JwtTokenDTO;
import com.cev.sircapcev.security.securityDTO.LoginUserDTO;
import com.cev.sircapcev.security.securityEntity.UserEntity;


@Controller
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    UserEntityService userEntityService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> create(@Valid @RequestBody CreateUserDTO dto) throws AttributeException{
        UserEntity userEntity = userEntityService.create(dto);
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, " user " + userEntity.getUsername() + " have been created"));
    }

        @PostMapping("/create-admin")
    public ResponseEntity<MessageDto> createAdmin(@Valid @RequestBody CreateUserDTO dto) throws AttributeException{
        UserEntity userEntity = userEntityService.createAdmin(dto);
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, " admin " + userEntity.getUsername() + " have been created"));
    }
        @PostMapping("/create-user")
    public ResponseEntity<MessageDto> createUser(@Valid @RequestBody CreateUserDTO dto) throws AttributeException{
        UserEntity userEntity = userEntityService.createUser(dto);
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, " user " + userEntity.getUsername() + " have been created"));
    }
    @PostMapping("/login")
    public ResponseEntity<JwtTokenDTO> create(@Valid @RequestBody LoginUserDTO dto) throws AttributeException{
        JwtTokenDTO JwtTokenDTO = userEntityService.login(dto);
        return ResponseEntity.ok(JwtTokenDTO);
    }
}
