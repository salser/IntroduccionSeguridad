/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.GregorianCalendar;

/**
 *
 * @author Henry Salazar Serrano
 */
public class Contrasena {
    private GregorianCalendar fechaRegistro;
    private GregorianCalendar fechaInicioContraseña;
    private String contraseniaAlpha;

    public Contrasena(GregorianCalendar fechaRegistro, GregorianCalendar fechaInicioContraseña, String contraseniaAlpha) {
        this.fechaRegistro = fechaRegistro;
        this.fechaInicioContraseña = fechaInicioContraseña;
        this.contraseniaAlpha = contraseniaAlpha;
    }

    public GregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(GregorianCalendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public GregorianCalendar getFechaInicioContraseña() {
        return fechaInicioContraseña;
    }

    public void setFechaInicioContraseña(GregorianCalendar fechaInicioContraseña) {
        this.fechaInicioContraseña = fechaInicioContraseña;
    }

    public String getContraseniaAlpha() {
        return contraseniaAlpha;
    }

    public void setContraseniaAlpha(String contraseniaAlpha) {
        this.contraseniaAlpha = contraseniaAlpha;
    }
    
    
}
