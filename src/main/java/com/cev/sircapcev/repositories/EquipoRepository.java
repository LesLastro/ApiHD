package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.EquipoEntity;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoEntity, Integer> {
    boolean existsBySerial(String Serial);
    Optional<EquipoEntity> findBySerial(String Serial);
    
}
