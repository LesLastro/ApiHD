package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class BodegasDTO {
    private Long id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    @NotBlank(message = "Ingrese una Sede") 
    private Long idSite;
    @NotNull(message = "Ingrese Fecha de Creacion")
    private Date fechacreacion;


    public BodegasDTO() {
    }

    public BodegasDTO(Long id, String nombre, Long idSite, Date fechacreacion) {
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