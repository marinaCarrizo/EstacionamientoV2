/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Modelo.Usuario;

/**
 *
 * @author VICTOR
 */
public class UsuarioSingleton {
    private static UsuarioSingleton instance;
    private Usuario usuario;
    private UsuarioSingleton(){
        
    }
    
    public static UsuarioSingleton getInstance(){
        if(instance == null){
            instance = new UsuarioSingleton();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
