<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="bootstrap\css/bootstrap.min.css">
	<script src="js/jquery-3.1.1.js"></script>        
        <script src="js/jquery-3.2.0.min.js"></script>
        <script src="js/jquery-3.2.1.js"></script>
	<script src="bootstrap\js/bootstrap.min.js"></script>
	<style>
	.margin {margin-bottom: 45px;}
	.bg-1 { 
      background-color: #2e74b4; 
      color: #ffffff;      
      padding-top: 70px;
      padding-bottom: 20px;
    }
    .navbar-nav  li a:hover {
      color: #2e74b4 !important;
    }
    h1{    
    font-family: Calibri;
    font-size: 50pt;    
    font-weight: bold;
    }
    .span-medico{    
    font-family: Calibri;
    font-size: 25pt;
    font-weight: bold;    
	}
	.sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
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
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand"><span class="glyphicon glyphicon-home"></span> CESFAM</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
     <!-- <ul class="nav navbar-nav">        
        <li><a href="#">Ayuda</a></li>
      </ul>-->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid bg-1 text-center">
  <h1 class="margin">CESFAM<span class="span-medico">Farmacia</span></h1>
</div>

<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-2 sidenav">
			<div class="panel-group">
				<div class="panel panel-default">
                                    
					<div class="panel-heading" style="background-color: #e6e6e6">
						<h4 class="panel-title"><a data-toggle="collapse" href="inicio.jsp">Inicio</a></h4>
					</div>
				
					<div class="panel-heading" style="background-color: #d9d9d9">
						<h4 class="panel-title"><a data-toggle="collapse" href="#collapse2">Pacientes</a></h4>
					</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body"><a href="listarPacientes">Mantenedor De Pacientes</a></div>					
				</div>
                                    
                                    <div class="panel-heading" style="background-color: #e6e6e6">
						<h4 class="panel-title"><a data-toggle="collapse" href="#collapse1">Usuarios</a></h4>
					</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body"><a href="listarUsuarios">Mantenedor De Usuarios</a></div>
				</div>
                                    <div class="panel-heading" style="background-color: #d9d9d9">
						<h4 class="panel-title"><a data-toggle="collapse" href="#collapse3">Farmacia</a></h4>
					</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body"><a href="listarMedicamentos">Mantenedor De Medicamentos</a></div>
				</div>
				</div>
			</div>
		</div>
    <div class="col-sm-10 text-left"> 
      <h1>Bienvenido al Sistema De Gestión de Farmacia CESFAM</h1>
    </div>
  </div>
</div>

<footer class="container-fluid">
  <p>Copyright</p>
</footer>

</body>
</html>
