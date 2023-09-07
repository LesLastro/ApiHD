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

import com.cev.sircapcev.DTO.CuentaDTO;
import com.cev.sircapcev.entity.CuentaEntity;
import com.cev.sircapcev.global.dto.MessageDto;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.services.CuentaService;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<CuentaEntity>> getAll() {
        return ResponseEntity.ok(cuentaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaEntity> getOne(@PathVariable("id") String id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cuentaService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody CuentaDTO dto) throws AttributeException {
        CuentaEntity cuenta = cuentaService.save(dto);
        String message = "cuenta " + cuenta.getNombre() + "Ha sido creado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") String id, @Valid @RequestBody CuentaDTO dto)
            throws ResourceNotFoundException, AttributeException {
        CuentaEntity cuenta = cuentaService.update(id, dto);
        String message = "cuenta " + cuenta.getNombre() + "Ha sido Actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") String id) throws ResourceNotFoundException {
        CuentaEntity cuenta = cuentaService.delete(id);
        String message = "cuenta " + cuenta.getNombre() + "Ha sido Eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
