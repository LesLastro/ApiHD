package com.hd.apihd.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.EquipoEntity;


@Repository
public interface EquipoRepository extends JpaRepository<EquipoEntity, Integer> {
    boolean existsBySerial(String Serial);
    Optional<EquipoEntity> findBySerial(String Serial);
    
}
