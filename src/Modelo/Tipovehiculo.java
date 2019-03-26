package Modelo;
// Generated 16-mar-2019 23:47:48 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipovehiculo generated by hbm2java
 */
public class Tipovehiculo  implements java.io.Serializable {


     private Integer idTipoVehiculo;
     private String tipoVehiculo;
     private Set turnos = new HashSet(0);
     private Set estacionamientos = new HashSet(0);

    public Tipovehiculo() {
    }

	
    public Tipovehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    public Tipovehiculo(String tipoVehiculo, Set turnos, Set estacionamientos) {
       this.tipoVehiculo = tipoVehiculo;
       this.turnos = turnos;
       this.estacionamientos = estacionamientos;
    }
   
    public Integer getIdTipoVehiculo() {
        return this.idTipoVehiculo;
    }
    
    public void setIdTipoVehiculo(Integer idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }
    public String getTipoVehiculo() {
        return this.tipoVehiculo;
    }
    
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    public Set getTurnos() {
        return this.turnos;
    }
    
    public void setTurnos(Set turnos) {
        this.turnos = turnos;
    }
    public Set getEstacionamientos() {
        return this.estacionamientos;
    }
    
    public void setEstacionamientos(Set estacionamientos) {
        this.estacionamientos = estacionamientos;
    }




}

