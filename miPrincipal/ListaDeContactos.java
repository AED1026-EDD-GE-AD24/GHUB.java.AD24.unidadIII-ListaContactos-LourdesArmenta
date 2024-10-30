package miPrincipal;
import lista.Lista;
import lista.PosicionIlegalException;

public class ListaDeContactos {
    private Lista<Contacto> contactos;

    public ListaDeContactos() {
        contactos = new Lista<Contacto>();
    }

    public boolean agregarContactos(String nombres, String apellidos,
                     String correo, String direccion,
                      String telefono, String celular) throws PosicionIlegalException{
                Contacto con = buscarContacto(nombres,apellidos);
                if (con == null){ //se puede agregar el contacto
                    Contacto nuevo = new Contacto(nombres,apellidos,direccion,
                                         correo, telefono,celular);
                    contactos.agregar(nuevo);
                    return true;


                }else{
                    return false;
                }


    }

    public void eliminarContactos(){

    }

    public Contacto buscarContacto(String nombres, String apellidos) throws 
                    PosicionIlegalException{
            for(int i=0;i<contactos.getTamanio();i++){
                Contacto con = contactos.getValor(i);
                if(nombres.equals(con.getNombres()) && apellidos.equals(con.getApellidos())){
                    return con;
                 }

            }
            return null;
          

    }

    public void mostrarTodosLosContactos(){

    }

    public void modificarContactos(){

    }

    


    
}
