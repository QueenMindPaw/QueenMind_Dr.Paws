package com.queenmind.veterinary;

import Model.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Registration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String appat = request.getParameter("appat");
        String ammat = request.getParameter("ammat");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform registration logic and database insertion
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Person (per_name, per_appat, per_ammat, per_email, per_password) " +
                            "VALUES (?, ?, ?, ?, ?)"
            );

            statement.setString(1, name);
            statement.setString(2, appat);
            statement.setString(3, ammat);
            statement.setString(4, email);
            statement.setString(5, password);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred during registration. Please try again.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }


        // Redirect to the login page after successful registration
        response.sendRedirect("login.jsp");
    }
}
