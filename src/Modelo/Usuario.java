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

public class Usuario extends EntidadOID implements Serializable {
    
   
    private String nombreUsuario;
    private String contrasenia;
    private Perfil perfilUsuario;

    public Usuario() {
    }
    

    public Usuario( String nombreUsuario, String contrasenia, Perfil perfilUsuario) {
     
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.perfilUsuario = perfilUsuario;
    }

   

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Perfil getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(Perfil perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
    
    
    
}
