/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.TarifaVehiculo;
import vista.Tarifa;

/**
 *
 * @author Marina Belén
 */
public interface TarifaVehiculoDAO {
    public void Actualizar();

   
    public TarifaVehiculo Buscar(String tipoVehiculo);// agregar parametro tarifa???
}
