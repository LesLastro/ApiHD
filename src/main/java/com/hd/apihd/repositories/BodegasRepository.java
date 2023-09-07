package com.hd.apihd.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.BodegasEntity;


@Repository
public interface BodegasRepository extends JpaRepository<BodegasEntity, Integer> {
    boolean existsByNombre(String nombre);
    Optional<BodegasEntity> findByNombre(String nombre);
    
}
