/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henry Salazar Serrano
 */
public class Grupo {
    private String nombreG;
    private String tipoGrupo;
    private List<String> publicaciones;

    public Grupo(String tipoGrupo, String nombreG) {
        this.nombreG = nombreG;
        this.tipoGrupo = tipoGrupo;
        this.publicaciones = new ArrayList<String>();
    }

    public String getNombreG() {
        return nombreG;
    }

    public void setNombreG(String nombreG) {
        this.nombreG = nombreG;
    }
    
    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public List<String> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<String> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    
}
