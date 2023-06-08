<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Register | Dr. Paws</title>
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
    <h1>Register</h1>

    <%-- Check if there is an error message and display it if available --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p><strong>Error:</strong> <%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <form action="register" method="post">
        <label for="name">Username:</label>
        <input type="text" id="name" required><br>
        <label for="appat">father's last name</label>
        <input type="text" id="appat" name="appat" required><br>
        <label for="ammat">mother's last name</label>
        <input type="text" id="ammat" name="ammat" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Register">
    </form>
</main>

<%-- hagan lo bonito del index xdxd --%>

<footer>
    <p>Dr. Paws &copy; 2021</p>
</footer>
</body>
</html>