<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
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
        <title>Registro De Usuarios</title>
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
                <h1>Ingresar Usuario</h1>                
                <div class="col-sm-12 col-md-4 well well-sm">
                <form action="${pageContext.request.contextPath}/ingresarUsuario" method="GET" id="personaForm">            
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
                            <input class="form-control" type="text" name="personaRut" placeholder="Rut" required autofocus/>
                        </div>
                        <div class="col-xs-2 col-md-2"><label>-</label></div>
                        <div class="col-xs-4 col-md-4">
                            <input class="form-control" type="text" name="personaDv" size="1" required/>                
                        </div>
                    </div>
                    <select name="tipoUsuarioCb">
                        <c:forEach items="${lista}" var="row">
                            <option value="${row.tipoUsuarioId}"><c:out value="${row.tipoUsuarioDescripcion}"/></option>                            
                        </c:forEach>
                    </select>
                    <input class="form-control" type="text" name="personaNombre" placeholder="Nombre"/>               
                    <input class="form-control" type="text" name="personaApPaterno" placeholder="Apellido Paterno"/>
                    <input class="form-control" type="text" name="personaApMaterno" placeholder="Apellido Materno"/>
                    <label class="radio-inline">                        
                    <input type="radio" name="sexoChk" value="masculino"/>Masculino
                    </label>
                    <label class="radio-inline">
                    <input type="radio" name="sexoChk" value="femenino" />Femenino               
                    </label><br><br>
                    <label>Fecha De Nacimiento</label>
                    <input class="form-control" type="date" name="personaNacimiento"/>              
                    <input class="form-control" type="text" name="personaTelefono" placeholder="Telefono"/>
                    <input class="form-control" type="mail" name="personaEmail" placeholder="Email"/>
                    <input class="form-control" type="password" name="personaPass" placeholder="Contraseña"/>                    
                    <button class="btn btn-lg btn-primary btn-block">Ingresar Usuario </button> 
                </form>
                </div>
               
        </div>
    </div>
        
<footer class="container-fluid">
  <p>Copyright</p>
</footer>
        
        
    </body>
</html>
