package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.PaisDTO;
import com.hd.apihd.entity.PaisEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.PaisRepository;

@Service
public class PaisService {
    @Autowired
    PaisRepository paisRepository;

    public List<PaisEntity> getAll() {
        return paisRepository.findAll();
    }

    public PaisEntity getOne(Integer id) throws ResourceNotFoundException {
        return paisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public PaisEntity save(PaisDTO dto) throws AttributeException {
        if (paisRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("Ya existe el Pais");
        PaisEntity pais = new PaisEntity(dto.getId(), dto.getNombre(), dto.getStatus(), dto.getFechacreacion()
        );
                
        return paisRepository.save(pais);
    }

    public PaisEntity update(Integer id, PaisDTO dto) throws ResourceNotFoundException, AttributeException {
        PaisEntity pais = paisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (paisRepository.existsByDpi(dto.getDpi()) && paisRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        pais.setNombre(dto.getNombre());
        pais.setStatus(dto.getStatus());
        pais.setFechacreacion(dto.getFechacreacion());
        return paisRepository.save(pais);
    }

    public PaisEntity delete(Integer id) throws ResourceNotFoundException {
        PaisEntity pais = paisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        paisRepository.delete(pais);
        return pais;
    }

}
