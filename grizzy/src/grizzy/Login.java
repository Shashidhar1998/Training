package grizzy;


import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
  
public class Login extends HttpServlet {  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 167L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost/project?useSSL=false";
	    
	    static final String USER = "root";
	    static final String PASS = "password-1";
protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
	
    response.setContentType("text/html");  
    String username1=request.getParameter("username");  
    String password1=request.getParameter("password");  
     
    Connection conn = null;
    Statement stmt = null;
    
  
    
    
    try
    {
    	
    	Class.forName(JDBC_DRIVER);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM logintable WHERE username ='"+ username1 +"';"  ;
       // out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
        int id  = rs.getInt("userid");
        int userstatus = rs.getInt("userstatus");
        String username = rs.getString("username");
        String password = rs.getString("password");
        
        if(username1.equals(username) && password1.equals(password) && userstatus<4 )
           {  
        	userstatus=1;
            RequestDispatcher rd=request.getRequestDispatcher("/navigator.jsp"); 
            rd.forward(request, response);
            HttpSession session=request.getSession();  
            session.setAttribute("name",username); 
           }
        else
        {
        	 userstatus=userstatus+1;
        	 RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
             rd.forward(request, response);  
        }
        	String sqlq = "UPDATE logintable SET userstatus = " + userstatus + " WHERE userid = " + id + ";";
        	int rs1 = stmt.executeUpdate(sqlq);
        }	
        	
        else{  
        	
   
             RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
             rd.forward(request, response);  
                           
             } 
        
        rs.close();
        stmt.close();
        conn.close();
        
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    

   
    }
  
} 