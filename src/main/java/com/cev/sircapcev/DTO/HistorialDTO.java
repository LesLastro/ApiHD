package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class HistorialDTO {
    private Integer id;
    @NotBlank(message = "Ingrese una Bodega Origen") 
    private Integer idBodegaOr;
    @NotBlank(message = "Ingrese una Bodega Destino") 
    private Integer idbodegaDes;
    @NotBlank(message = "Ingrese su Usuario") 
    private Integer idusuario;
    @NotBlank(message = "Ingrese Tipo de Solicitud") 
    private Integer idTipoSol;
    @NotBlank(message = "Ingrese una Equipo") 
    private Integer idEquipo;
    @NotBlank(message = "Ingrese una Cuenta") 
    private Integer idCuenta;
    @NotBlank(message = "Ingrese el Estado") 
    private String estado;
    @NotBlank(message = "Ingrese Consumible") 
    private String consumible;
    @NotNull(message = "Ingrese una Fecha") 
    private Date fechasolicitud;

    public HistorialDTO() {
    }


    public HistorialDTO(Integer id, Integer idBodegaOr, Integer idbodegaDes, Integer idusuario, Integer idTipoSol, Integer idEquipo, Integer idCuenta, String estado, String consumible, Date fechasolicitud) {
        this.id = id;
        this.idBodegaOr = idBodegaOr;
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

    public Integer getIdBodegaOr() {
        return this.idBodegaOr;
    }

    public void setIdBodegaOr(Integer idBodegaOr) {
        this.idBodegaOr = idBodegaOr;
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
