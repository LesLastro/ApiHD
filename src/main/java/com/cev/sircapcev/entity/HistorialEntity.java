package com.cev.sircapcev.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historial")
public class HistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idbodegaOr;
    private Long idbodegaDes;
    private Long idusuario;
    private Long idTipoSol;
    private Long idEquipo;
    private Long idCuenta;
    private String estado;
    private String consumible;
    private Date fechasolicitud;


    public HistorialEntity() {
    }

    public HistorialEntity(Long id, Long idbodegaOr, Long idbodegaDes, Long idusuario, Long idTipoSol, Long idEquipo, Long idCuenta, String estado, String consumible, Date fechasolicitud) {
        this.id = id;
        this.idbodegaOr = idbodegaOr;
        this.idbodegaDes = idbodegaDes;
        this.idusuario = idusuario;
        this.idTipoSol = idTipoSol;
        this.idEquipo = idEquipo;
        this.idCuenta = idCuenta;
        this.estado = estado;
        this.consumible = consumible;
        this.fechasolicitud = fechasolicitud;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdbodegaOr() {
        return this.idbodegaOr;
    }

    public void setIdbodegaOr(Long idbodegaOr) {
        this.idbodegaOr = idbodegaOr;
    }

    public Long getIdbodegaDes() {
        return this.idbodegaDes;
    }

    public void setIdbodegaDes(Long idbodegaDes) {
        this.idbodegaDes = idbodegaDes;
    }

    public Long getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Long getIdTipoSol() {
        return this.idTipoSol;
    }

    public void setIdTipoSol(Long idTipoSol) {
        this.idTipoSol = idTipoSol;
    }

    public Long getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
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

    public String getConsumible() {
        return this.consumible;
    }

    public void setConsumible(String consumible) {
        this.consumible = consumible;
    }

    public Date getFechasolicitud() {
        return this.fechasolicitud;
    }

    public void setFechasolicitud(Date fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

 }   

