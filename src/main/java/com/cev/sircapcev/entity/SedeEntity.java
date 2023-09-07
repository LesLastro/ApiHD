package com.cev.sircapcev.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class SedeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long idPais;
    private String status;
    private Date creacion;


    public SedeEntity() {
    }

    public SedeEntity(Long id, String nombre, Long idPais, String status, Date creacion) {
        this.id = id;
        this.nombre = nombre;
        this.idPais = idPais;
        this.status = status;
        this.creacion = creacion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdPais() {
        return this.idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreacion() {
        return this.creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

  }  

   