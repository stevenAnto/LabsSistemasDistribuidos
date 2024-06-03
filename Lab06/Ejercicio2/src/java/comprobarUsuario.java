/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package defaultPackage;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author USUARIO
 */
@WebService(serviceName = "comprobarUsuario")
public class comprobarUsuario {

    @WebMethod(operationName = "Comprobar")
    public boolean Comprobar(@WebParam(name = "usuario") String user, @WebParam(name = "contrasenia") String contra) {
        String usuario = "admin"; // Ejemplo de usuario almacenado
        String contrasenia = "password"; // Ejemplo de contraseña almacenada

        try {
            if (user.equals(usuario) && contra.equals(contrasenia)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
