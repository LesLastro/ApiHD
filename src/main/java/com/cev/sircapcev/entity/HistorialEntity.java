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
    private Integer id;
    private Integer idbodegaOr;
    private Integer idbodegaDes;
    private Integer idusuario;
    private Integer idTipoSol;
    private Integer idEquipo;
    private Integer idCuenta;
    private String estado;
    private String consumible;
    private Date fechasolicitud;


    public HistorialEntity() {
    }

    public HistorialEntity(Integer id, Integer idbodegaOr, Integer idbodegaDes, Integer idusuario, Integer idTipoSol, Integer idEquipo, Integer idCuenta, String estado, String consumible, Date fechasolicitud) {
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdbodegaOr() {
        return this.idbodegaOr;
    }

    public void setIdbodegaOr(Integer idbodegaOr) {
        this.idbodegaOr = idbodegaOr;
    }

    public Integer getIdbodegaDes() {
        return this.idbodegaDes;
    }

    public void setIdbodegaDes(Integer idbodegaDes) {
        this.idbodegaDes = idbodegaDes;
    }

    public Integer getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdTipoSol() {
        return this.idTipoSol;
    }

    public void setIdTipoSol(Integer idTipoSol) {
        this.idTipoSol = idTipoSol;
    }

    public Integer getIdEquipo() {
        return this.idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdCuenta() {
        return this.idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
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

