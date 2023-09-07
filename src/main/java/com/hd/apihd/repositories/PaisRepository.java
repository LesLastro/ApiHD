package com.hd.apihd.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.PaisEntity;


@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Integer> {
    boolean existsByNombre(String nombre);
    Optional<PaisEntity> findByNombre(String nombre);
    
}
