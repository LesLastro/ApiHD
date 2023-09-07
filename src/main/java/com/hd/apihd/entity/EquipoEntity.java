package com.hd.apihd.entity;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "equipo")
public class EquipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serial;
    private Integer idBodega;
    private Integer idCuenta;
    private String estado;
    private Date fechaMod;


    public EquipoEntity() {
    }


    public EquipoEntity(Integer id, String serial, Integer idBodega, Integer idCuenta, String estado, Date fechaMod) {
        this.id = id;
        this.serial = serial;
        this.idBodega = idBodega;
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.fechaMod = fechaMod;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getIdBodega() {
        return this.idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public Integer getIdCuenta() {
        return this.idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaMod() {
        return this.fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }
   
}