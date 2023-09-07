package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.BodegasDTO;
import com.hd.apihd.entity.BodegasEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.BodegasRepository;

@Service
public class BodegasService {
    @Autowired
    BodegasRepository bodegasRepository;

    public List<BodegasEntity> getAll() {
        return bodegasRepository.findAll();
    }

    public BodegasEntity getOne(Integer id) throws ResourceNotFoundException {
        return bodegasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public BodegasEntity save(BodegasDTO dto) throws AttributeException {
        if (bodegasRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("Ya existe el Bodegas");
        BodegasEntity bodegas = new BodegasEntity(dto.getId(), dto.getNombre(), dto.getIdSite(), dto.getFechacreacion()
        );
                
        return bodegasRepository.save(bodegas);
    }

    public BodegasEntity update(Integer id, BodegasDTO dto) throws ResourceNotFoundException, AttributeException {
        BodegasEntity bodegas = bodegasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (bodegasRepository.existsByDpi(dto.getDpi()) && bodegasRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        bodegas.setNombre(dto.getNombre());
        bodegas.setIdSite(dto.getIdSite());
        bodegas.setFechacreacion(dto.getFechacreacion());
        return bodegasRepository.save(bodegas);
    }

    public BodegasEntity delete(Integer id) throws ResourceNotFoundException {
        BodegasEntity bodegas = bodegasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        bodegasRepository.delete(bodegas);
        return bodegas;
    }

}
