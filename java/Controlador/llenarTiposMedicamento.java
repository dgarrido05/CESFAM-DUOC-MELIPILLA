package Controlador;
import Modelo.CesLaboratorio;
import Modelo.CesTipoAdminMed;
import Modelo.CesTipoMedicamento;
import Modelo.CesTipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "llenarTiposMEdicamento", urlPatterns = {"/llenarTiposMEdicamento"})
public class llenarTiposMedicamento extends HttpServlet {
    
    @EJB
    DAO.usuarioDAO servicio;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CesLaboratorio> listaLab;
        List<CesTipoAdminMed> listaTipoAdm;
        List<CesTipoMedicamento> listaTipoMed;
        
        try{
            listaLab = servicio.listarLaboratorio();
            listaTipoAdm = servicio.listarTipoAdmin();
            listaTipoMed = servicio.listarTipoMed();
        }catch(Exception e){
            listaLab = null;
            listaTipoAdm = null;
            listaTipoMed = null;
        }
        
        request.setAttribute("listaLab", listaLab);
        request.setAttribute("listaTipoAdm", listaTipoAdm);
        request.setAttribute("listaTipoMed", listaTipoMed);
        request.getRequestDispatcher("ingresarMedicamento.jsp").forward(request, response);       
    }
}
