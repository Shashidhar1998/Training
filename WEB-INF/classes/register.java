
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
  
public class register extends HttpServlet {  
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    static final String DB_URL = "jdbc:mysql://localhost/EMP?useSSL=false";
	    
	    static final String USER = "root";
	    static final String PASS = "password-1";
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
	
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String username1=request.getParameter("userName");  
    String password1=request.getParameter("userPass");  
     
    Connection conn = null;
    Statement stmt = null;
    
   /* if(username1.equals("shashi") || password1.equals("1234") ){  
        RequestDispatcher rd=request.getRequestDispatcher("servlet2"); 
        rd.forward(request, response);
    }
        
    else{  
        out.print("Sorry UserName or Password Error!");  
        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        rd.include(request, response);  
                      
        } */
    
    
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
         sql =  "INSERT INTO `emp`.`register`(`username`,`password`)VALUES('" + username1+"','" + password1 + "')";
       // out.println(sql);
         int a= stmt.executeUpdate(sql);
         
        if(a>0)
        {
        	System.out.println("Query Executed");
        	out.println("Click to sign in");
        	RequestDispatcher rd=request.getRequestDispatcher("/relogin.html");  
            rd.include(request, response); 
        }
        else
        {
        	System.out.println("something wrong");
        }
       
        stmt.close();
        conn.close();
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    

   
    }
  
} 


/*
 * if(username1!=null && password1!=null && username1.length()<7 && password1.length()<7 && username1!=password1)
        {execute }
        else
        {
        	out.println("something wrong");
        	out.println("Check the following \n 1.Username and password cannot be NULL. \n 2.username size should be greater than 6. \n 3.Password size should not be less than 6. ");
        	RequestDispatcher rd=request.getRequestDispatcher("/register.html");  
            rd.include(request, response);
        }
      
 */

