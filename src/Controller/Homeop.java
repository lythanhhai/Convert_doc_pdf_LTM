package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Homeop")
public class Homeop extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String id;
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    public Homeop() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 id = request.getParameter("ip123");
		 System.out.print(id);
		 setId(id);
		response.sendRedirect("Home.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
