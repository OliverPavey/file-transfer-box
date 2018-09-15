package filetransferbox;

import java.io.File;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("serial")
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		try {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(FileStoreLocation.getTempFolder());

			File uploadFolder = FileStoreLocation.getFolder();
			ServletFileUpload upload = new ServletFileUpload(factory);

			@SuppressWarnings("unchecked")
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					
					String filename = new File(item.getName()).getName();
					File file = new File(uploadFolder, filename);
					item.write(file);
					
				}
			}

			resp.sendRedirect( req.getContextPath()+"/" );
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}