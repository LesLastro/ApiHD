package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.PaisEntity;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, String> {
    boolean existsByNombre(String nombre);
    Optional<PaisEntity> findByNombre(String nombre);
    
}
