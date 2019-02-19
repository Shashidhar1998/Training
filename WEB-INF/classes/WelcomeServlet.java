import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class WelcomeServlet extends HttpServlet {  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    out.print("Welcome "+n+"\n");  
  /*  Cookie ck1[]=request.getCookies();  
    for(int i=0;i<ck1.length;i++){  
     out.print("<br>"+ck1[i].getName()+" "+ck1[i].getValue());//printing name and value of cookie  
    }  */

    RequestDispatcher rd=request.getRequestDispatcher("/logout.html");  
    rd.include(request, response); 
    Cookie ck=new Cookie("name","");  
    ck.setMaxAge(0);  
    response.addCookie(ck); 
    }  
  
}  