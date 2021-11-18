package Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import Model.BO.*;


/**
 * Servlet implementation class checkUpload
 */
@WebServlet("/checkUpload")
@MultipartConfig
public class checkUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkUpload() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// multiple files
		List<Part> fileParts = request.getParts().stream().filter(part -> "files".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList()); 
		request.setAttribute("fileParts", fileParts);
		handleFile_BO handleFile = new handleFile_BO();
		int id = 0;
		try {
			id = handleFile.getIdMax_BO();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String userName = "lth";
		ArrayList<String> listFileName = new ArrayList<String>();
		ArrayList<InputStream> listFileContent = new ArrayList<InputStream>();
	    for (Part filePart : fileParts) {
	        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	        InputStream fileContent = filePart.getInputStream();

			try {
				handleFile.insertUrl_BO(id, userName);
				id++;
				listFileName.add(fileName);
				listFileContent.add(fileContent);
				handleFile.threadHandleFile(fileContent);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    request.setAttribute("listFileName", listFileName);
	    request.setAttribute("listFileContent", listFileContent);
	    response.sendRedirect("/BTL_LTM/WEB_APP/View/Home.jsp");
	    
	    // 1 file
//		Part filePart = request.getPart("file");
//		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//		InputStream fileContent = filePart.getInputStream();
		
		//RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB_APP/View/Home.jsp");
		//rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
