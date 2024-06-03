/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package defaultPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ProcesarDatosServlet", urlPatterns = {"/ProcesarDatosServlet"})
public class ProcesarDatosServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Obtener los parámetros del formulario 2
            String usu2 = request.getParameter("usu2");
            String contra2 = request.getParameter("contra2");

            // Obtener los parámetros del formulario 1
            String usu1 = request.getParameter("usu1_hidden");
            String contra1 = request.getParameter("contra1_hidden");

            // Verificar si algún campo del segundo formulario está vacío
            if (usu2.isEmpty() || contra2.isEmpty()) {
                out.println("<h2>Entro a excep Login</h2>");
                throw new IllegalArgumentException("Usuario o contraseña (Login) no pueden estar vacíos");
            }
            if (usu1.isEmpty() || contra1.isEmpty()) {
                out.println("<h2>Entro a registro</h2>");
                throw new IllegalArgumentException("Usuario o contraseña (Registro) no pueden estar vacíos");
            }

            // Comparar los valores de los formularios
            if (usu1.equals(usu2) && contra1.equals(contra2)) {
                out.println("<html><body>");
                out.println("<h2>¡Usuario y contraseña correctos!</h2>");
                out.println("<a href='index.html'>Volver al índice</a>");
                out.println("</body></html>");
            } else {
                out.println("<html><body>");
                out.println("<h2>Usuario o contraseña incorrectos</h2>");
                out.println("<a href='index.html'>Volver al Registro</a>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            // Almacenar el mensaje de error en el atributo de la solicitud
            request.setAttribute("errorMessage", e.getMessage());
            // Redireccionar a la página de error
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
