<%@page import="Model.PersonDAO" %>
<%@ page import="Model.PersonDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
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
            <% PersonDAO person = person.getPersonById();
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
    <h1 class="text-secondary">Bienvenido a Dr.Paws!</h1>
    <%
        owner = null;
        HttpSession sesionusuario = request.getSession(true);
        sesionusuario.getAttribute(String.valueOf(owner));

        if (owner != null) {
            out.println("Bienvenido " + owner.getNombre());
        } else {
            out.println("Bienvenido Invitado");
        }
    %>
</main>

<%-- hagan lo bonito del index xdxd --%>

<footer>
    <p>Dr. Paws &copy; 2021</p>
</footer>
</body>
</html>