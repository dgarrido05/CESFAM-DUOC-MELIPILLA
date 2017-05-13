package Controlador;

import Modelo.CesPersona;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "personaParamsModificar", urlPatterns = {"/personaParamsModificar"})
public class personaParamsModificar extends HttpServlet {
    
    @EJB
    DAO.usuarioDAO servicio;
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int rut = Integer.parseInt(request.getParameter("rut"));
        List<CesPersona> lista;
        try {
            lista = servicio.buscarPacientePorRut(rut);
        } catch (Exception e){
            lista = null;
        }
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("modificarPaciente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
