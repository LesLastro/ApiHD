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
    private Integer id;
    private String nombre;
    private Integer idSite;
    private Date fechacreacion;


    public BodegasEntity() {
    }


    public BodegasEntity(Integer id, String nombre, Integer idSite, Date fechacreacion) {
        this.id = id;
        this.nombre = nombre;
        this.idSite = idSite;
        this.fechacreacion = fechacreacion;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdSite() {
        return this.idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    }
    