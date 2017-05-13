package Controlador;

import Modelo.CesPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/listarPacientes"})
public class listarPacientes extends HttpServlet {

   @EJB
   DAO.usuarioDAO servicio;
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<CesPersona> lista;
       try {
           lista = servicio.listarPacientes();
       } catch (Exception ex) {           
           lista = null;
       }
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("pacientesCrud.jsp").forward(request, response);        
    }
}
