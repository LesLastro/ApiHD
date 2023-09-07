package com.cev.sircapcev.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.entity.TipoSolicitudEntity;

@Repository
public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitudEntity, String> {
    boolean existsByNombre(String nombre);
    Optional<TipoSolicitudEntity> findByNombre(String nombre);
    
}
