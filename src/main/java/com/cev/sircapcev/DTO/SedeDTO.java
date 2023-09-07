package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class SedeDTO {
    private Long id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    @NotBlank(message = "Ingrese un Pais") 
    private Long idPais;  
    @NotBlank(message = "Ingrese Status")
    private String status;
    @NotNull(message = "Ingrese Fecha de Creacion")
    private Date creacion;


    public SedeDTO() {
    }


    public SedeDTO(Long id, String nombre, Long idPais, String status, Date creacion) {
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