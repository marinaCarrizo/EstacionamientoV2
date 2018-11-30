/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.Estacionamiento;
import Modelo.TarifaVehiculo;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Marina Belén
 */
public interface EstacionamientoDAO {
    
    public void Guardar();
    public Estacionamiento Buscar(int idIngreso);
    public void Actualizar(TarifaVehiculo tarifaVehiculo);
    public List<Estacionamiento> ReporteFecha(Timestamp desde, Timestamp hasta);
    
    
    
}
