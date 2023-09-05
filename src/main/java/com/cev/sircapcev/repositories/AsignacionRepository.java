package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.AsignacionEntity;

@Repository
public interface AsignacionRepository extends JpaRepository<AsignacionEntity, String> {
    boolean existsByDpi(String dpi);
    Optional<AsignacionEntity> findByDpi(String dpi);
    
}
