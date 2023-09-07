package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.HistorialDTO;
import com.hd.apihd.entity.HistorialEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.HistorialRepository;

@Service
public class HistorialService {
    @Autowired
    HistorialRepository historialRepository;

    public List<HistorialEntity> getAll() {
        return historialRepository.findAll();
    }

    public HistorialEntity getOne(Integer id) throws ResourceNotFoundException {
        return historialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public HistorialEntity save(HistorialDTO dto) throws AttributeException {
        if (historialRepository.existsById(dto.getId()))
            throw new AttributeException("Ya existe el Historial");
        HistorialEntity historial = new HistorialEntity(dto.getId(), dto.getIdbodega_Or(), dto.getIdbodega_Des(), dto.getIdusuario(), dto.getId_Tipo_Sol(), dto.getId_Equipo(), dto.getId_Cuenta(), dto.getEstado(), dto.getConsumible(), dto.getFechasolicitud()
        );
                
        return historialRepository.save(historial);
    }

    public HistorialEntity update(Integer id, HistorialDTO dto) throws ResourceNotFoundException, AttributeException {
        HistorialEntity historial = historialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (historialRepository.existsByDpi(dto.getDpi()) && historialRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        historial.setIdbodega_Or(dto.getIdbodega_Or());
        historial.setIdbodega_Des(dto.getIdbodega_Des());
        historial.setIdusuario(dto.getIdusuario());
        historial.setId_Tipo_Sol(dto.getId_Tipo_Sol());
        historial.setId_Equipo(dto.getId_Equipo());
        historial.setId_Cuenta(dto.getId_Cuenta());
        historial.setEstado(dto.getEstado());
        historial.setConsumible(dto.getConsumible());
        historial.setFechasolicitud(dto.getFechasolicitud());
        return historialRepository.save(historial);    }

    public HistorialEntity delete(Integer id) throws ResourceNotFoundException {
        HistorialEntity historial = historialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        historialRepository.delete(historial);
        return historial;
    }

}
