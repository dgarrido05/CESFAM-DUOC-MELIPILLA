<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Cesfam.aspx.cs" Inherits="cesfam.Cesfam" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>CESFAM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/estilos/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
	<script type="text/javascript" src="/estilos/script/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="/estilos/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
    	body{
    		background-color: #e1e1ea;
    		font-family: Calibri;
    	}
    	.jumbotron{
    		font-family: Cambria;
    		margin: 20px;
    		background-color: #2e74b4;
    		color: #ffffff;
    	}
    	p{
    		font-size: large;
    	}
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <!-- BARRA NAVEGACIÓN -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand visible-xs" href="Cesfam.aspx"><span class="glyphicon glyphicon-home"></span> CESFAM</a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <!--<ul class="nav navbar-nav"></ul>-->
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden-xs"><a href="Cesfam.aspx">Inicio</a></li>
	                    <li><a href="#">Sobre nosotros</a></li>
	                    <li><a href="#">Contacto</a></li>
	                    <li><a href="#">Ayuda</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- FIN BARRA NAVEGACIÓN -->

    <div class="container">
		<div class="jumbotron text-center">
			<h1>Centro de Salud Familiar</h1>      
			<p>Automatización de Libreta de Medicamentos</p>
		</div>
		<p>La Atención Primaria de Salud representa el primer nivel de contacto de los individuos, la familia y la comunidad con el sistema público de salud, brindando una atención ambulatoria.</p>		
	</div>
	<div class="container-fluid">
            <div class="row content" style="background-color: #f2f2f2">
                <!-- MENÚ LATERAL -->
                <div class="col-sm-2" style="padding: 15px;">
					<p style="font-size: 20px; font-weight: bold;">Ingrese como:</p>
					<div class="panel panel-default">
						<a class="btn btn-block panel-heading" style="background-color: #e6e6e6" 
                        href="http://localhost:8083/Farmacia"> <!-- con puerto de glassfish:8083 -->
                            <h4>Farmacéutico</h4>
                        </a>                        
                        <a class="btn btn-block panel-heading" style="background-color: #d9d9d9; margin: 0px" 
                        href="Medico/Login.aspx">
                            <h4>Médico</h4>
                        </a>
                    </div>                    
                </div>
                <!-- FIN MENÚ LATERAL -->
                <div class="col-sm-10" style="font-family: 'arial'">
                    <h1>Título</h1>
                    <p>Parráfo.</p>
                </div>
            </div>
		</div>
    </form>
</body>
</html>
