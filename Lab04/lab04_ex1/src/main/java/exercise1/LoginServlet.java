package exercise1;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HashMap<String, String> account;

    public LoginServlet() {
        super();
        account = data();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (checkAcc(username, password)) {
            response.getWriter().write("<html><body><p>Account match!!!</p></body></html>");
        } else {
            response.getWriter().write("<html><body><p>Account don't match!!!</p></body></html>");
        }
    }

    private HashMap<String, String> data() {
        HashMap<String, String> account = new HashMap<>();
        account.put("admin", "admin");
        account.put("admin", "123");
        account.put("abc", "abc");
        return account;
    }

    private boolean checkAcc(String username, String password) {
        String storedPassword = account.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
