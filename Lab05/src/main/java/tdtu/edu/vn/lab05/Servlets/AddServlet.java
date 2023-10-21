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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    user us = LoginServlet.u;
    private productDAO productDAO;


    public void init() {

        productDAO = new productDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter writerA = response.getWriter();
//        writerA.println(request.getParameter("id"));
//        writerA.println("A2");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        try {
            productDAO.insertproduct(new product(name,price));
            request.setAttribute("User", us);
            List<product> listProduct = productDAO.selectAllProducts();
            request.setAttribute("listProduct", listProduct);
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);

    }
}
