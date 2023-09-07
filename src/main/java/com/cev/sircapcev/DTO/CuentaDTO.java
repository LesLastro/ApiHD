package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CuentaDTO {
    private Long id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    @NotBlank(message = "Ingrese Estatus")
    private String estatus;
    @NotNull(message = "Ingrese Fecha de Creacion")
    private Date fechacreacion;


    public CuentaDTO() {
    }

    public CuentaDTO(Long id, String nombre, String estatus, Date fechacreacion) {
        this.id = id;
        this.nombre = nombre;
        this.estatus = estatus;
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

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    
}
