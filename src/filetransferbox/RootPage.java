package filetransferbox;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/")
public class RootPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		File[] files = new File[0];
		
		files = FileStoreLocation.getFolder().listFiles(new FileFilter() {
			@Override
			public boolean accept(File candidate) {
				return !candidate.isDirectory() && !candidate.isHidden();
			}
		});

		String url = req.getRequestURL().toString();
		
		req.setAttribute("favicon", url + "favicon.ico");
		
		req.setAttribute("files", files);
		req.setAttribute("filecount", null==files ? -1 : files.length);
		
		req.setAttribute("fileloc", FileStoreLocation.getFolder().getPath());
		
		getServletContext().getRequestDispatcher("/rootpage.jsp").forward(req, resp);
	}
}
