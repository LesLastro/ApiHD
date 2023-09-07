package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class EquipoDTO {
    private Long id;
    @NotBlank(message = "Ingrese ServiceTag") 
    private String serial;
    @NotBlank(message = "Ingrese Bodega")
    private Long idBodega;
    @NotBlank(message = "Ingrese Cuenta")
    private Long idCuenta;
    @NotBlank(message = "Ingrese Estado")
    private String estado;
    @NotNull(message = "Ingrese Fecha de Modificacion")
    private Date fechaMod;


    public EquipoDTO() {
    }

    public EquipoDTO(Long id, String serial, Long idBodega, Long idCuenta, String estado, Date fechaMod) {
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
