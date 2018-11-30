/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marina Belén
 */
public class TarifaVehiculo {
    private String tipoVehiculo;
    private List<Tarifa> tarifa;

    public TarifaVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        tarifa=new ArrayList<Tarifa>();
        
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public List<Tarifa> getTarifa() {
        return tarifa;
    }

    public void setTarifa(List<Tarifa> tarifa) {
        this.tarifa = tarifa;
    }
    
    
    
    
    
}
