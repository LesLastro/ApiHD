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

import com.hd.apihd.DTO.BodegasDTO;
import com.hd.apihd.entity.BodegasEntity;
import com.hd.apihd.global.dto.MessageDto;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.services.BodegasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin
public class BodegasController {
    @Autowired
    BodegasService bodegasService;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<BodegasEntity>> getAll() {
        return ResponseEntity.ok(bodegasService.getAll());
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<BodegasEntity> getOne(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(bodegasService.getOne(id));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody BodegasDTO dto) throws AttributeException {
        BodegasEntity bodegas = bodegasService.save(dto);
        String message = "bodegas " + bodegas.getNombre() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Integer id, @Valid @RequestBody BodegasDTO dto)
            throws ResourceNotFoundException, AttributeException {
        BodegasEntity bodegas = bodegasService.update(id, dto);
        String message = "bodegas " + bodegas.getNombre() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        BodegasEntity bodegas = bodegasService.delete(id);
        String message = "bodegas " + bodegas.getNombre() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
