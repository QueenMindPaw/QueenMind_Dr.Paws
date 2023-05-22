<%-- 
    Document   : login
    Created on : 11 may 2023, 19:44:10
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <div class="container" >
            <h1>Inicia Sesión</h1>
            <p>Ingresa con tu correo electronico</p>
            <form action="" method="post"  >
                <div class="loginform" >
                    <input type="text" name="correo" placeholder="Correo: " >
                    <input type="password" name="password" placeholder="Password :" >
                </div>
                <div>
                    <input type="submit" value="Iniciar Sesión">
                </div>
                <div>
                    <span>No tienes cuenta? </span>
                    <a href="" > Registrate aqui </a>
                </div>
            </form>
        </div>
    </body>
</html>
