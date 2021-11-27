package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.BO.handleFile_BO;
import model.Bean.urlFile;


@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String id;
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
    public view() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("ip1234");
		 System.out.print(id);
		 setId(id);
		 ArrayList<urlFile> l = new ArrayList<urlFile>();
		 handleFile_BO handleFile = new handleFile_BO();
		 try {
			l= handleFile.geturl_BO(id);
			request.getSession().setAttribute("url123", l);
			response.sendRedirect("viewfile.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
