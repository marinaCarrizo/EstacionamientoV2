/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.Perfil;
import Modelo.Persona;
import Modelo.Usuario;

/**
 *
 * @author Marina Belén
 */
public interface UsuarioDAO {
    
    public void Guardar();
    public void AsignarPersona(Persona persona);
    public void Loggin(Usuario usuario);
    public void AsignarPerfil(Perfil perfil);
    
    
}
