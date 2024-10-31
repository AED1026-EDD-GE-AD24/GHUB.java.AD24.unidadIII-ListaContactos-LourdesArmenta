package miPrincipal;
import lista.Lista;
import lista.PosicionIlegalException;

public class ListaDeContactos {
    private Lista<Contacto> contactos;

    public ListaDeContactos() {
        contactos = new Lista<Contacto>();
    }

    /**
     * Retorna un verdadero si el contacto puede ser agregado, en caso
     * contrario retorna false
     * Un contacto se puede agregar cuando no existe otra con su mismo nombre
     * y apellido
     * @param nombres
     * @param apellidos
     * @param correo
     * @param direccion
     * @param telefono
     * @param celular
     * @return
     * @throws PosicionIlegalException
     */

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

    /**
     * Elimina un contacto si este existe en la lista y retorna un true
     * en caso de que no exista retorna un false
     * @return
     * @throws PosicionIlegalException
     */
    public boolean eliminarContactos(String nombres, String apellidos) 
            throws PosicionIlegalException{
            Contacto con = buscarContacto(nombres, apellidos);
            if (con !=null){
                for(int i=0;i<contactos.getTamanio();i++){
                    Contacto conAux = contactos.getValor(i);
                    if(nombres.equals(conAux.getNombres()) && apellidos.equals(conAux.getApellidos())){
                        contactos.remover(i);
                        
                    }
                }
                return true;
            }else{
                return false;
            }

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

    /**
     * 
     * @return Lista de Contactos
     */

    public Lista<Contacto> mostrarTodosLosContactos(){
        return contactos;

    }

    /**
     * Modifica los datos de un contacto dado sus nombre y apellidos
     * Si el usuario existe se modifican sus datos y regresa true
     * si no existe no puede modificarlo y regresa fale
     * @param nombres
     * @param apellidos
     * @param direccion
     * @param correo
     * @param telefono
     * @param celular
     * @return
     * @throws PosicionIlegalException
     */

    public boolean modificarContactos(String nombres, String apellidos, 
                        String direccion, String correo, 
                        String telefono, String celular) throws PosicionIlegalException{
            Contacto con = buscarContacto(nombres, apellidos);
            if (con ==null){
               return false;
            }else{
                //modificar el contacto
                con.setNombres(nombres);
                con.setApellidos(apellidos);
                con.setDireccion(direccion);
                con.setCorreo(correo);
                con.setTelefono(telefono);
                con.setCelular(celular);
                return true;
            }
            

    }

    


    
}
