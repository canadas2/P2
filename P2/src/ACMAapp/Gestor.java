/*
 * Clase Gestor
 * 
 * Ingenieria de Software II
 */
package ACMAapp;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;

/**
 * @author Paula Catala
 * @author Raul Garcia
 */
public class Gestor {
    
    /**
     * Importe de motos limite permitido de un socio 
     */
    private int importe_max_socio = 6000;
    
    /**
     * Lista de motos registradas en la aplicacion
     */
    private ArrayList<Moto> motos;
    
    /**
     * Lista de socios regisrados en la aplicacion
     */
    private ArrayList<Socio> socios;
    
    /**
     * Lista de cesiones registradas en la aplicacion
     */
    private ArrayList<Cesion> cesiones;
    
    /**
     * Fecha actual 
     */
    private Date fecha_act;
    
    /**
     * Moto utilizada en el momento en la aplicacion
     */
    private Moto motoact;
    
    
    /**
     * Constructor del gestor
     */
    public Gestor() {
        socios= new ArrayList();
        motos= new ArrayList();
        cesiones= new ArrayList();
        
        //Motos ya registradas en la aplicacion previamente
        motos.add(new Moto("1111AAA","Vespa", "Primavera", 125, 2500, 100));
        motos.add(new Moto("2222BBB","Vespa", "Primavera", 125, 2500,100));
        motos.add(new Moto("3333CCC","Motobeane", "Poney AG2", 70, 2300,150));
        motos.add(new Moto("4444DDD","Bultaco", "", 200, 3800,200));
        motos.add(new Moto("5555EEE","Guzzi", "Cardelino 73", 75, 1200,50));
        motos.add(new Moto("6666FFFF","Ducati", "Mini", 49, 4000,180));
        
        //Creamos un socio
        socios.add(new Socio("Ramon"));
        socios.add(new Socio("Luis"));
        socios.add(new Socio("Ana"));
        socios.add(new Socio("Bea"));
        
        // Les ponemos todas las motos que ya estan registradas para que esten 
        // en posesion de un socio
        this.asignarMotosSocios();
    }
    
    /**
     * Metodo auxiliar utilizado para asignar todas las motos a un socio
     */
    private void asignarMotosSocios(){
        int indice = 0;
        for (Moto moto : motos) {
            if(this.comprobarImporteMotosSocio(socios.get(indice), moto)){
                socios.get(indice).anyadirMoto(moto);
            }
            else{
                indice++;
                socios.get(indice).anyadirMoto(moto);
            }
        }
    }
    
    /**
     * Metodo para dar de alta un socio en la aplicacion
     * @param nombre nombre del socio 
     */
    public void altaSocio(String nombre){
        System.out.println("entra en altaSocio del gestor");
        Socio s = new Socio(nombre);
        System.out.println(s.toString());
        this.socios.add(s);
    }
    
    /**
     * Metodo para registrar una moto y asignarsela a un socio
     * @param matricula matricula de la moto
     * @param marca marca de la moto
     * @param modelo modelo de la moto
     * @param cc cilindrada de la moto
     * @param coste_compra coste de compra de la moto
     * @param idsoc id del socio a anyadir la moto
     */
    public void altaMoto(String matricula, String marca, String modelo, int cc, int coste_compra, int otros_gastos, int idsoc){
        
        Socio soc;
        
        if(comprobarMatriculaIgual(matricula)){
            System.out.println("Matricula es correcta, no hay otra igual.");
            this.motos.add(new Moto(matricula, marca, modelo, cc, coste_compra, otros_gastos));
            
            soc = this.comprobarIdSocio(idsoc);
        
            if(comprobarImporteMotosSocio(soc, this.motos.get(this.motos.size()-1))){
                System.out.println("El socio cumple las normas de importe máximo.");
                soc.anyadirMoto(this.motos.get(this.motos.size()-1));
                this.motos.get(this.motos.size()-1).setId_socio_asociado(soc.getId());
            }
        }   
    }
    
    /**
     * Metodo que realiza una cesion entre socios
     * @param matricula matricula de la moto a ceder
     * @param id1 id del socio que cede
     * @param id2 id del socio al que se le cede
     */
    public void cesion(String matricula, int id1, int id2){
        Socio soc1, soc2;
        Moto moto;
        fecha_act = new Date();

        soc1 = this.comprobarIdSocio(id1);
        soc2 = this.comprobarIdSocio(id2);

        moto = soc1.getMoto(matricula);

        if(this.comprobarImporteMotosSocio(soc2, moto)){
            soc1.eliminarMoto(moto);
            soc2.anyadirMoto(moto);
        }
        cesiones.add(new Cesion(moto, soc1, soc2, fecha_act));
    }

