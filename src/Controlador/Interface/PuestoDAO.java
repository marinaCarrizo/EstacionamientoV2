/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.Estacionamiento;

/**
 *
 * @author Marina Belén
 */
public interface PuestoDAO {
    
    public void CambiarEstado(boolean estado);
    public void AsignarVehiculo(Estacionamiento estacionamiento);
    public void RetirarVehiculo(Estacionamiento estacionamiento);
    
}
