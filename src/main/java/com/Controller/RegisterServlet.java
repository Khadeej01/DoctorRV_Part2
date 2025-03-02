package com.Controller;

import DAO.UserDAO;
import Model.Patient;
import Model.Doctor;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String specialisation = request.getParameter("specialisation"); // Spécialisation pour les docteurs

        UserDAO userDAO = new UserDAO();

        try {
            if ("DOCTOR".equals(role) && specialisation != null && !specialisation.isEmpty()) {
                Doctor doctor = new Doctor(0, fullname, email, telephone, password, specialisation);
                userDAO.addUser(doctor);
            } else {
                Patient patient = new Patient(0, fullname, email, telephone, password, "PATIENT");
                userDAO.addUser(patient);
            }

            response.sendRedirect("home.jsp"); // Redirection vers la page de connexion
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Erreur lors de l'inscription.");
        }
    }
}
