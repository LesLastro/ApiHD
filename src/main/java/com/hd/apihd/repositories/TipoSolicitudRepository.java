package com.hd.apihd.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.TipoSolicitudEntity;


@Repository
public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitudEntity, Integer> {
    boolean existsByNombre(String nombre);
    Optional<TipoSolicitudEntity> findByNombre(String nombre);
    
}
