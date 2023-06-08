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

    <title>Home | Dr. Paws</title>
</head>
<html lang="es">
<body>
<header>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <%-- Check if the user is logged in and display the appropriate navigation options, rembember to touch
             this and decorate with bootstrap, someone has to do it, not me--%>
            <% if (request.getSession().getAttribute("userId") == null) { %>
            <li><a href="register.jsp">Register</a></li>
            <li><a href="login.jsp">Login</a></li>
            <% } else { %>
            <li><a href="logout.jsp">Logout</a></li>
            <li><a href="profile.jsp">Profile</a></li>
            <li><a href="Agenda.jsp">Agenda</a></li>
            <% } %>
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
    </nav>
</header>

<main>
    <h1 class="text-secondary">Bienvenido a Dr.Paws!</h1>
    <p class="text-secondary">Dr. Paws es una aplicación web que te permite agendar citas con tu veterinario de
        confianza, además de poder ver tu historial de citas y tus mascotas registradas.</p>
</main>

<%-- Make spmething quite good xdxd --%>

<footer>
    <p>Dr. Paws &copy; 2021</p>
</footer>
</body>
</html>