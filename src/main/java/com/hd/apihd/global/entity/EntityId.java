package com.hd.apihd.global.entity;

import org.springframework.data.annotation.Id;

public abstract class EntityId {
    @Id
    protected int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
