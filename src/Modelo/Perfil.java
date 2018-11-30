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
public class Perfil {
    private int idPerfil;
    private String nombrePerfil;

    public Perfil(int idPerfil, String nombrePerfil) {
        this.idPerfil = idPerfil;
        this.nombrePerfil = nombrePerfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    
    
   
    
}
