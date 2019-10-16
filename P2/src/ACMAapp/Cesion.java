/*
 * Clase Cesion
 *
 * Ingenieria de Software II
 */
package ACMAapp;

import java.util.Date;

/**
 * @author Raul Garcia
 * @author Paula Catala
 */
public class Cesion {
    
    
    /**
     * Moto que intervien en la cesion
     */
    private Moto moto;
    
    
    /**
     * Socios que que intervienen en la cesion (soc1 cede, soc2 recibe)
     */
    private Socio soc1, soc2;
    
    /**
     * Fecha en la que se realiza la cesion
     */
    private Date fecha;

    /**
     * Constructor de una Cesion
     * @param moto Moto cedida
     * @param soc1 Socio que cede
     * @param soc2 Socio al que se cede
     * @param fecha Fecha de la cesion
     */
    public Cesion(Moto moto, Socio soc1, Socio soc2, Date fecha) {
        this.moto = moto;
        this.soc1 = soc1;
        this.soc2 = soc2;
        this.fecha = fecha;
    }

    /**
     * Metodo sobreescrito toString
     * @return datos de una cesion
     */
    @Override
    public String toString() {
        return "Cesion: " + "Moto cedida= " + moto + ", Socio que cede: " + soc1.toString() + " Socio al que se cede " + soc2.toString() + "\n Fecha de la cesion=" + fecha.toString() + "\n";
    } 
}
