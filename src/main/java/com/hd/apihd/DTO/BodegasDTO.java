package com.hd.apihd.DTO;



import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class BodegasDTO {
    private Integer id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    @NotBlank(message = "Ingrese una Sede") 
    private Integer idSite;
    @NotNull(message = "Ingrese Fecha de Creacion")
    private Date fechacreacion;


    public BodegasDTO() {
    }

    public BodegasDTO(Integer id, String nombre, Integer idSite, Date fechacreacion) {
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