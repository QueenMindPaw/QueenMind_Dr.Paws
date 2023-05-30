package com.queenmind.veterinary;

import Model.owner;
import Model.person;
import data_access_bd.PropietarioDAO;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Register extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String appat = request.getParameter("appat");
        String ammat = request.getParameter("ammat");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        person p = new person();
        owner prop = new owner();
        prop.setNombre(name);
        prop.setApellido_paterno(appat);
        prop.setApellido_materno(ammat);
        prop.setEmail(email);
        prop.setPassword(password);

        PropietarioDAO dao = new PropietarioDAO();
        int status = dao.save(p);
        if(status > 0){
            out.print("<p>Registro exitoso</p>");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }else{
            out.print("Lo sentimos, no se pudo registrar");
        }

        out.close();
    }
}
