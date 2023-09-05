package com.cev.sircapcev.security.securityEntity;

import java.util.List;

import javax.persistence.Table;

import com.cev.sircapcev.global.entity.EntityId;
import com.cev.sircapcev.security.securityEnums.RoleEnum;
@Table(name = "usuarios")
public class UserEntity extends EntityId {
    private String username;
    private String email;
    private String password;
    
    List<RoleEnum> roles;

    public UserEntity() {
    }

    public UserEntity(int id, String username, String email, String password, List<RoleEnum> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public int getId() {
        return super.getId();
    }
    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEnum> getRoles() {
        return this.roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    
}
