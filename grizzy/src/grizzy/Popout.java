package grizzy;

import javax.servlet.*;  
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;  
  
public class Popout extends HttpServlet { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 121L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	    
	    out.print("<script type=\"text/javascript\">");
	    out.print("alert('Wrong');");
	    out.print("location='navigator.jsp'");
	    out.print("</script>");
	    
	    out.close();

}
}
