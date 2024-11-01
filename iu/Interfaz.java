package iu;
import java.util.Scanner;

import lista.PosicionIlegalException;
import miPrincipal.ListaDeContactos;
import lista.Lista;
import miPrincipal.Contacto;

public class Interfaz {
    static Scanner entrada = new  Scanner(System.in);
    static ListaDeContactos ldc = new ListaDeContactos();

    

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
			System.out.println("1.- Ingresar Nuevo Contacto");
			System.out.println("2.- Mostrar Contactos");
			System.out.println("3.- Modificar Contacto");
			System.out.println("4.- Eliminar Contacto");
			System.out.println("9.- Salir");
			System.out.println("*****************************");

            System.out.println("9.- Salir           ");
            opcion = entrada.nextInt();

            switch  (opcion) {
                case 1:
                    entrada.nextLine(); // solo limpia la cadena Scanner
                    validarAlta(); // si los datos que ingresa el usuario tiene el formato correcto
                    /* 
                    ListaDeContactos ldc = new ListaDeContactos();
                    ldc.agregarContactos("Fernando ", "Castro", "fernando@gmail.com",
                             "Laguna de catemaco 150 ote las quintas, culiacan Sinaloa", 
                             "6677121212", "66721515454");
                    ldc.agregarContactos("Luisa", "Lopez", "luisa@gmail.com", 
                        "Privada ISSSTE 1085 col 5 de mayo, Culiacan Sinaloa", "6677511555","6672121212");
                    ldc.agregarContactos("Fernanda","Estudillo","Guasave","fernandae@gmail.com","6643232323","23232323");
                    
                    Lista<Contacto> lista = ldc.mostrarTodosLosContactos();
                    System.out.println("Mostrar Todos los contactos:");
                    for(int i=0; i<lista.getTamanio();i++){
                        System.out.println("Nombre de Contacto: "+lista.getValor(i));
                    }

                    ldc.modificarContactos("Luisa", "Lopez", "Privada ISSSTE 1085 col 5 de mayo","luisa@hotmail.com", "6677111111","6677222222");
                    lista = ldc.mostrarTodosLosContactos();
                    System.out.println("Mostrar Todos los contactos:");
                    for(int i=0; i<lista.getTamanio();i++){
                        System.out.println("Nombre de Contacto: "+lista.getValor(i));
                    }

                    ldc.modificarContactos("Luisa", "Lopez", "Privada ISSSTE 1085 col Rosales","luisa@hotmail.com", "6677111111","6677222222");
                    lista = ldc.mostrarTodosLosContactos();
                    System.out.println("Mostrar Todos los contactos:");
                    for(int i=0; i<lista.getTamanio();i++){
                        System.out.println("Nombre de Contacto: "+lista.getValor(i));
                    }

                    if(ldc.eliminarContactos("Luisa","Lopez"))
                        System.out.println("Contacto Eliminado");
                    else{
                        System.out.println("El contacto no se encontro");
                    }

                    lista = ldc.mostrarTodosLosContactos();
                    System.out.println("Mostrar Todos los contactos:");
                    for(int i=0; i<lista.getTamanio();i++){
                        System.out.println("Nombre de Contacto: "+lista.getValor(i));
                    }

                    if(ldc.eliminarContactos("Luisa","Lopez"))
                        System.out.println("Contacto Eliminado");
                    else{
                        System.out.println("El contacto no se encontro");
                    }
                        */

                   
                    break;
                case 2:
                    // mostrar todos los contactos
                    mostrarContactos();
                    break;
                case 3:
                    //modificar un contacto
                    entrada.nextLine(); // solo limpia la cadena Scanner
                    validarCambio();
                    break;
                case 4:
                    //Eliminar un contactoentrada.nextLine(); // solo limpia la cadena Scanner
                    entrada.nextLine(); // solo limpia la cadena Scanner
                    validarBaja();
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
    public static void validarAlta() throws PosicionIlegalException{
        try{
            String nombres,apellidos,direccion,
			       correo,telefono,celular;
            while (true){
                System.out.println("Ingresar un nuevo contacto");
				System.out.println("Por favor ingrese la información del contacto");
				System.out.println("El nombre y apellido no puede repetirse");
				System.out.println("y el celular debe tener los caracteres válidos");
				System.out.println("Los nombres y apellidos no pueden repetirse");
				
				System.out.print("NOMBRES:");
				nombres = entrada.nextLine();
				
				System.out.print("APELLIDOS:");
				apellidos = entrada.nextLine();

                if(ldc.buscarContacto(nombres,apellidos) != null){
                     System.out.println("Ya existe un contacto con ese nombre y apellido");
					System.out.println("Si desea agregar nuevamente un contacto");
					System.out.println("Ingrese un nuevo nombre y apellido");
                }else{
                    break;
                }
            }
            System.out.print("DOMICILIO:");
			direccion = entrada.nextLine();
			
			System.out.print("CORREO:");
			correo = entrada.nextLine();

            System.out.print("TELÉFONO:");
			telefono = entrada.nextLine();
			System.out.print("CELULAR:");
			celular = entrada.nextLine();

            if(ldc.agregarContactos(nombres, apellidos, correo, direccion, telefono, celular))
                System.out.println("Contacto agregado con Exito");
            else
                System.out.println("No agregado");
				


        }catch (Exception e){
            e.printStackTrace();
            
        }
        imprimirMenu();

    }
    public static void mostrarContactos(){

    }
    public static void validarCambio(){

    }
    public static void validarBaja(){

    }


    
}
