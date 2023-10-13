package exercise2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image2")
public class ImageServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImageServlet2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imagePath = getServletContext().getRealPath("/resources/image2.jpg");
        Path path = Paths.get(imagePath);
        byte[] data = Files.readAllBytes(path);

        response.setContentType("image/png");
        response.setContentLength(data.length);
        response.setHeader("Content-disposition", "attachment; filename=image2.png");

        try (OutputStream outStream = response.getOutputStream(); InputStream inputStream = Files.newInputStream(path)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
