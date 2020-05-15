/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MARINA
 */
public class FunctionsTools {
    public static String formatearFechaHora(long time){
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return formateador.format(new Date(time));
    }
    
    public static String formatearHora(long time){
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");

        return formateador.format(new Date(time));
    }
    
    
    public static String formatearFecha(long time){
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

        return formateador.format(new Date(time));
    }
    
    
}
