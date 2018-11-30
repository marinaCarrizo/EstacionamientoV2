/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Marina Belén
 */
public enum Tarifa {
    MAÑANA(0),
    TARDE(0),
    NOCHE(0);
    
   
    private double precio;

    private Tarifa(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
