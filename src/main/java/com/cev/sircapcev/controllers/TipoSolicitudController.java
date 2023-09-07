package com.cev.sircapcev.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cev.sircapcev.DTO.TipoSolicitudDTO;
import com.cev.sircapcev.entity.TipoSolicitudEntity;
import com.cev.sircapcev.global.dto.MessageDto;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.services.TipoSolicitudService;

@RestController
@RequestMapping("/tipoSolicitud")
@CrossOrigin
public class TipoSolicitudController {
    @Autowired
    TipoSolicitudService tipoSolicitudService;

    @GetMapping
    public ResponseEntity<List<TipoSolicitudEntity>> getAll() {
        return ResponseEntity.ok(tipoSolicitudService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoSolicitudEntity> getOne(@PathVariable("id") String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(tipoSolicitudService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody TipoSolicitudDTO dto) throws AttributeException {
        TipoSolicitudEntity tipoSolicitud = tipoSolicitudService.save(dto);
        String message = "tipoSolicitud " + tipoSolicitud.getNombre() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") String id, @Valid @RequestBody TipoSolicitudDTO dto)
            throws ResourceNotFoundException, AttributeException {
        TipoSolicitudEntity tipoSolicitud = tipoSolicitudService.update(id, dto);
        String message = "tipoSolicitud " + tipoSolicitud.getNombre() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") String id) throws ResourceNotFoundException {
        TipoSolicitudEntity tipoSolicitud = tipoSolicitudService.delete(id);
        String message = "tipoSolicitud " + tipoSolicitud.getNombre() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
