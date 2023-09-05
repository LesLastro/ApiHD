package com.cev.sircapcev.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignacion")
public class AsignacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dpi;
    private String asignaturaId;
    private String cicloId;
    private String personaId;
    private String ubicacion;
    private Date fechaAsignacion;

    public AsignacionEntity() {
    }

    public AsignacionEntity(Long id, String dpi, String asignaturaId, String cicloId, String personaId, String ubicacion, Date fechaAsignacion) {
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
