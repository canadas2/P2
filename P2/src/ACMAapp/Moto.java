/*
 * Clase Moto
 * 
 * Ingenieria de Software II
 */
package ACMAapp;

/**
 * @author Paula Catala
 * @author Raul Garcia
 */
public class Moto {
    
    /**
     * Matricula de la moto
     */
    private String matricula  ;
    
    /**
     * Marca de la moto
     */
    private String marca;
    
    /**
     * Modelo de la moto (puede ser vacio si no se sabe)
     */
    private String modelo;
    
    /**
     * Cilindrada de la moto
     */
    private int cc;

    /**
     * Coste de compra de la moto
     */
    private int coste_compra;
    
    //private int matricula_num;
    
    //private String matricula_letras;
    
    /**
     * Id del socio asociado a la moto
     */
    private int id_socio_asociado;
    
    /**
     * Otros gastos que se iran incrementando de una moto
     */
    private int otros_gastos;
    
    /**
     * Constructor vacio de Moto
     */
    public Moto(){
        
    }
    
    /**
     * Constructor de Moto
     * @param matricula Matricula de la moto
     * @param marca Marca de la moto
     * @param modelo Modelo de la moto
     * @param cc Cilindrada de la moto
     * @param coste_compra Coste de compra de la moto
     * @param otros_gastos
     */
    public Moto(String matricula, String marca, String modelo, int cc, int coste_compra, int otros_gastos) {
        this.matricula = matricula;
        //this.matricula = String.format("%04d", this.matricula_num)+this.matricula_letras;
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
        this.coste_compra = coste_compra;
        this.otros_gastos = otros_gastos;
    }   

    /**
     * Metodo Get de matricula
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }
    
    /**
     * Metodo Get de coste_compra
     * @return coste de compra
     */
    public int getCoste_compra() {
        return coste_compra;
    }  

    /**
     * Metodo Get del id_socio_asociado
     * @return id del socio asociado a la moto
     */
    public int getId_socio_asociado() {
        return id_socio_asociado;
    }

    /**
     * Metodo Set del id_socio_asociado
     * @param id_socio_asociado id del socio al que se le quiere asociar la moto
     */
    public void setId_socio_asociado(int id_socio_asociado) {
        this.id_socio_asociado = id_socio_asociado;
    }
    
    /**
     * Metodo para incrementar otros gastos de una moto
     * @param incremento valor que se suma a otros gastos
     */
    public void incrementarOtrosGastos(int incremento){
        this.otros_gastos+=incremento;
    }
    
    /**
     * Metodo sobreescrito toString
     * @return datos de una moto
     */
    @Override
    public String toString() {
        return "Matricula= " + matricula + ", marca= " + marca + ", modelo= " + modelo + ", cc= " + cc + ", coste_compra= " + coste_compra+
                ", otros gastos= "+otros_gastos+"\n";
    }
    
    
}
