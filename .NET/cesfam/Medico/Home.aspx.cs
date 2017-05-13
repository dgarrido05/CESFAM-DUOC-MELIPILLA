using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Web.Security;

namespace cesfam
{
    public partial class Home : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {            
            if (Session["usu_id"] == null || Session["usu_id"] == "")
            {
                Response.Redirect("~/Medico/Login.aspx?info=0");
            }            
            lblSesion.Text = "Bienvenido/a: <strong>" + Session["usu_id"] + "</strong>"; //se puso id = nombre_usuario
        }

        protected void btnCerrar_Click(object sender, EventArgs e)
        {
            Session["usu_id"] = null;
            Response.Redirect("~/Cesfam.aspx");
        }
    }
}