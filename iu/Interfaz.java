package iu;
import java.util.Scanner;

import lista.PosicionIlegalException;
import miPrincipal.ListaDeContactos;
import lista.Lista;
import miPrincipal.Contacto;

public class Interfaz {
    static Scanner entrada = new  Scanner(System.in);
    

    public static void lectura() throws PosicionIlegalException{
        
		System.out.println("Bienvenido");
		System.out.println("Por favor, escoja una de las siguientes opciones");
		System.out.println("Para acceder a la opcion, escriba el número");
		imprimirMenu();	
       	
	}
    private static void imprimirMenu() throws PosicionIlegalException{

		int opcion = 0;
		do{
		
			System.out.println("Por favor, escoja una de las siguientes opciones");
			System.out.println("Para acceder a la opcion, escriba el número");
			System.out.println("****** MENU PRINCIPAL ******");
			System.out.println("1.- ABC de Contactos");
            System.out.println("9.- Salir           ");
            opcion = entrada.nextInt();

            switch  (opcion) {
                case 1:
                    entrada.nextLine(); // solo limpia la cadena Scanner
                    ListaDeContactos ldc = new ListaDeContactos();
                    ldc.agregarContactos("Fernando ", "Castro", "fernando@gmail.com",
                             "Laguna de catemaco 150 ote las quintas, culiacan Sinaloa", 
                             "6677121212", "66721515454");
                    
                    Lista<Contacto> lista = ldc.mostrarTodosLosContactos();
                    System.out.println("Mostrar Todos los contactos:");
                    for(int i=0; i<lista.getTamanio();i++){
                        System.out.println("Nombre de Contacto: "+lista.getValor(i).getNombres());
                    }


                   
                    break;
                case 9:
                    salir();
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;	
            }
        } while (opcion != 9);
    }

    private static void salir() {
		System.out.println("Sesion Finalizada");
		System.out.println("Adios!");
		System.exit(0);
	}


    
}
