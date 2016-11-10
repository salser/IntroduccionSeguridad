/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;

/**
 *
 * @author Henry Salazar Serrano
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String nomUsuario;
    private Contrasena contrasenia;
    private TipoUsuario tipo;
    private String correo;
    private DatosFinancieros datosF;
    private List<DatosMedicos> datosMedicos;

    public Persona(String nombre, String apellido, Contrasena contrasenia, TipoUsuario tipo, String correo, DatosFinancieros datosF, List<DatosMedicos> datosMedicos, String nomUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.correo = correo;
        this.datosF = datosF;
        this.datosMedicos = datosMedicos;
        this.nomUsuario = nomUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Contrasena getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(Contrasena contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DatosFinancieros getDatosF() {
        return datosF;
    }

    public void setDatosF(DatosFinancieros datosF) {
        this.datosF = datosF;
    }

    public List<DatosMedicos> getDatosMedicos() {
        return datosMedicos;
    }

    public void setDatosMedicos(List<DatosMedicos> datosMedicos) {
        this.datosMedicos = datosMedicos;
    }
    
    
}
