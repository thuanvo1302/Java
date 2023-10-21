package tdtu.edu.vn.lab05.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tdtu.edu.vn.lab05.DAO.productDAO;
import tdtu.edu.vn.lab05.DAO.userDAO;
import tdtu.edu.vn.lab05.Model.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;

    public void init() {
        userDAO = new userDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username =request.getParameter("name");
        String email =request.getParameter("email");
        String password =request.getParameter("password");
        String passwordConfirm =request.getParameter("password-confirm");
        try {
            if(Objects.equals(password, passwordConfirm)){
                userDAO.insertUser(new user(email, username, password));
                response.sendRedirect("login.jsp");
            }else{
                response.getWriter();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
