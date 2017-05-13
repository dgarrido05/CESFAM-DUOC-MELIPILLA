<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <script src="js/jquery-3.1.1.js"></script>        
        <script src="js/jquery-3.2.0.min.js"></script>
        <script src="js/jquery-3.2.1.js"></script>
        <script>function validar(){
				var nombre = document.loginForm.username.value=document.loginForm.username.value.trim();
				var password = document.loginForm.password;
				if(nombre==""){
					document.getElementById("username").innerHTML="* Campo Requerido";
					return false;
				}
				if(password.value==""){
					document.getElementById("password").innerHTML="* Campo Requerido";
					return false;
				}
				return true;
			}</script>        
        <title></title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Iniciar Sesión</h1>
                    <div class="account-wall">
            <form class="form-signin" action="validarLogin" method="POST" name="loginForm" onsubmit="return validar()">
            <input type="text" id="username" name="username" placeholder="Nombre de usuario" class="form-control"/><br>
            <input type="password" id="password" name="password" placeholder="Contraseña" class="form-control"/><br>
            <input type="submit" id="submitLogin" name="submitLogin" value="Ingresar" class="btn btn-lg btn-primary btn-block"/>
        </form>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
