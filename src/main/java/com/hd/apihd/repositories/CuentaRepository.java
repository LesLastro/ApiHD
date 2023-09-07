package com.hd.apihd.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.CuentaEntity;


@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    boolean existsByNombre(String nombre);
    Optional<CuentaEntity> findByNombre(String nombre);
    
}
