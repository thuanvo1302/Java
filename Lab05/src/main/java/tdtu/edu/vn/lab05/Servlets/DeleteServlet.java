package tdtu.edu.vn.lab05.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tdtu.edu.vn.lab05.DAO.productDAO;
import tdtu.edu.vn.lab05.DAO.userDAO;
import tdtu.edu.vn.lab05.Model.product;
import tdtu.edu.vn.lab05.Model.user;
import tdtu.edu.vn.lab05.Servlets.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int id;

    product p;
    user us = LoginServlet.u;


    private productDAO productDAO;


    public void init() {

        productDAO = new productDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writerA = response.getWriter();
//        writerA.println(request.getParameter("id"));
//        writerA.println("A2");
        id = Integer.parseInt(request.getParameter("id"));
        try {
            if(productDAO.deleteProduct(id)){
                request.setAttribute("User", us);
                List<product> listProduct = productDAO.selectAllProducts();
                request.setAttribute("listProduct", listProduct);
                RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }




}

