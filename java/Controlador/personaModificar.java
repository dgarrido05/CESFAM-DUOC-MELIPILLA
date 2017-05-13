package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "personaModificar", urlPatterns = {"/personaModificar"})
public class personaModificar extends HttpServlet {
    @EJB
    DAO.usuarioDAO usuario;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        char sexo;
        Date fechaNac= new Date();
        int rut = Integer.parseInt(request.getParameter("personaRut"));
        String dvStr = request.getParameter("personaDv");
        char dv = dvStr.charAt(0);
        String nombre = request.getParameter("personaNombre");
        String apPaterno = request.getParameter("personaApPaterno");
        String apMaterno = request.getParameter("personaApMaterno");
        String sexoStr = request.getParameter("sexoChk");
        if(sexoStr.equals("masculino")){
            sexo = 'm';
        }else{
            sexo = 'f';
        }
        try{
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            String fechaNacStr = request.getParameter("personaNacimiento");
            fechaNac = in.parse(fechaNacStr);
            }catch(Exception e){
            //Ingresar error a tabla
        }
        int telefono = Integer.parseInt(request.getParameter("personaTelefono"));
        String email = request.getParameter("personaEmail"); 
        
        if(usuario.modificarPaciente(rut, dv, nombre, apPaterno, apMaterno, sexo, fechaNac, telefono, email)){
            request.setAttribute("msj", "El paciente ha sido modificado con éxito");
                request.getRequestDispatcher("listarPacientes").forward(request, response);
            }else{
                request.setAttribute("msj", "Error al modificar paciente");
                request.getRequestDispatcher("listarPacientes").forward(request, response);
            }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
