/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.Serializable;

/**
 *
 * @author Marina Belén
 */

public class Persona extends EntidadOID implements Serializable {
    private double dniPersona;
    private String nombrePersona;
    private String direccionPersona;
    private double telefonoPersona;
    private Usuario usuarioPersona;

    public Persona() {
    }
    

    public Persona(double dniPersona, String nombrePersona, String direccionPersona, double telefonoPersona) {
        this.dniPersona = dniPersona;
        this.nombrePersona = nombrePersona;
        this.direccionPersona = direccionPersona;
        this.telefonoPersona = telefonoPersona;
    }

    public double getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(double dniPersona) {
        this.dniPersona = dniPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public double getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(double telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public Usuario getUsuarioPersona() {
        return usuarioPersona;
    }

    public void setUsuarioPersona(Usuario usuarioPersona) {
        this.usuarioPersona = usuarioPersona;
    }
    
    
    
    
    
}
