/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

/**
 *
 * @author MARINA
 */
public class ExpertoFactory {
    
    public Experto getExperto(String tipo){
        switch (tipo){
            case "Perfil":
                return new ExpertoPerfil();
            case "Persona":
                return new ExpertoPersona();
            case "Puesto":
                return new ExpertoPuesto();
            case "TipoVehiculo":
                return new ExpertoTipoVehiculo();
            case "Turno":
                return new ExpertoTurno();
            case "Usuario":
                return new ExpertoUsuario();
            case "Estacionamiento":
                return new ExpertoEstacionamiento();
            default:
                return null;
                    
        }
    }

}
