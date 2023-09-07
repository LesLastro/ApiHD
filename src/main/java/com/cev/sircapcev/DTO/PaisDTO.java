package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

   //Not blanck es para validar el un formulario no este en blanco.
    //@NotBlank(message = "dpi is mandatory")
   // private  String dpi;
    //Not null es para fechas
   // @NotNull(message = "fechaAsignación is mandatory")
   // private Date fechaAsignacion;

public class PaisDTO {
    private Integer id;
    @NotBlank(message = "Ingrese un Nombre") 
    private String nombre;
    @NotBlank(message = "Ingrese Status")
    private String status;
    @NotNull(message = "Ingrese Fecha de Creacion")
    private Date fechacreacion;


    public PaisDTO() {
    }

    public PaisDTO(Integer id, String nombre, String status, Date fechacreacion) {
        this.id = id;
        this.nombre = nombre;
        this.status = status;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }


   }
