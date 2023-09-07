package com.cev.sircapcev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cev.sircapcev.DTO.EquipoDTO;
import com.cev.sircapcev.entity.EquipoEntity;
import com.cev.sircapcev.global.exceptions.AttributeException;
import com.cev.sircapcev.global.exceptions.ResourceNotFoundException;
import com.cev.sircapcev.repositories.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    public List<EquipoEntity> getAll() {
        return equipoRepository.findAll();
    }

    public EquipoEntity getOne(String id) throws ResourceNotFoundException {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public EquipoEntity save(EquipoDTO dto) throws AttributeException {
        if (equipoRepository.existsBySerial(dto.getSerial()))
            throw new AttributeException("Ya existe el Equipo");
        EquipoEntity equipo = new EquipoEntity(dto.getId(), dto.getSerial(), dto.getIdBodega(), dto.getIdCuenta(), dto.getEstado(), dto.getFechaMod()
        );
                
        return equipoRepository.save(equipo);
    }

    public EquipoEntity update(String id, EquipoDTO dto) throws ResourceNotFoundException, AttributeException {
        EquipoEntity equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (equipoRepository.existsByDpi(dto.getDpi()) && equipoRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        equipo.setSerial(dto.getSerial());
        equipo.setIdBodega(dto.getIdBodega());
        equipo.setIdCuenta(dto.getIdCuenta());
        equipo.setEstado(dto.getEstado());
        equipo.setFechaMod(dto.getFechaMod());
        return equipoRepository.save(equipo);
    }

    public EquipoEntity delete(String id) throws ResourceNotFoundException {
        EquipoEntity equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        equipoRepository.delete(equipo);
        return equipo;
    }

}
