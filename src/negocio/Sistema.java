/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaqui_000
 */
public class Sistema implements Serializable{
    private List<Persona> personas;
    private List<Grupo> grupos;

    public Sistema() {
        this.personas = new ArrayList<Persona>();
        this.grupos = new ArrayList<Grupo>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
}
