/*
 * Clase Socio
 * 
 * Ingenieria de Software II
 */
package ACMAapp;

import java.util.ArrayList;

/**
 * @author Paula Catala
 * @author Raul Garcia
 */
public class Socio {
    
    /**
     * Variable statica para marcar el siguiente id a asignar en cada socio
     */
    static private int id_proximo = 1;
    
    /**
     * ID del socio
     */
    private int id_socio;
    
    /**
     * Nombre del socio
     */
    private String nombre;
    
    /**
     * Numero de motos que posee el socio
     */
    private int numero_motos;
    
    /**
     * Importe total en euros que posee el socio
     */
    private int importe_total_motos;
    
    /**
     * Lista de motos en posesion del socio
     */
    private ArrayList<Moto> motos;
    
    /**
     * Constructor vacio de Socio
     */
    public Socio(){
        this.nombre = "";
        this.numero_motos = 0;
        this.importe_total_motos = 0;
        this.id_socio = id_proximo;
        motos = new ArrayList();
    }
    
    /**
     * Constructor de Socio
     * @param nombre Nombre del socio
     */
    public Socio(String nombre) {
        this.nombre = nombre;
        this.numero_motos = 0;
        this.importe_total_motos = 0;
        this.id_socio = id_proximo;
        id_proximo++;
        motos = new ArrayList();
    }
    
    /**
     * Metodo Get de nombre
     * @return nombre del socio
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Metodo Get de importe_total_motos
     * @return importe total de las motos del socio
     */
    public int getImporte_total_motos() {
        return importe_total_motos;
    }

    /**
     * Metodo Get de id_socio
     * @return id del socio
     */
    public int getId() {
        return id_socio;
    }
    
    /**
     * Metodo para anyadir una moto a la lista de motos del socio, 
     * incrementar el importe total y el numero de motos del socio
     * @param moto Objeto moto que se quiere anyadir al socio
     */
    public void anyadirMoto(Moto moto){
        this.anyadeValorImporteTotalMotos(moto.getCoste_compra());
        this.numero_motos++;
        this.motos.add(moto);
        moto.setId_socio_asociado(this.id_socio);
    }
    
    /**
     * Metodo para eliminar una moto de la lista de motos del socio,
     * decrementar el importe total y el numero de motos del socio
     * @param moto Objeto moto que se quiere eliminar al socio
     */
    public void eliminarMoto(Moto moto){
        this.quitaValorImporteTotalMotos(moto.getCoste_compra());
        this.numero_motos++;
        this.motos.remove(moto);
    }
    
    /**
     * Metodo para recoger una moto de la lista de motos del socio
     * segun su matricula
     * @param matricula Matricula de la moto a recoger
     * @return moto con matricula igual al parametro de entrada
     */
    public Moto getMoto(String matricula){
        Moto moto_recogida = new Moto();
        for (Moto moto : motos) {
            if(moto.getMatricula().equals(matricula)){
                moto_recogida = moto;
            }
        }
        
        return moto_recogida;
    }

    /**
     * Metodo para restar valor al importe total de las motos del socio
     * @param res Valor a restar
     * @return importe total de las motos del socio resultante
     */
    private int quitaValorImporteTotalMotos(int res){
        return importe_total_motos-=res;
    }
    
    /**
     * Metodo para incrementar valor al importe total de las motos del socio
     * @param sum Valor a incrementar
     * @return importe total de las motos del socio resultante
     */
    private int anyadeValorImporteTotalMotos(int sum){
        return importe_total_motos+=sum;
    }
    
    
    public String informacionMotos(){
        return "Informacion de las motos del socio: \n" + motos.toString();
    }
    
    /**
     * Metodo toString sobreescrito
     * @return datos de un socio y sus motos
     */
    @Override
    public String toString() {
        return "Id socio= " + id_socio + ", nombre= " + nombre + ", numero de motos= " + numero_motos + ", importe total de motos en posesion= " + importe_total_motos + "\n";
    }
    
    
}
