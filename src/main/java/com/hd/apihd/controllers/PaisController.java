package com.hd.apihd.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.apihd.DTO.PaisDTO;
import com.hd.apihd.entity.PaisEntity;
import com.hd.apihd.global.dto.MessageDto;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.services.PaisService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pais")
@CrossOrigin
public class PaisController {
    @Autowired
    PaisService paisService;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<PaisEntity>> getAll() {
        return ResponseEntity.ok(paisService.getAll());
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PaisEntity> getOne(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(paisService.getOne(id));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody PaisDTO dto) throws AttributeException {
        PaisEntity pais = paisService.save(dto);
        String message = "pais " + pais.getNombre() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Integer id, @Valid @RequestBody PaisDTO dto)
            throws ResourceNotFoundException, AttributeException {
        PaisEntity pais = paisService.update(id, dto);
        String message = "pais " + pais.getNombre() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        PaisEntity pais = paisService.delete(id);
        String message = "pais " + pais.getNombre() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
