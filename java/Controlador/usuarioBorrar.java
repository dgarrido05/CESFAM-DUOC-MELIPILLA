package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "usuarioBorrar", urlPatterns = {"/usuarioBorrar"})
public class usuarioBorrar extends HttpServlet {
    
    @EJB
    DAO.usuarioDAO servicio;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            String id = request.getParameter("id");
            servicio.eliminarUsuario(id);
            request.setAttribute("msj", "Usuario Borrado con Exito");
            request.getRequestDispatcher("listarUsuarios").forward(request, response);
        }catch(Exception e){
            request.setAttribute("msj", "El usuario no ha podido ser borrado");
            request.getRequestDispatcher("listarUsuarios").forward(request, response);
            //mandar a bbdd
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
