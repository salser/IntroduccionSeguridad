/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Henry Salazar Serrano
 */
public class DatosFinancieros implements Serializable{
    private double ingresosMensuales;
    private double dineroTotal;
    private List<Double> gastos;

    public DatosFinancieros(double ingresosMensuales, double dineroTotal, List<Double> gastos) {
        this.ingresosMensuales = ingresosMensuales;
        this.dineroTotal = dineroTotal;
        this.gastos = gastos;
    }

    public double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(double ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public double getDineroTotal() {
        return dineroTotal;
    }

    public void setDineroTotal(double dineroTotal) {
        this.dineroTotal = dineroTotal;
    }

    public List<Double> getGastos() {
        return gastos;
    }

    public void setGastos(List<Double> gastos) {
        this.gastos = gastos;
    }
    
    
}
