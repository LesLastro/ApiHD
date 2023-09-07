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

import com.hd.apihd.DTO.SedeDTO;
import com.hd.apihd.entity.SedeEntity;
import com.hd.apihd.global.dto.MessageDto;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.services.SedeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sede")
@CrossOrigin
public class SedeController {
    @Autowired
    SedeService sedeService;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<SedeEntity>> getAll() {
        return ResponseEntity.ok(sedeService.getAll());
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SedeEntity> getOne(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(sedeService.getOne(id));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody SedeDTO dto) throws AttributeException {
        SedeEntity sede = sedeService.save(dto);
        String message = "sede " + sede.getNombre() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Integer id, @Valid @RequestBody SedeDTO dto)
            throws ResourceNotFoundException, AttributeException {
        SedeEntity sede = sedeService.update(id, dto);
        String message = "sede " + sede.getNombre() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        SedeEntity sede = sedeService.delete(id);
        String message = "sede " + sede.getNombre() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
