package com.cev.sircapcev.DTO;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class HistorialDTO {
    private Long id;
    @NotBlank(message = "Ingrese una Bodega Origen") 
    private Long idBodegaOr;
    @NotBlank(message = "Ingrese una Bodega Destino") 
    private Long idbodegaDes;
    @NotBlank(message = "Ingrese su Usuario") 
    private Long idusuario;
    @NotBlank(message = "Ingrese Tipo de Solicitud") 
    private Long idTipoSol;
    @NotBlank(message = "Ingrese una Equipo") 
    private Long idEquipo;
    @NotBlank(message = "Ingrese una Cuenta") 
    private Long idCuenta;
    @NotBlank(message = "Ingrese el Estado") 
    private String estado;
    @NotBlank(message = "Ingrese Consumible") 
    private String consumible;
    @NotNull(message = "Ingrese una Fecha") 
    private Date fechasolicitud;

    public HistorialDTO() {
    }


    public HistorialDTO(Long id, Long idBodegaOr, Long idbodegaDes, Long idusuario, Long idTipoSol, Long idEquipo, Long idCuenta, String estado, String consumible, Date fechasolicitud) {
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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBodegaOr() {
        return this.idBodegaOr;
    }

    public void setIdBodegaOr(Long idBodegaOr) {
        this.idBodegaOr = idBodegaOr;
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
