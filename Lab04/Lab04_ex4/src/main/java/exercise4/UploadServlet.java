import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the file name from the form field
        String fileName = request.getParameter("filename");

        // Get the file part from the request
        Part filePart = request.getPart("file");

        // Get the override checkbox value
        String override = request.getParameter("override");

        // Validate file name
        if (fileName == null || fileName.trim().isEmpty()) {
            response.getWriter().println("Please enter a file name.");
            return;
        }

        // Validate file part
        if (filePart == null || filePart.getSize() == 0) {
            response.getWriter().println("Please upload a file.");
            return;
        }

        // Check if the file already exists and if override is not selected
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File existingFile = new File(uploadPath, fileName);
        if (existingFile.exists() && override == null) {
            response.getWriter().println("File already exists. Please check the override option to replace it.");
            return;
        }

        // Save the file to the server
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, existingFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            response.getWriter().println("Error uploading the file.");
            return;
        }

        response.getWriter().println("File uploaded successfully.");
    }
}
