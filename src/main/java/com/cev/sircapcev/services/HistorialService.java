package com.cev.sircapcev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.sircapcev.DTO.HistorialDTO;
import com.cev.sircapcev.entity.HistorialEntity;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.repositories.HistorialRepository;

@Service
public class HistorialService {
    @Autowired
    HistorialRepository historialRepository;

    public List<HistorialEntity> getAll() {
        return historialRepository.findAll();
    }

    public HistorialEntity getOne(String id) throws ResourceNotFoundException {
        return historialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public HistorialEntity save(HistorialDTO dto) throws AttributeException {
        if (historialRepository.existsByIdBodegaOr(dto.getIdBodegaOr()))
            throw new AttributeException("Ya existe el Historial");
        HistorialEntity historial = new HistorialEntity(dto.getId(), dto.getIdBodegaOr(), dto.getIdbodegaDes(), dto.getIdusuario(), dto.getIdTipoSol(), dto.getIdEquipo(), dto.getIdCuenta(), dto.getEstado(), dto.getConsumible(), dto.getFechasolicitud()
        );
                
        return historialRepository.save(historial);
    }

    public HistorialEntity update(String id, HistorialDTO dto) throws ResourceNotFoundException, AttributeException {
        HistorialEntity historial = historialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (historialRepository.existsByDpi(dto.getDpi()) && historialRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        historial.setIdbodegaOr(dto.getIdBodegaOr());
        historial.setIdbodegaDes(dto.getIdbodegaDes());
        historial.setIdusuario(dto.getIdusuario());
        historial.setIdTipoSol(dto.getIdTipoSol());
        historial.setIdEquipo(dto.getIdEquipo());
        historial.setIdCuenta(dto.getIdCuenta());
        historial.setEstado(dto.getEstado());
        historial.setConsumible(dto.getConsumible());
        historial.setFechasolicitud(dto.getFechasolicitud());
        return historialRepository.save(historial);    }

    public HistorialEntity delete(String id) throws ResourceNotFoundException {
        HistorialEntity historial = historialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        historialRepository.delete(historial);
        return historial;
    }

}
