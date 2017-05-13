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

@WebServlet(name = "usuarioParamsModificar", urlPatterns = {"/usuarioParamsModificar"})
public class usuarioParamsModificar extends HttpServlet {

    @EJB
    DAO.usuarioDAO servicio;
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<CesUsuario> lista;
        try {
            lista = servicio.buscarUsuarioPorId(id);
        } catch (Exception e){
            lista = null;
        }
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
