package com.cev.sircapcev.DTO;


import javax.validation.constraints.NotBlank;


public class TipoSolicitudDTO {
    private Long id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    

    public TipoSolicitudDTO() {
    }

    public TipoSolicitudDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}