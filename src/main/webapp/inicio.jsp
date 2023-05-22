<%-- 
    Document   : inicio
    Created on : 11 may 2023, 20:04:05
    Author     : alumno
--%>

<%@page import="Model.Propietario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% 
            Propietario propietario = null;
            HttpSession sesionusuario = request.getSession(true);
            sesionusuario.getAttribute(propietario);
            
        %>
    </body>
</html>
