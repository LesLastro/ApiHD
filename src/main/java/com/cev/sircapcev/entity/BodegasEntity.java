package com.cev.sircapcev.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bodegas")
public class BodegasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long idSite;
    private Date fechacreacion;


    public BodegasEntity() {
    }


    public BodegasEntity(Long id, String nombre, Long idSite, Date fechacreacion) {
        this.id = id;
        this.nombre = nombre;
        this.idSite = idSite;
        this.fechacreacion = fechacreacion;
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

    public Long getIdSite() {
        return this.idSite;
    }

    public void setIdSite(Long idSite) {
        this.idSite = idSite;
    }

    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    }
    