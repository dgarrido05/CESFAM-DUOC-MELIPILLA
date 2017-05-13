package Controlador;

import Modelo.CesMedicamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listarMedicamentos", urlPatterns = {"/listarMedicamentos"})
public class listarMedicamentos extends HttpServlet {
    @EJB
    DAO.usuarioDAO servicio;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CesMedicamento> lista;
        try {
            lista = servicio.listarMedicamentos();
        } catch (Exception e) {
            lista = null;
        }
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("medicamentosCrud.jsp").forward(request, response);
        

    }


}