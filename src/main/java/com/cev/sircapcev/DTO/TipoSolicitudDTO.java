package com.cev.sircapcev.DTO;


import javax.validation.constraints.NotBlank;


public class TipoSolicitudDTO {
    private Integer id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    

    public TipoSolicitudDTO() {
    }

    public TipoSolicitudDTO(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}