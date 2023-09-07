package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.SedeEntity;

@Repository
public interface SedeRepository extends JpaRepository<SedeEntity, String> {
    boolean existsByNombre(String nombre);
    Optional<SedeEntity> findByNombre(String nombre);
    
}