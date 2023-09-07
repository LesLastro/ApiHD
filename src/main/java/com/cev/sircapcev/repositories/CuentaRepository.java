package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.CuentaEntity;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, String> {
    boolean existsByNombre(String nombre);
    Optional<CuentaEntity> findByNombre(String nombre);
    
}