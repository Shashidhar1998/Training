
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class logoutservlet extends HttpServlet {  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
   
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    String n=request.getParameter("userName");  
    out.print("Thank you "+n+" ,You have been logged out");  
    out.print("To login click below"); 
    
    RequestDispatcher rd=request.getRequestDispatcher("/relogin.html");  
    rd.include(request, response); 
    
    
    
    }  
  
}  