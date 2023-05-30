package control_Propietarios;

import Model.owner;
import data_access_bd.BDConnection;
import data_access_bd.PropietarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class  crearPropietario extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //primero la conexion
            Connection conexion = BDConnection.getConnection(request.getServletContext());
            //la instancia del propietario y sus accesos
            PropietarioDAO propietarioDAO = new PropietarioDAO(conexion, request.getServletContext());
            
            owner owner = new owner(
                    request.getParameter("correo"),
                    request.getParameter("nombre"),
                    request.getParameter("appat"),
                    request.getParameter("apmat"),
                    request.getParameter("dir"),
                    request.getParameter("password")
            );
            
            try{
                owner = propietarioDAO.save(owner);
                System.out.println("Propietario agregado");
                response.sendRedirect("login.jsp");
            }catch(Exception e){
                System.out.println("Error al registrar al propietario : " 
                        + e.getMessage());
                response.sendRedirect("error.jsp");
            
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
