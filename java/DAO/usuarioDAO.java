package DAO;
import Modelo.CesMedicamento;
import Modelo.CesPersona;
import Modelo.CesTipoUsuario;
import Modelo.CesUsuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class usuarioDAO {
    @PersistenceContext(name = "FarmaciaPU") 
    private EntityManager em;    
    static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    static final String USER="cesfam";
    static final String PASS="cesfam";    
    Connection con;       
    
    public void conecta(){
        con = getConnection();
    }
    
    public static final Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USER,PASS);
        }catch(SQLException e){
            System.out.println("error"+ e);
            return null;
        }
    }    
    /**********************LOGIN***************************************/
    public boolean validarLogin(String usuario, String clave){
        boolean status=false;  
        try{
            conecta();
            String query = "SELECT usu_nombre_usuario FROM ces_usuario WHERE usu_nombre_usuario=? AND usu_clave=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            status=rs.next();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }     
        return status;
    }
    
    /**********************LISTAR (READ)***************************************/
     public List<CesPersona> listarPacientes() throws Exception{
        TypedQuery<CesPersona> query = em.createQuery("SELECT  p FROM CesPersona p WHERE p.perRut NOT IN (SELECT u.perRut.perRut FROM CesUsuario u) AND p.perVigencia = :vigencia", CesPersona.class);
        return query.setParameter("vigencia", 's').getResultList();        
    }
    
    public List<CesUsuario> listarUsuarios() throws Exception{
        TypedQuery<CesUsuario> query = em.createQuery("SELECT usu FROM CesUsuario usu WHERE usu.usuVigencia = :vigencia", CesUsuario.class);
        return query.setParameter("vigencia", 's').getResultList();
    }
    
    public List<CesMedicamento> listarMedicamentos() throws Exception{
        TypedQuery<CesMedicamento> query = em.createQuery("SELECT m FROM CesMedicamento m WHERE m.usuVigencia = :vigencia", CesMedicamento.class);
        return query.setParameter("vigencia", 's').getResultList();
    }  
    
    public List<CesTipoUsuario> listarTiposUsuario() throws Exception{
        return em.createNamedQuery("CesTipoUsuario.findAll").getResultList();
    }
    
    /**********************MODIFICAR (UPDATE)***************************************/
    public boolean modificarUsuario(String id, String nombreUsu, String clave){
        boolean status = false;
        try{
        CesUsuario usu = em.find(CesUsuario.class, id);
        usu.setUsuNombreUsuario(nombreUsu);
        usu.setUsuClave(clave);
        em.persist(usu);
        return true;
        }catch(Exception e){
            return false;
        }        
    }
    
    public boolean modificarPaciente(int rut, char dv, String nombres, String apPaterno, String apMaterno,
                                    char sexo, Date fechaNac, int telefono, String email){
        CesPersona p = em.find(CesPersona.class, rut);
        try{
            
            p.setPerNombres(nombres);
            p.setPerApellidoPaterno(apPaterno);
            p.setPerApellidoMaterno(apMaterno);
            p.setPerFechaNacimiento(fechaNac);
            p.setPerSexo(sexo);
            p.setPerTelefono(telefono);
            p.setPerEmail(email);
            p.setPerNombreCompleto(nombres + " " + apPaterno + " " + apMaterno);
            em.persist(p);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**********************CREAR (CREATE)***************************************/   
    public boolean ingresarMedicamento(){
        return true;
    }
    
    public boolean ingresarPersona(int rut, char dv, String nombres, String apPaterno, String apMaterno,
                                    char sexo, Date fechaNac, int telefono, String email){
        Date now = new Date();
        java.sql.Date fechaReg = new java.sql.Date(now.getTime());
        String nombreCompleto=nombres + " " + apPaterno + " " + apMaterno;
        char vigencia = 's'; 
        try{
            CesPersona p = new CesPersona(rut, dv, nombres, apPaterno, apMaterno, nombreCompleto, sexo, fechaNac, fechaReg, telefono, email, vigencia);
            em.persist(p);
        return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean ingresarUsuario(String nombre, String apPaterno, String passFinal, int rut, int tipoUsu){
        
        String[] parts = nombre.split(" ");
        String pNombre = parts[0]; 
        String nombreUsuario = pNombre + "." + apPaterno;
        short tipoUsuShort = (short) tipoUsu;
        CesTipoUsuario tipo = em.find(CesTipoUsuario.class, tipoUsuShort);
        CesPersona per = em.find(CesPersona.class, rut);
        try{
            CesUsuario nuevoUsuario = new CesUsuario();
            nuevoUsuario.setPerRut(per);
            nuevoUsuario.setTipoUsuarioId(tipo);
            nuevoUsuario.setUsuNombreUsuario(nombreUsuario);
            nuevoUsuario.setUsuClave(passFinal);
            nuevoUsuario.setUsuVigencia('s');
            em.persist(nuevoUsuario);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**********************ELIMINAR (DELETE)***************************************/ 
    public void eliminarPaciente(int rut){
        try{
        CesPersona p = em.find(CesPersona.class, rut);
        p.setPerVigencia('n');
        em.persist(p);
        }catch(Exception e){
        
        }
    }
    
    public void eliminarUsuario(String id){
        try{
        CesUsuario u = em.find(CesUsuario.class, id);
        u.setUsuVigencia('n');
        em.persist(u);
        }catch(Exception e){
        
        }
    }
    
    public void eliminarMedicamento(int id){
        try{
        CesMedicamento m = em.find(CesMedicamento.class, id);
        m.setMedVigencia('n');
        em.persist(m);
        }catch(Exception e){
        
        }
    }
    
    /**********************BUSCAR***************************************/ 
    public List<CesPersona> buscarPacientePorRut(int rut){
        //CesPersona c = em.find(CesPersona.class, rut);
        TypedQuery<CesPersona> query = em.createQuery("SELECT c FROM CesPersona c WHERE c.perRut = :perRut", CesPersona.class);
        return query.setParameter("perRut", rut).getResultList();        
    }

    public List<CesUsuario> buscarUsuarioPorId(int id){
        CesUsuario c = em.find(CesUsuario.class, id);
        id = c.getUsuId();
        TypedQuery<CesUsuario> query = em.createQuery("SELECT c FROM CesUsuario c WHERE c.usuId = :usuId", CesUsuario.class);
        return query.setParameter("usuId", id).getResultList();        
    }    
    
    /**********************OTROS***************************************/ 
    public String get_SHA_512_SecurePassword(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");            
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch(Exception ex){
           ex.printStackTrace();
        }
        return generatedPassword;
        }   
   
    /*static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    static final String USER="cesfam";
    static final String PASS="cesfam";
    
    Connection con;       
    
    public void conecta(){
        con = getConnection();
    }
    
    public static final Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USER,PASS);
        }catch(SQLException e){
            System.out.println("error"+ e);
            return null;
        }
    }
    
    public boolean ingresarPersona(int rut, char dv, String nombres, String apPaterno, String apMaterno,
                                    char sexo, Date fechaNac, int telefono, String email){
        boolean status=false;
        String nombreCompleto=nombres + " " + apPaterno + " " + apMaterno;
        java.util.Date utilDate = fechaNac;
        java.sql.Date fechaNacimiento = new java.sql.Date(utilDate.getTime());
        Date now = new Date();
        java.sql.Date fechaActual = new java.sql.Date(now.getTime());
        try {
            conecta();
            String query = "INSERT INTO ces_persona ('per_rut', 'per_dv', 'per_nombres', 'per_apellido_paterno', 'per_apellido_materno', 'per_nombre_completo', 'per_sexo', 'per_fecha_nacimiento', 'per_fecha_registro', 'per_vigencia', 'per_telefono', 'per_email') values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rut);
            ps.setString(2, String.valueOf(dv));
            ps.setString(3, nombres);
            ps.setString(4, apPaterno);
            ps.setString(5, apMaterno);
            ps.setString(6, nombreCompleto);
            ps.setString(7, String.valueOf(sexo));
            ps.setDate(8, fechaNacimiento);
            ps.setDate(9, fechaActual);
            ps.setString(10, String.valueOf('s'));
            ps.setInt(11, telefono);
            ps.setString(12, email);
            ps.execute();
            status = true;
        } catch (SQLException e){
            System.out.println("Error: "+e);
            status = false;
        } catch (Exception ex){
            System.out.println("Error: "+ex);
            status = false;
        }
        return status;
    }*/
    
    
    
    
}
