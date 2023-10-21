package tdtu.edu.vn.lab05.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tdtu.edu.vn.lab05.DAO.productDAO;
import tdtu.edu.vn.lab05.DAO.userDAO;
import tdtu.edu.vn.lab05.Model.product;
import tdtu.edu.vn.lab05.Model.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet( value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private userDAO userDAO;
    public static user u;
    public static List<product> listProduct;
    private productDAO productDAO;


    public void init() {
        userDAO = new userDAO();
        productDAO = new productDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        u = userDAO.Validate(username, password);
        if(Objects.equals(u.getUserName(), username) && Objects.equals(u.getPassword(), password)){

            request.setAttribute("User", u);
            try {
                listProduct(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
            //response.sendRedirect("home.jsp");
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response){


    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       listProduct = productDAO.selectAllProducts();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
