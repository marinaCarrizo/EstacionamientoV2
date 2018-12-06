/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


/**
 *
 * @author Marina Belén
 */

public class TarifaVehiculo extends EntidadOID implements Serializable {

    private String tipoVehiculo;
    private List<Turno> tarifa;

    public TarifaVehiculo() {

        tarifa = new ArrayList<Turno>();

    }

    public TarifaVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;

    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public List<Turno> getTarifa() {
        return tarifa;
    }

    public void setTarifa(List<Turno> tarifa) {
        this.tarifa = tarifa;
    }

}
