package com.cev.sircapcev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.sircapcev.DTO.AsignacionDTO;
import com.cev.sircapcev.entity.AsignacionEntity;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.repositories.AsignacionRepository;

@Service
public class AsignacionService {
    @Autowired
    AsignacionRepository asignacionRepository;

    public List<AsignacionEntity> getAll() {
        return asignacionRepository.findAll();
    }

    public AsignacionEntity getOne(String id) throws ResourceNotFoundException {
        return asignacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public AsignacionEntity save(AsignacionDTO dto) throws AttributeException {
        if (asignacionRepository.existsByDpi(dto.getDpi()))
            throw new AttributeException("dpi already in use");
        AsignacionEntity asignacion = new AsignacionEntity(dto.getId(), dto.getDpi(), dto.getAsignaturaId(),
                dto.getCicloId(), dto.getPersonaId(), dto.getUbicacion(), dto.getFechaAsignacion());
        return asignacionRepository.save(asignacion);
    }

    public AsignacionEntity update(String id, AsignacionDTO dto) throws ResourceNotFoundException, AttributeException {
        AsignacionEntity asignacion = asignacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        /*if (asignacionRepository.existsByDpi(dto.getDpi()) && asignacionRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        asignacion.setDpi(dto.getDpi());
        asignacion.setAsignaturaId(dto.getAsignaturaId());
        asignacion.setCicloId(dto.getCicloId());
        asignacion.setPersonaId(dto.getPersonaId());
        asignacion.setUbicacion(dto.getUbicacion());
        asignacion.setFechaAsignacion(dto.getFechaAsignacion());
        return asignacionRepository.save(asignacion);
    }

    public AsignacionEntity delete(String id) throws ResourceNotFoundException {
        AsignacionEntity asignacion = asignacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        ;
        asignacionRepository.delete(asignacion);
        return asignacion;
    }

}
