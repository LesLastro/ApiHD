package com.cev.sircapcev.security.securityRespository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cev.sircapcev.security.securityEntity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
