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
public class Usuario {
    
    private int idUsuario;
    private String nombreUsuario;
    private String Contraseña;
    private Perfil perfilUsuario;

    public Usuario(int idUsuario, String nombreUsuario, String Contraseña, Perfil perfilUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.Contraseña = Contraseña;
        this.perfilUsuario = perfilUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public Perfil getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(Perfil perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
    
    
    
}
