package com.hd.apihd.DTO;


import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class EquipoDTO {
    private Integer id;
    @NotBlank(message = "Ingrese ServiceTag") 
    private String serial;
    @NotBlank(message = "Ingrese Bodega")
    private Integer idBodega;
    @NotBlank(message = "Ingrese Cuenta")
    private Integer idCuenta;
    @NotBlank(message = "Ingrese Estado")
    private String estado;
    @NotNull(message = "Ingrese Fecha de Modificacion")
    private Date fechaMod;


    public EquipoDTO() {
    }

    public EquipoDTO(Integer id, String serial, Integer idBodega, Integer idCuenta, String estado, Date fechaMod) {
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
