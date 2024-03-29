/*
 * Clase main LauncherP1
 * 
 * Ingenieria de software II
 */
package ACMAapp;

/**
 * @author Paula Catala
 * @author Raul Garcia 
 */

import java.util.Scanner;
import java.io.*;
public class LauncherP1 {
    
    /**
     * Gestor de la aplicacion que realizara todas las operaciones
     * solicitadas por el usuario
     */
    static Gestor acma;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Variables String utilizadas en el uso de la aplicacion
        String nombre="",matricula="",marca="",modelo="";
        
        //Variables Integer utilizadas en el uso de la aplicacion
        int opcion,cc=0,coste_compra=0, otros_gastos=0,id1,id2, importe_max,id_cliente_baja=0;
        
        //Objetos socio usados en la aplicacion
        Socio soc1, soc2;
        
        //Objeto moto usado en la aplicacion
        Moto moto;
        
        //Gestor declarado
        acma = new Gestor();
        Scanner s = new Scanner(System.in);
        System.out.println("BIENVENIDO/A A ACAMA.\nIntroduzca el importe máximo de motos por socio: \n");
        importe_max = s.nextInt();
        acma.setImporteMax(importe_max);
        
        do{
            /**
             * Declaracion del scanner y presentacion de la aplicacion.
             * El usuario selecciona una de las opciones para iniciar
             * un proceso
             */
            System.out.println("MENU: \n Elija entre las siguientes opciones: \n");
            System.out.println(" 1) Registrar socio \n 2) Registrar moto \n "
                    + "3) Registrar cesion \n 4) Mostrar lista de Socios \n 5) Mostrar lista de Motos\n "
                    + "6) Mostrar lista de Cesiones\n 7) Cerrar aplicacion y guardar dato en fichero\n"
                    + " 8) Incrementar otros gastos de una moto\n 9) Eliminar socio de la asociacion\n"
                    + " 10) Mostrar miembros con mas cesiones de motos recibidas\n");
            opcion = s.nextInt();
            
            //Switch para ver que opcion se ha elegido y realizar esa operacion
            switch(opcion){
                //Registrar socio
                case 1:
                    System.out.println("Ha elegido REGISTRAR un nuevo MIEMBRO.");
                    Scanner s1 = new Scanner(System.in);
                    System.out.println("Introduzca el NOMBRE del nuevo miembro:");
                    nombre = s1.nextLine();
                    acma.altaSocio(nombre);
                    System.out.println("Se ha creado el socio correctamente.");
                    break;
                    
                //Registrar moto
                case 2:
                    System.out.println("Ha elegido REGISTRAR una nueva MOTOCICLETA.");
                    Scanner s2 = new Scanner(System.in);
                    System.out.println("Informacion de los socios:");
                    acma.mostrarSocios();
                    System.out.println("Introduzca la MATRICULA:");
                    matricula = s2.nextLine();
                    System.out.println("Introduzca la MARCA:");
                    marca = s2.nextLine();
                    System.out.println("Introduzca el MODELO:");
                    modelo = s2.nextLine();
                    System.out.println("Introduzca los CC:");
                    cc = s2.nextInt();
                    System.out.println("Introduzca el COSTE de la compra (en euros):");
                    coste_compra = s2.nextInt();
                    System.out.println("Introduzca id del socio al que se le asignara la id:");
                    id1 = s2.nextInt();
                    System.out.println("Introduzca importe de otros gastos de la moto:");
                    otros_gastos = s2.nextInt();
                    acma.altaMoto(matricula, marca, modelo, cc, coste_compra, otros_gastos, id1);
                    System.out.println("Se ha dado de alta la moto.");
                    break;
                    
                //Registrar una cesion
                case 3:
                    System.out.println("Ha elegido REGISTRAR una nueva CESION.");
                    Scanner s3 = new Scanner(System.in);
                    System.out.println("Informacion de los socios:");
                    acma.mostrarSocios();
                    System.out.println("Introduzca la MATRICULA de la MOTO a ceder:");
                    matricula = s3.nextLine();
                    System.out.println("Introduzca el nº ID del SOCIO 1 que desea cederla:");
                    id1=s3.nextInt();
                    System.out.println("Introduzca el nº ID del SOCIO 2 al que se la desea ceder:");
                    id2=s3.nextInt();
                    acma.cesion(matricula, id1, id2);
                    break;
                
                //Mostrar la lista de socios registrados
                case 4:
                    acma.mostrarSocios();
                    break;
                
                //Mostrar lista de motos registradas
                case 5:
                    acma.mostrarMotos();
                    break;
                
                //Mostrar lista de cesiones registradas
                case 6:
                    acma.mostrarCesiones();
                    break;
                
                //Guardar la informacion de socios y cesiones y cerrar la aplicacion
                case 7:
                    acma.guardarInfo();
                    break;
                //Incrementar otros gastos de motos
                case 8:
                    System.out.println("Ha elegido INCREMENTAR OTROS GASTOS de una moto");
                    Scanner s4 = new Scanner(System.in);
                    System.out.println("Introduzca la matricula de la moto a incrementar sus otros gastos");
                    matricula = s4.nextLine();
                    System.out.println("Introduzca importe de otros gastos a incrementar");
                    otros_gastos = s4.nextInt();
                    acma.incrementarOtrosGastosMoto(matricula, otros_gastos);
                    break;
                //Eliminar un socio de la asociacion
                case 9:
                    System.out.println("Ha elegido ELEMINAR MIEMBRO.");
                    Scanner s5 = new Scanner(System.in);
                    System.out.println("Informacion de los socios:");
                    acma.mostrarSocios();
                    System.out.println("Introduzca la ID del socio que desea dar de baja: ");
                    id_cliente_baja = s5.nextInt();
                    acma.eliminarSocio(id_cliente_baja);
                    System.out.println("Se elimino el socio correctamente. ");
                    break;
                //Mostrar miembros con mas seciones
                case 10:
                    System.out.println("Ha elegido ver los MIEMBROS con MAS CESIONES.");
                    acma.mostrarCesionesMax();
                    break;
                default:
                    System.out.println("No se ha elegido una opcion correcta");
                    break;
            }//switch
        }while(opcion != 7);
    }//main
}//class
