using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Servicio;
using System.Data;
using System.Web.Security;

namespace cesfam
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["usu_id"] != null)
            {
                Response.Redirect("~/Medico/Home.aspx");
            }
            if (!Page.IsPostBack)
            {
                Session.Abandon();
            }
            if (Request.QueryString["info"] != null)
            {
                string message = Request.QueryString["info"].ToString();
                if (message == "0")
                {                    
                    Response.Write("<script language='javascript'>alert('NECESITA LOGUEARSE PRIMERO PARA VISITAR LA PÁGINA DE USUARIO'); window.location.href = '/Medico/Login.aspx';</script>");
                }                
            }
        }

        protected void btnIniciar_Click(object sender, EventArgs e)
        {
            string usuario = this.txtNombre.Text.Trim();
            string clave = this.txtClave.Text.Trim();
            

            if (Servicio.Login.Autenticar(usuario, clave) == true)
            {
                DataTable tblUsuario = Servicio.Login.ConsultaUsuario(usuario, clave);

                Session["usu_id"] = tblUsuario.Rows[0]["usu_nombre_usuario"].ToString();
                Response.Redirect("~/Medico/Home.aspx");
            }
            else
            {                
                lblMensaje.Text = "USUARIO o CONTRASEÑA incorrectas. Verifíque por favor.";
                txtNombre.Text = "";
                txtClave.Text = "";                
            }
        }
    }
}