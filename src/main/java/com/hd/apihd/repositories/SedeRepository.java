package com.hd.apihd.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.SedeEntity;


@Repository
public interface SedeRepository extends JpaRepository<SedeEntity, Integer> {
    boolean existsByNombre(String nombre);
    Optional<SedeEntity> findByNombre(String nombre);
    
}
