package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Util.DBConnection;

import com.DAO.UserDAO;
import com.Model.User;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateUser(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (user.getRole().equals("doctor")) {
                response.sendRedirect("doctorDashboard.jsp"); // Redirection vers l'espace médecin
            } else {
                response.sendRedirect("patientDashboard.jsp"); // Redirection vers l'espace patient
            }
        } else {
            response.sendRedirect("home.jsp?error=invalid"); // Redirection avec un message d'erreur
        }
    }
}
