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
    private Contrasena contrasenia;
    private TipoUsuario tipo;
    private String correo;
    private DatosFinancieros datosF;
    private List<DatosMedicos> datosMedicos;
}
