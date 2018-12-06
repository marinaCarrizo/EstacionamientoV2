/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.Persona;

/**
 *
 * @author Marina Belén
 */
public interface PersonaDAO {
    public void Guardar();
    public Persona Buscar(String nombre);
    
    
}
