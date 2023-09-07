package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.TipoSolicitudDTO;
import com.hd.apihd.entity.TipoSolicitudEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.TipoSolicitudRepository;

@Service
public class TipoSolicitudService {
    @Autowired
    TipoSolicitudRepository tipoSolicitudRepository;

    public List<TipoSolicitudEntity> getAll() {
        return tipoSolicitudRepository.findAll();
    }

    public TipoSolicitudEntity getOne(Integer id) throws ResourceNotFoundException {
        return tipoSolicitudRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public TipoSolicitudEntity save(TipoSolicitudDTO dto) throws AttributeException {
        if (tipoSolicitudRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("Ya existe el TipoSolicitud");
        TipoSolicitudEntity tipoSolicitud = new TipoSolicitudEntity(dto.getId(), dto.getNombre()
        );
                
        return tipoSolicitudRepository.save(tipoSolicitud);
    }

    public TipoSolicitudEntity update(Integer id, TipoSolicitudDTO dto) throws ResourceNotFoundException, AttributeException {
        TipoSolicitudEntity tipoSolicitud = tipoSolicitudRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (tipoSolicitudRepository.existsByDpi(dto.getDpi()) && tipoSolicitudRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        tipoSolicitud.setNombre(dto.getNombre());
        return tipoSolicitudRepository.save(tipoSolicitud);
    }

    public TipoSolicitudEntity delete(Integer id) throws ResourceNotFoundException {
        TipoSolicitudEntity tipoSolicitud = tipoSolicitudRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        tipoSolicitudRepository.delete(tipoSolicitud);
        return tipoSolicitud;
    }

}
