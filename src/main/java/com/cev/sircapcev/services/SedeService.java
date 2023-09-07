package com.cev.sircapcev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.sircapcev.DTO.SedeDTO;
import com.cev.sircapcev.entity.SedeEntity;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.repositories.SedeRepository;

@Service
public class SedeService {
    @Autowired
    SedeRepository sedeRepository;

    public List<SedeEntity> getAll() {
        return sedeRepository.findAll();
    }

    public SedeEntity getOne(String id) throws ResourceNotFoundException {
        return sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public SedeEntity save(SedeDTO dto) throws AttributeException {
        if (sedeRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("Ya existe el Sede");
        SedeEntity sede = new SedeEntity(dto.getId(), dto.getNombre(), dto.getIdPais(), dto.getStatus(), dto.getCreacion()
        );
                
        return sedeRepository.save(sede);
    }

    public SedeEntity update(String id, SedeDTO dto) throws ResourceNotFoundException, AttributeException {
        SedeEntity sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));

        sede.setNombre(dto.getNombre());
        sede.setStatus(dto.getStatus());
        sede.setCreacion(dto.getCreacion());
        return sedeRepository.save(sede);
    }

    public SedeEntity delete(String id) throws ResourceNotFoundException {
        SedeEntity sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        sedeRepository.delete(sede);
        return sede;
    }

}
