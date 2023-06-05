package com.queenmind.veterinary;


import Model.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/agenda")
public class Agenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");

        // Retrieve and display the available days for the user
        List<LocalDate> availableDays = getAvailableDays(userId);
        request.setAttribute("availableDays", availableDays);
        request.getRequestDispatcher("agenda.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");

        // Get the selected date from the request parameters
        String dateParam = request.getParameter("date");
        LocalDate selectedDate = LocalDate.parse(dateParam, DateTimeFormatter.ISO_DATE);

        // Check if the selected date is still available
        if (isAvailable(userId, selectedDate)) {
            // Create the appointment
            createAppointment(userId, selectedDate);

            // Redirect to a success page
            response.sendRedirect("appointment_success.jsp");
        } else {
            // Redirect back to the agenda page with an error message
            response.sendRedirect("agenda?error=1");
        }
    }

    private List<LocalDate> getAvailableDays(int userId) {
        List<LocalDate> availableDays = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT DISTINCT appo_datetime FROM Agenda " +
                            "WHERE vet_id IN (SELECT vet_id FROM Veterinarians WHERE per_id = ?) " +
                            "AND appo_datetime >= CURRENT_DATE() " +
                            "ORDER BY appo_datetime"
            );

            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                LocalDate date = resultSet.getDate("appo_datetime").toLocalDate();
                availableDays.add(date);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return availableDays;
    }

    public boolean isAvailable(int userId, LocalDate date) {
        boolean isAvailable = false;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(*) AS count FROM Agenda " +
                            "WHERE vet_id IN (SELECT vet_id FROM Veterinarians WHERE per_id = ?) " +
                            "AND DATE(appo_datetime) = ?"
            );

            statement.setInt(1, userId);
            statement.setString(2, date.toString());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                isAvailable = count == 0;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
        }
        return isAvailable;
    }

    private void createAppointment(int userId, LocalDate date) {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Agenda (vet_id, appo_datetime) " +
                            "VALUES ((SELECT vet_id FROM Veterinarians WHERE per_id = ?), ?)"
            );

            statement.setInt(1, userId);
            statement.setObject(2, date.atStartOfDay());
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}