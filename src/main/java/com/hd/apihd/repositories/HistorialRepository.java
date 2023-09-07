package com.hd.apihd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.apihd.entity.HistorialEntity;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Integer> {
   /*  boolean existsByIdbodega_Or(Integer idbodega_Or);
    Optional<HistorialEntity> findByIdexistsByIdbodega_Or(Integer idbodega_Or);*/
    
}
