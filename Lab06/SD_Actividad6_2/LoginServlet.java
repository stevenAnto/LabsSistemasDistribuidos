import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String validUsername = "admin";
    private String validPassword = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            if (isValidUser(username, password)) {
                response.sendRedirect("welcome.jsp");
            } else {
                throw new Exception("Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            Vector<String> errorMessages = new Vector<>();
            errorMessages.add("El nombre de usuario o la contraseña no son correctos.");
            request.setAttribute("errorMessages", errorMessages);
            request.setAttribute("javax.servlet.error.exception", e);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private boolean isValidUser(String username, String password) {
        return validUsername.equals(username) && validPassword.equals(password);
    }
}
