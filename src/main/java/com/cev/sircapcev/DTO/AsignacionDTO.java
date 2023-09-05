package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AsignacionDTO {
    private Long id;
    
    @NotBlank(message = "dpi is mandatory")
    private  String dpi;
    @NotBlank(message = "asignaturaId is mandatory")
    private String asignaturaId;
    @NotBlank(message = "cicloID is mandatory")
    private String cicloId;
    @NotBlank(message = "personaId is mandatory")
    private String personaId;
    @NotBlank(message = "ubicación is mandatory")
    private String ubicacion;
    @NotNull(message = "fechaAsignación is mandatory")
    private Date fechaAsignacion;

    public AsignacionDTO() {
    }

    public AsignacionDTO(Long id, String dpi, String asignaturaId, String cicloId, String personaId, String ubicacion, Date fechaAsignacion) {
        this.id = id;
        this.dpi = dpi;
        this.asignaturaId = asignaturaId;
        this.cicloId = cicloId;
        this.personaId = personaId;
        this.ubicacion = ubicacion;
        this.fechaAsignacion = fechaAsignacion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDpi() {
        return this.dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getAsignaturaId() {
        return this.asignaturaId;
    }

    public void setAsignaturaId(String asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getCicloId() {
        return this.cicloId;
    }

    public void setCicloId(String cicloId) {
        this.cicloId = cicloId;
    }

    public String getPersonaId() {
        return this.personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaAsignacion() {
        return this.fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }


}
