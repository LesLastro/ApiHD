package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.EquipoDTO;
import com.hd.apihd.entity.EquipoEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    public List<EquipoEntity> getAll() {
        return equipoRepository.findAll();
    }

    public EquipoEntity getOne(Integer id) throws ResourceNotFoundException {
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

    public EquipoEntity update(Integer id, EquipoDTO dto) throws ResourceNotFoundException, AttributeException {
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

    public EquipoEntity delete(Integer id) throws ResourceNotFoundException {
        EquipoEntity equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        equipoRepository.delete(equipo);
        return equipo;
    }

}
