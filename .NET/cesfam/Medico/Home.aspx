<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="cesfam.Home" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head runat="server">
    <title>CESFAM | Médicos</title>    
    <link rel="icon" href="../estilos/faviconn.ico" type="image/ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--<link rel="stylesheet" type="text/css" href="../estilos/estilosHome.css" />-->
	<link rel="stylesheet" href="../estilos/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<script type="text/javascript" src="../estilos/script/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="../estilos/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        body
	{
	    padding-top: 30px;
	    background-color: #f1f1f1;
	}
		
	.bg-1 { 
      background-color: #2e74b4; 
      color: #ffffff;      
      padding-top: 70px;
      padding-bottom: 20px;
    }
    .navbar-nav  li a:hover {
      color: #2e74b4 !important;
    }
    
    .label1, h1{    
    font-family: Calibri;
    font-size: 50pt;    
    font-weight: bold;
    line-height: 80%;
    }

    .label2, h2{    
    font-family: Calibri;
    font-size: 25pt;
    font-weight: bold;
    margin: 0px;
	}
	.sidenav {
      padding-top: 20px;
    }
    .row.content {height: 450px}
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    footer {
      background-color: #999999;
      padding: 15px;
    }
    a:hover{
    	text-decoration: none;
    }
    </style>
</head>

<body>
    <form id="form1" runat="server">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                </button>
                <a class="navbar-brand"><span class="glyphicon glyphicon-home"></span> CESFAM</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <!--<ul class="nav navbar-nav">
                    <li class="active"><a href="#">Link</a></li><li><a href="#">Ayuda</a></li>                    
                </ul>-->
                <ul class="nav navbar-nav navbar-right">
                    <li style="margin: 0px;padding: 15px;"><asp:Label ID="lblSesion" runat="server" ></asp:Label></li>
                    <li><asp:LinkButton ID="btnCerrar" runat="server" onclick="btnCerrar_Click"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</asp:LinkButton></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid bg-1 text-center">
        <label class="label1">CESFAM</label><label class="label2"> Médicos</label>
    </div>
        <div class="container-fluid">
            <div class="row content">
                <div class="col-sm-2 sidenav">
                    <div class="panel-group" id="accordion" style="margin-bottom: 0px">
                        <div class="panel panel-default">
                            <a href="Home.aspx"><button class="btn btn-block panel-heading" style="background-color: #e6e6e6">
                                    <h4 class="panel-title">Inicio</h4>
                                </button></a>
                        </div>
                        <div class="panel panel-default">
                            <button class="btn btn-block panel-heading" data-toggle="collapse" href="#collapse1" data-parent="#accordion" style="background-color: #d9d9d9">
                                <h4 class="panel-title">Stock</h4>
                            </button>
                            <div id="collapse1" class="panel-collapse collapse">
                                <div class="panel-body"><a href="#">Revisar stock disponible</a></div>
                            </div>
                            </div>
                            <div class="panel panel-default">
                            <button class="btn btn-block panel-heading" data-toggle="collapse" href="#collapse2" data-parent="#accordion" style="background-color: #e6e6e6">
                                <h4 class="panel-title">Prescripciones</h4>
                            </button>
                            <div id="collapse2" class="panel-collapse collapse">
                                <div class="panel-body"><a href="#">Ingresar prescripcioones</a></div>
                                <div class="panel-body"><a href="#">Emitir receta</a></div>
                            </div>
                            </div>
                    </div>
                </div>
                <div class="col-sm-10" style="min-height: 100%; background-color: white; padding: 15px">
                <div class="row" style="margin: 0px">
                <h2>Bienvenido al Sistema de Gestión de Farmacia CESFAM</h2>
                </div>
                </div>
            </div>
        </div>
    <footer class="container-fluid">
        <div class="row"></div>
        <div class="col-sm-6 col-md-6"><p>Copyright</p></div>
        <div class="col-sm-6 col-md-6 text-right"><strong><a href="#">AYUDA</a></strong></div>
    </footer>
    </form>
</body>
</html>
