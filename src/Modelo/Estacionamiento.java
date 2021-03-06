package Modelo;
// Generated 16-mar-2019 23:47:48 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Estacionamiento generated by hbm2java
 */
public class Estacionamiento  implements java.io.Serializable {


     private Integer numeroTicket;
     private Persona persona;
     private Puesto puesto;
     private Tipovehiculo tipovehiculo;
     private String patente;
     private String propietario;
     private Date fechaIngreso;
     private Date fechaSalida;
     private Double importe;

    public Estacionamiento() {
    }

	
    public Estacionamiento(Persona persona, Puesto puesto, String patente, String propietario, Date fechaIngreso) {
        this.persona = persona;
        this.puesto = puesto;
        this.patente = patente;
        this.propietario = propietario;
        this.fechaIngreso = fechaIngreso;
    }
    public Estacionamiento(Persona persona, Puesto puesto, Tipovehiculo tipovehiculo, String patente, String propietario, Date fechaIngreso, Date fechaSalida, Double importe) {
       this.persona = persona;
       this.puesto = puesto;
       this.tipovehiculo = tipovehiculo;
       this.patente = patente;
       this.propietario = propietario;
       this.fechaIngreso = fechaIngreso;
       this.fechaSalida = fechaSalida;
       this.importe = importe;
    }
   
    public Integer getNumeroTicket() {
        return this.numeroTicket;
    }
    
    public void setNumeroTicket(Integer numeroTicket) {
        this.numeroTicket = numeroTicket;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Puesto getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    public Tipovehiculo getTipovehiculo() {
        return this.tipovehiculo;
    }
    
    public void setTipovehiculo(Tipovehiculo tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }
    public String getPatente() {
        return this.patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public String getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Date getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public Double getImporte() {
        return this.importe;
    }
    
    public void setImporte(Double importe) {
        this.importe = importe;
    }




}


