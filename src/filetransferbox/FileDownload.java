package filetransferbox;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String filename = req.getParameter("filename");
		File file = new File(FileStoreLocation.getFolder(), filename);
		
		if (file.exists() && file.canRead()) {
		
			resp.setContentType("application/octet-stream");            
			resp.setHeader("Content-disposition", "attachment; filename="+ filename);
			
			OutputStream os = resp.getOutputStream();
			
			Files.copy( file.toPath() , os );
		} else {
			System.out.printf("File not found: %s\n", filename);
		}
	}
}
