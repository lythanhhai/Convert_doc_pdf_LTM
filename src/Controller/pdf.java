package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;


@WebServlet("/pdf")
public class pdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public pdf() {
        super();
       
    }
    //static byte[] data = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		String url = request.getParameter("ip123");
		
		try {
			
//			
//			BufferedInputStream bis = new BufferedInputStream(
//					new FileInputStream("C:\\FileServer\\" + url));
//			
//			
//			String c = "";
//			// Read until a single byte is available
//	        while (bis.available() > 0) {
//	        
//	            // Read the byte and
//	            // convert the integer to character
//	            c += String.valueOf((char)bis.read());
//	  
//	            // Print the characters
//	            //System.out.println("Char : " + c);
//	        }
//				
//	        if (data==null)
//				data = c.getBytes();
//			
//			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
//			bos.write(data);
			
			//response.setHeader("Content-disposition","attachment; filename=\""+"myNewPdf.pdf"+"\"");
			byte[] bytes = StringUtils.getBytes(url);
	        String url1 = new String(bytes, StandardCharsets.UTF_8);
	        InputStream inputStream = new FileInputStream("C:\\FileServer\\" + url1);
	        InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
	        int data;

	        while( (data = inputStream.read()) >= 0 ) {
	            response.getWriter().write(data);
	        }
	        inputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
