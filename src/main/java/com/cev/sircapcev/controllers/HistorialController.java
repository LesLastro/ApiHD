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

import com.cev.sircapcev.DTO.HistorialDTO;
import com.cev.sircapcev.entity.HistorialEntity;
import com.cev.sircapcev.global.dto.MessageDto;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.services.HistorialService;

@RestController
@RequestMapping("/historial")
@CrossOrigin
public class HistorialController {
    @Autowired
    HistorialService historialService;

    @GetMapping
    public ResponseEntity<List<HistorialEntity>> getAll() {
        return ResponseEntity.ok(historialService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialEntity> getOne(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(historialService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody HistorialDTO dto) throws AttributeException {
        HistorialEntity historial = historialService.save(dto);
        String message = "historial " + historial.getIdbodega_Or() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Integer id, @Valid @RequestBody HistorialDTO dto)
            throws ResourceNotFoundException, AttributeException {
        HistorialEntity historial = historialService.update(id, dto);
        String message = "historial " + historial.getIdbodega_Or() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        HistorialEntity historial = historialService.delete(id);
        String message = "historial " + historial.getIdbodega_Or() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
