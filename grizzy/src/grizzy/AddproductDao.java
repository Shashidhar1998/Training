package grizzy;
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;
public class AddproductDao {

	
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost/project?useSSL=false","root","password-1");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}  
	
	public static int save(Addproduct add){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("insert into addproduct(Id,Name,Category,Brand,Description,Price) values(?,?,?,?,?,?)"); 
	        ps.setString(1,add.getId());  
	        ps.setString(2,add.getName());  
	        ps.setString(3,add.getCategory());  
	        ps.setString(4,add.getBrand());   
	        ps.setString(5,add.getDescription());
	        ps.setString(6,add.getPrice());
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	} 
	
	public static List<Addproduct> getAllRecords(){  
	    List<Addproduct> list=new ArrayList<Addproduct>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from addproduct");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Addproduct u=new Addproduct();  
	            u.setId(rs.getString("Id"));  
	            u.setName(rs.getString("Name"));  
	            u.setCategory(rs.getString("Category"));  
	            u.setBrand(rs.getString("Brand"));  
	            u.setDescription(rs.getString("Description"));  
	            u.setPrice(rs.getString("Price"));  
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    
	    list.forEach((k)-> System.out.println(k.getId()+" "+k.getName()));
	    return list;  
	} 
	
}
