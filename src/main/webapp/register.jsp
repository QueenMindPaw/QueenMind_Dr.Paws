<%@page import="Model.owner" %>
<%@page import="Model.person"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta name="description" content="Web Application Veterinary Example">
    <meta name="keywords" content="JSP,CSS,SCSS,XML,Java">
    <meta name="author" content="Angel">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="custom.css">

    <title>Inicio | Dr. Paws</title>
</head>
<html lang="es">
<body>
<header>
    <nav>
        <ul>
            <li><a href="index.jsp">Inicio</a></li>
            <% owner owner = null;
                if (owner != null) { %>
            <li><a href="profile.jsp">Profile</a></li>
            <% } %>
            <%
                if (owner != null) { %>
            <li><a href="logout.jsp">Logout</a></li>
            <% } %>
            <%
                if (owner != null) { %>
            <li><a href="schedule.jsp">Schedule</a></li>
            <% } %>
            <%
                if (owner == null) { %>
            <li><a href="login.jsp">Login</a></li>
            <% } %>
            <% owner = null;
                if (owner == null) { %>
            <li><a href="register.jsp">Register</a></li>
            <% } %>
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
    </nav>
</header>

<main>
    <form action="Persoan" id="formregister" method="post">
        <h1>Registro</h1>
        <label for="name">Nombre</label>
        <input type="text" name="name" id="name" placeholder="Ingrese aquí el texto" required>
        <label for="appat">Apellido paterno</label>
        <input type="text" name="appat" id="appat" placeholder="Ingrese aquí el texto" required>
        <label for="ammat">Apellido materno</label>
        <input type="text" name="ammat" id="ammat" placeholder="Ingrese aquí el texto" required>
        <label for="email">Correo</label>
        <input type="email" name="email" id="email" placeholder="Correo" required>
        <label for="password">Contraseña</label>
        <input type="password" name="password" id="password" placeholder="Contraseña" required>
        <label for="password2">Confirmar Contraseña</label>
        <input type="password" name="password2" id="password2" placeholder="Confirmar Contraseña" required>
        <input type="submit" value="Registrarse">
    </form>
</main>

<%-- hagan lo bonito del index xdxd --%>

<footer>
    <p>Dr. Paws &copy; 2021</p>
</footer>
</body>
</html>