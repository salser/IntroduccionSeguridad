/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Henry Salazar Serrano
 */
public class DatosMedicos implements Serializable {
    private GregorianCalendar fechaCita;
    private String nombreDr;
    private List<String> medicamentos;

    public DatosMedicos(GregorianCalendar fechaCita, String nombreDr, List<String> medicamentos) {
        this.fechaCita = fechaCita;
        this.nombreDr = nombreDr;
        this.medicamentos = medicamentos;
    }

    public GregorianCalendar getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(GregorianCalendar fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getNombreDr() {
        return nombreDr;
    }

    public void setNombreDr(String nombreDr) {
        this.nombreDr = nombreDr;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
}