    /**
     * Metodo Get de IMPORTE_LIMITE_MOTOS_SOCIO
     * @return constante de importe de motos limite de un socio
     */
    public int getIMPORTE_LIMITE_MOTOS_SOCIO() {
        return importe_max_socio;
    }
    
    
    /**
     * Metodo para mostrar la lista de socios registrados en la aplicacion
     */
    public void mostrarSocios(){
        String info,mensaje,info_moto;
        System.out.println("Lista de socios:\n");
        
        for(Socio s: socios){
            System.out.println(s.toString());
            System.out.println(s.informacionMotos());
            
        }
    }
    
    /**
     * Metodo para mostrar la lista de motos registradas en la aplicacion y socios asociados a estas
     */
    public void mostrarMotos(){
        System.out.println("Lista de motos y socios asociados a cada una:\n"+motos);
        String info, info_socio;
        int id;
        Socio s;
        
        for(Moto m: motos){
            System.out.println(m.toString());
            id = m.getId_socio_asociado();
            s = comprobarIdSocio(id);
            if(s != null){
                System.out.println("Info de su socio: "+s.toString());
            }
        }
    }
    
    /**
     * Muestra las cesiones realizadas entre socios en la aplicacion con todos los datos
     */
    public void mostrarCesiones(){
        
        System.out.println("Historial de cesiones realizadas:\n");
        for(Cesion c : cesiones){
            System.out.println(c.toString());
        }
    }
    /**
     * Metodo pra incrementar los otros gastos de una moto
     * @param matricula matricula de la moto que se quiere incrementar los otros gastos
     * @param otros_gastos valor a incrementar en otros gastos de la moto
     */
    public void incrementarOtrosGastosMoto(String matricula, int otros_gastos){
        if(!this.comprobarMatriculaIgual(matricula)){
            motoact.incrementarOtrosGastos(otros_gastos);
        }else{
            System.out.println("ERROR: mstricula no encontrada");
        }
    }
    
    /**
     * Metodo para comprobar que la matricula existe y tener una 
     * referencia de la moto actual
     * @param matricula matricula de la moto buscada
     * @return devuelve si se ha encontrado la matricula
     */
    private boolean comprobarMatriculaIgual(String matricula){
        boolean comprobacion = true;
        
        for (Moto moto : motos) {
            if(moto.getMatricula().equals((matricula))){
                System.out.println("");
                motoact = moto;
                comprobacion = false;
            }
        }
        return comprobacion;
    }
    
    /**
     * Metodo para comprobar si el socio supera o no el umbral maximo
     * de importe permitido en la asociacion
     * @param soc socio del que se comprueba el importe
     * @param moto moto de la que se obtiene su importe
     * @return comprobacion de que supera o no el umbral
     */
    private boolean comprobarImporteMotosSocio(Socio soc, Moto moto){
        boolean comprobacion = true;
        
        if((soc.getImporte_total_motos()+moto.getCoste_compra()) > importe_max_socio){
            comprobacion = false;
        }
        return comprobacion;
    }
    
    /**
     * Metodo Set de importe_max_socio
     * @param importe_max importe maximo de motos permitido por socio
     */
    public void setImporteMax(int importe_max){
       importe_max_socio = importe_max;
    }
    
    /**
     * Metodo para comprobar que el socio esta dado de alta en la asociacion
     * segun su id
     * @param id id del socio buscado
     * @return socio si se encuentra y null en caso contrario
     */
    private Socio comprobarIdSocio(int id){
        
        for (Socio socio : socios) {
            if(socio.getId() == id){
                return socio;
            }
        }
        return null;
    }
    
    /**
     * Metodo para guardar toda la informacion de socios
     * y cesiones realizadas en la aplicacion en un fichero
     * @throws IOException 
     */
    public void guardarInfo() throws IOException{   
        FileWriter file = null;
        
        try{
            System.out.println("Guardando lista de socios...\n");
            for(Socio s: socios){
                file = new FileWriter("salida.txt");
                file.write(s.toString()); 
            }
        
            System.out.println("Guardando lista de cesiones...\n");
            for(Cesion c: cesiones){
                file.write(c.toString());
            }
        }catch(IOException e){
            System.out.println("ALGO HA SALIDO MAL GUARDANDO LOS DATOS");
        }finally{
             file.close();
       }
    }
}
