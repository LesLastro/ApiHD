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
    private Integer idbodega_Or;
    private Integer idbodega_Des;
    private Integer idusuario;
    private Integer id_Tipo_Sol;
    private Integer id_Equipo;
    private Integer id_Cuenta;
    private String estado;
    private String consumible;
    private Date fechasolicitud;


    public HistorialEntity() {
    }

    public HistorialEntity(Integer id, Integer idbodega_Or, Integer idbodega_Des, Integer idusuario, Integer id_Tipo_Sol, Integer id_Equipo, Integer id_Cuenta, String estado, String consumible, Date fechasolicitud) {
        this.id = id;
        this.idbodega_Or = idbodega_Or;
        this.idbodega_Des = idbodega_Des;
        this.idusuario = idusuario;
        this.id_Tipo_Sol = id_Tipo_Sol;
        this.id_Equipo = id_Equipo;
        this.id_Cuenta = id_Cuenta;
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

    public Integer getIdbodega_Or() {
        return this.idbodega_Or;
    }

    public void setIdbodega_Or(Integer idbodega_Or) {
        this.idbodega_Or = idbodega_Or;
    }

    public Integer getIdbodega_Des() {
        return this.idbodega_Des;
    }

    public void setIdbodega_Des(Integer idbodega_Des) {
        this.idbodega_Des = idbodega_Des;
    }

    public Integer getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getId_Tipo_Sol() {
        return this.id_Tipo_Sol;
    }

    public void setId_Tipo_Sol(Integer id_Tipo_Sol) {
        this.id_Tipo_Sol = id_Tipo_Sol;
    }

    public Integer getId_Equipo() {
        return this.id_Equipo;
    }

    public void setId_Equipo(Integer id_Equipo) {
        this.id_Equipo = id_Equipo;
    }

    public Integer getId_Cuenta() {
        return this.id_Cuenta;
    }

    public void setId_Cuenta(Integer id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
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

   

