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
 * @author Henry Salazar Serrano
 */
public class Grupo implements Serializable{
    private String nombreG;
    private String tipoGrupo;
    private List<Publicacion> publicaciones;
    private List<Persona> usuarios;
    private List<Persona> solicitudes;
    private Persona admin;

    public List<Persona> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Persona> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Grupo(String nombreG, String tipoGrupo, Persona admin) {
        this.nombreG = nombreG;
        this.tipoGrupo = tipoGrupo;
        this.publicaciones = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.solicitudes = new ArrayList<Persona>();
        this.admin = admin;
    }
    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

      public List<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Persona> usuarios) {
        this.usuarios = usuarios;
    }

    public Persona getAdmin() {
        return admin;
    }

    public void setAdmin(String admin, Sistema s) {
        for(Persona p: s.getPersonas()){
            if(p.getCorreo().equals(admin)){
            this.admin = p;
            }
        }
    }

    public String getNombreG() {
        return nombreG;
    }

    public void setNombreG(String nombreG) {
        this.nombreG = nombreG;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    
    
    
}
