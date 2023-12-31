package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.SedeDTO;
import com.hd.apihd.entity.SedeEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.SedeRepository;

@Service
public class SedeService {
    @Autowired
    SedeRepository sedeRepository;

    public List<SedeEntity> getAll() {
        return sedeRepository.findAll();
    }

    public SedeEntity getOne(Integer id) throws ResourceNotFoundException {
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

    public SedeEntity update(Integer id, SedeDTO dto) throws ResourceNotFoundException, AttributeException {
        SedeEntity sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));

        sede.setNombre(dto.getNombre());
        sede.setStatus(dto.getStatus());
        sede.setCreacion(dto.getCreacion());
        return sedeRepository.save(sede);
    }

    public SedeEntity delete(Integer id) throws ResourceNotFoundException {
        SedeEntity sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        sedeRepository.delete(sede);
        return sede;
    }

}
