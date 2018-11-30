/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.security.Timestamp;

/**
 *
 * @author Marina Belén
 */
public class Estacionamiento {
   private int idIngreso;
   private String patente;
   private String propietario;
   private Timestamp fechaIngreso;
   private Timestamp fechaSalida;
   private  double importe;
   private Persona atendidoPor;
   private TarifaVehiculo tipoVehiculo;

    public Estacionamiento(int idIngreso, String patente, String propietario, Timestamp fechaIngreso, Persona atendidoPor, TarifaVehiculo tipoVechiculo) {
        this.idIngreso = idIngreso;
        this.patente = patente;
        this.propietario = propietario;
        this.fechaIngreso = fechaIngreso;
        this.atendidoPor = atendidoPor;
        this.tipoVehiculo=tipoVehiculo;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Persona getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(Persona atendidoPor) {
        this.atendidoPor = atendidoPor;
    }

    public TarifaVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TarifaVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    
   
   
    
    
}
