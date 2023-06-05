<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.person" %>
<%@ page import="com.queenmind.veterinary.Agenda" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agenda</title>
    <style>
        .available-day {
            color: green;
        }

        .unavailable-day {
            color: red;
        }
    </style>
</head>
<body>
<main>
    <h1>Agenda</h1>

    <%-- Check if there is an error message and display it if available --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <p><strong>Error:</strong> <%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <%-- Display the available days --%>
    <% List<LocalDate> availableDays = (List<LocalDate>) request.getAttribute("availableDays"); %>
    <% for (LocalDate day : availableDays) { %>
    <p class="available-day"><%= day %></p>
    <% } %>

    <%-- Display the unavailable days --%>
    <% LocalDate currentDate = LocalDate.now(); %>
    <% for (int i = 0; i < 7; i++) { %>
    <% LocalDate date = currentDate.plusDays(i); %>
    <% String userId = String.valueOf(((person) request.getSession().getAttribute("user")).getId()); %>
    <%
        Agenda agenda = new Agenda();
        boolean isAvailable = isAvailable(userId, date); %>
    <% if (!isAvailable) { %>
    <p class="unavailable-day"><%= date %></p>
    <% } %>
    <% } %>

    <form action="agenda" method="post">
        <label for="date">Select a date:</label>
        <input type="date" id="date" name="date" required>
        <input type="submit" value="Create Appointment">
    </form>
</main>
</body>
</html>
<%!
    private boolean isAvailable(String userId, LocalDate date) {
        Agenda agenda = new Agenda();
        return agenda.isAvailable(Integer.parseInt(userId), date);
    }
%>