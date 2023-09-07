package com.hd.apihd.controllers;



import java.util.List;

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

import com.hd.apihd.DTO.EquipoDTO;
import com.hd.apihd.entity.EquipoEntity;
import com.hd.apihd.global.dto.MessageDto;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.services.EquipoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/equipo")
@CrossOrigin
public class EquipoController {
    @Autowired
    EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<EquipoEntity>> getAll() {
        return ResponseEntity.ok(equipoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoEntity> getOne(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(equipoService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody EquipoDTO dto) throws AttributeException {
        EquipoEntity equipo = equipoService.save(dto);
        String message = "equipo " + equipo.getSerial() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Integer id, @Valid @RequestBody EquipoDTO dto)
            throws ResourceNotFoundException, AttributeException {
        EquipoEntity equipo = equipoService.update(id, dto);
        String message = "equipo " + equipo.getSerial() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        EquipoEntity equipo = equipoService.delete(id);
        String message = "equipo " + equipo.getSerial() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
