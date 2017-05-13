package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "personaBorrar", urlPatterns = {"/personaBorrar"})
public class personaBorrar extends HttpServlet {
    @EJB
    DAO.usuarioDAO servicio;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try{
            int rut = Integer.parseInt(request.getParameter("rut"));
            servicio.eliminarPaciente(rut);
            request.setAttribute("msj", "Paciente Borrado con Exito");
            request.getRequestDispatcher("listarPacientes").forward(request, response);
        }catch(Exception e){
            request.setAttribute("msj", "El Paciente no ha podido ser borrado");
            request.getRequestDispatcher("listarPacientes").forward(request, response);
            //mandar a bbdd
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
