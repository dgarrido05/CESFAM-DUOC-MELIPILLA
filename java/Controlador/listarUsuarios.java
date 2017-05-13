package Controlador;

import Modelo.CesPersona;
import Modelo.CesUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listarUsuarios", urlPatterns = {"/listarUsuarios"})
public class listarUsuarios extends HttpServlet {

   @EJB
   DAO.usuarioDAO servicio;   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<CesUsuario> lista;
        try {
            lista = servicio.listarUsuarios();
        } catch (Exception ex) {           
            lista = null;
        }
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("usuariosCrud.jsp").forward(request, response);        
    }


}
