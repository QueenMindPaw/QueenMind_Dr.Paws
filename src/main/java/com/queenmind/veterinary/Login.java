package com.queenmind.veterinary;

import Model.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT per_id FROM Person WHERE per_email = ? AND per_password = ?"
            );

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Login successful
                int userId = resultSet.getInt("per_id");

                // Create a session and store the user ID
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);

                // Redirect to the user dashboard
                response.sendRedirect("dashboard.jsp");
            } else {
                // Login failed
                // Redirect back to the login page with an error message
                response.sendRedirect("login.jsp?error=1");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any errors that occur during the login process
            // You can redirect to an error page or show an error message to the user
            request.setAttribute("errorMessage", "An error occurred during login. Please try again.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
