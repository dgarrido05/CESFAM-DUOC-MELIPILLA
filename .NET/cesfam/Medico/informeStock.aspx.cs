using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace cesfam.Medico
{
    public partial class informeStock : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnCerrar_Click(object sender, EventArgs e)
        {
            Session["usu_id"] = null;
            Response.Redirect("~/Cesfam.aspx");
        }

    }
}