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

public class Turno  extends EntidadOID implements Serializable {

    private String nombreTurno;

    private double precio;

    public Turno() {
    }
    

    private Turno(String nombre, double precio) {
        this.precio = precio;
        this.nombreTurno=nombre;
    }

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
