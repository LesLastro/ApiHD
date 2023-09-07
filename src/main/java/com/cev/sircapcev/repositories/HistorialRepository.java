package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.HistorialEntity;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Integer> {
    boolean existsByIdBodegaOr(Integer idBodegaOr);
    Optional<HistorialEntity> findByIdexistsByIdBodegaOr(Integer idBodegaOr);
    
}
