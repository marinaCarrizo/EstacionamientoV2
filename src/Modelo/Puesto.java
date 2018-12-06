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

public class Puesto extends EntidadOID implements Serializable {
    private int numPuesto;
    private boolean estadoPuesto;
    private Estacionamiento estacionamiento;

    public Puesto() {
    }
    
    

    public Puesto(int numPuesto, boolean estadoPuesto) {
        this.numPuesto = numPuesto;
        this.estadoPuesto = estadoPuesto;
    }

    public int getNumPuesto() {
        return numPuesto;
    }

    public void setNumPuesto(int numPuesto) {
        this.numPuesto = numPuesto;
    }

    public boolean isEstadoPuesto() {
        return estadoPuesto;
    }

    public void setEstadoPuesto(boolean estadoPuesto) {
        this.estadoPuesto = estadoPuesto;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(Estacionamiento estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
    
    
    
}
