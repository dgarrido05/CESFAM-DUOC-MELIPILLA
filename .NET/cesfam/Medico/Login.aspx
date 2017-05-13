<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="cesfam.Login" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head runat="server">
    <title>CESFAM | Login</title>    
    <link rel="icon" href="../estilos/faviconn.ico" type="image/ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--<link rel="stylesheet" type="text/css" href="../estilos/estilosLogin.css" />-->
    <link rel="stylesheet" href="../estilos/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<script type="text/javascript" src="../estilos/script/jquery-3.2.0.min.js"></script>

    <style>
        .form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    top: 0px;
    left: 0px;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    font-family: Calibri;
    font-size: 40pt;
    color: #2e74b4;
    font-weight: bold;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}

.msj
{
    color:red;
    font-family: Arial;
}

body
{
    background-color: #e6e6e6;
}
    </style>
</head>

<body>   
    <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Iniciar sesión</h1>
            <div class="account-wall">
                <!--<img class="profile-img" src="estilos/porfile.png">-->
                <form class="form-signin" runat="server">
                <asp:TextBox ID="txtNombre" runat="server" class="form-control" placeholder="Usuario" required autofocus></asp:TextBox>
                <asp:TextBox ID="txtClave" runat="server" TextMode="Password" class="form-control" placeholder="Contraseña" required></asp:TextBox>
                <asp:Button ID="btnIniciar" runat="server" Text="Ingresar" onclick="btnIniciar_Click" class="btn btn-lg btn-primary btn-block"></asp:Button>
                <!--<asp:Label runat="server" class="checkbox pull-left"><asp:CheckBox ID="chkRecuerdame" runat="server" />Recuérdame</asp:Label>-->                
                <a href="/Cesfam.aspx" class="pull-left">Volver</a>
                <a href="#" class="pull-right need-help">¿Necesita ayuda?</a><span class="clearfix"></span>
                <asp:Label ID="lblMensaje" runat="server" class="msj"></asp:Label>                
                </form>                
            </div>
        </div>
    </div>
</div>

</body>
</html>
