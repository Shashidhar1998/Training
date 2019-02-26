
<%@page import="grizzy.AddproductDao"%>

<jsp:useBean id="add" class="grizzy.Addproduct"></jsp:useBean> 
<jsp:setProperty property="*" name="add"/>  
  
<%  
add.setId(request.getParameter("Id"));
add.setName(request.getParameter("Name"));
add.setCategory(request.getParameter("Category"));
add.setBrand(request.getParameter("Brand"));
add.setDescription(request.getParameter("Description"));
add.setPrice(request.getParameter("Price"));
int i=AddproductDao.save(add);  
if(i>0){  
	RequestDispatcher rd=request.getRequestDispatcher("/navigator.jsp"); 
    rd.forward(request, response);
}else{  
	RequestDispatcher rd=request.getRequestDispatcher("servlet3"); 
    rd.forward(request, response);
}  
%> 