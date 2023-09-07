package com.hd.apihd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.apihd.DTO.CuentaDTO;
import com.hd.apihd.entity.CuentaEntity;
import com.hd.apihd.global.exceptions.AttributeException;
import com.hd.apihd.global.exceptions.ResourceNotFoundException;
import com.hd.apihd.repositories.CuentaRepository;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    public List<CuentaEntity> getAll() {
        return cuentaRepository.findAll();
    }

    public CuentaEntity getOne(Integer id) throws ResourceNotFoundException {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public CuentaEntity save(CuentaDTO dto) throws AttributeException {
        if (cuentaRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("Ya existe la Cuenta");
        CuentaEntity cuenta = new CuentaEntity(dto.getId(), dto.getNombre(), dto.getEstatus(), dto.getFechacreacion()
        );
                
        return cuentaRepository.save(cuenta);
    }

    public CuentaEntity update(Integer id, CuentaDTO dto) throws ResourceNotFoundException, AttributeException {
        CuentaEntity cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        /*if (cuentaRepository.existsByDpi(dto.getDpi()) && cuentaRepository.findByDpi(dto.getDpi()).get().getId() != id)
            throw new AttributeException("dpi already in use");*/
        cuenta.setNombre(dto.getNombre());
        cuenta.setEstatus(dto.getEstatus());
        cuenta.setFechacreacion(dto.getFechacreacion());
        return cuentaRepository.save(cuenta);
    }

    public CuentaEntity delete(Integer id) throws ResourceNotFoundException {
        CuentaEntity cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro"));
        ;
        cuentaRepository.delete(cuenta);
        return cuenta;
    }

}
