package com.cev.sircapcev.controllers;


import java.util.List;

import javax.validation.Valid;

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

import com.cev.sircapcev.DTO.AsignacionDTO;
import com.cev.sircapcev.entity.AsignacionEntity;
import com.cev.sircapcev.global.dto.MessageDto;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.services.AsignacionService;

@RestController
@RequestMapping("/asignacion")
@CrossOrigin
public class AsignacionController {
    @Autowired
    AsignacionService asignacionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<AsignacionEntity>> getAll() {
        return ResponseEntity.ok(asignacionService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<AsignacionEntity> getOne(@PathVariable("id") String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(asignacionService.getOne(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody AsignacionDTO dto) throws AttributeException {
        AsignacionEntity asignacion = asignacionService.save(dto);
        String message = "Asignacion " + asignacion.getDpi() + " have been created";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") String id, @Valid @RequestBody AsignacionDTO dto)
            throws ResourceNotFoundException, AttributeException {
        AsignacionEntity asignacion = asignacionService.update(id, dto);
        String message = "Asignacion " + asignacion.getDpi() + " have been updated";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") String id) throws ResourceNotFoundException {
        AsignacionEntity asignacion = asignacionService.delete(id);
        String message = "Asignacion " + asignacion.getDpi() + " have been deleted";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
