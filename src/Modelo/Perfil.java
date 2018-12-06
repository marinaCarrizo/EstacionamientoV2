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

public class Perfil extends EntidadOID implements Serializable {
  
    private String nombrePerfil;

    public Perfil() {
    }

    
    public Perfil( String nombrePerfil) {
        
        this.nombrePerfil = nombrePerfil;
    }

   

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    
    
   
    
}
