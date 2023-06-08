package com.queenmind.veterinary;

import Model.PersonDAO;
import Model.person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonDAO personDAO; // Assuming you have a PersonDAO instance

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the personDAO instance with the established database connection
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        System.out.println("DBConnection: " + connection);
        personDAO = new PersonDAO(connection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String appat = request.getParameter("appat");
        String ammat = request.getParameter("ammat");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Perform any necessary validation on the input fields

        person person = new person();
        person.setName(name);
        person.setAppat(appat);
        person.setAmmat(ammat);
        person.setEmail(email);
        person.setPassword(password);

        person = personDAO.updatePerson(person);

        // Assuming the registration was successful, redirect to a success page
        response.sendRedirect("success.jsp");
    }
}
