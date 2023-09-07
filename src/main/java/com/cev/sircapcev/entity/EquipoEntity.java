package com.cev.sircapcev.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipo")
public class EquipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serial;
    private Long idBodega;
    private Long idCuenta;
    private String estado;
    private Date fechaMod;


    public EquipoEntity() {
    }


    public EquipoEntity(Long id, String serial, Long idBodega, Long idCuenta, String estado, Date fechaMod) {
        this.id = id;
        this.serial = serial;
        this.idBodega = idBodega;
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.fechaMod = fechaMod;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Long getIdBodega() {
        return this.idBodega;
    }

    public void setIdBodega(Long idBodega) {
        this.idBodega = idBodega;
    }

    public Long getIdCuenta() {
        return this.idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
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