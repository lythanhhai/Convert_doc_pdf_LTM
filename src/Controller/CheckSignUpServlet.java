package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.CheckLoginBO;
import model.Bean.Account;



@WebServlet("/CheckSignUpServlet")
public class CheckSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckSignUpServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		String aString= CheckLoginBO.CheckSignUp(id, pw);
		if(aString !=null)
		{
			
			request.getSession().setAttribute("up", aString);
			response.sendRedirect("Login.jsp");
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
