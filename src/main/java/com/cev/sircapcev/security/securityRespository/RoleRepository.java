package com.cev.sircapcev.security.securityRespository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.security.securityEntity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    // Puedes definir métodos personalizados para interactuar con la entidad RoleEntity si es necesario
}
