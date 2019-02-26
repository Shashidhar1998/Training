<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <title>Bootstrap Example</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button5 {background-color: #cccccc;}

.card {
  box-shadow: 0 4px 8px 0 rgba(1, 1, 1, 1);
  max-width: 300px;
  margin: 22px;
  text-align: center;
  font-family: arial;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}
</style>

</head>
<body>


<nav class="navbar navbar-default" role="navigation">

    <div class="navbar-header">
    
   
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

        <div class="col-sm-3 col-md-3 pull-center">
            <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="q">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
            </form>
        </div>
        <div class="nav navbar-nav pull-center">
          <ul>
                    <% String name = request.getParameter("username"); %> 
   
              <li class="#"><a href="#"><strong><p>Welcome   <% out.print(name); %></p></strong></a></li>
          </ul>
         </div>


         <div>
           <ul class="nav navbar-nav pull-right">
               <form action="servlet2" method="post">
               <button class="button button5">Logout</button>
             </form>
           </ul>
          </div>


      </div>
</nav>



<div class="container-fluid">
  <div class="row">
    <div class="col-sm-4">
      <div class="card">
        <img src="/Users/shashidharreddy/img_avatar.png" alt="John" style="width:100%">
        <h1>Shashidhar</h1>
        <p class="title">CEO & Founder, Chaser</p>
        <p>Lovely Professional University</p>
        <div style="margin: 24px 0;">
          <a href="#"><i class="fa fa-dribbble"></i></a>
          <a href="#"><i class="fa fa-twitter"></i></a>
          <a href="#"><i class="fa fa-linkedin"></i></a>
          <a href="#"><i class="fa fa-facebook"></i></a>
        </div>
        <p><button>Contact</button></p>
      </div>
    </div>
    <div class="col-md-8" >
      <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#add" >Add</a>
    </li>
    <li class="nav-item">
      <a class="nav-link " data-toggle="tab" href="#products" >Products</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" data-toggle="tab" href="#vendors" >Vendors</a>
    </li>
  </ul>
  <br>





  <div class="container-fluid tab-content">
              <div id="add" class="container-fluid tab-pane active"><br>
              
                        <jsp:include page="Addproduct2.html" />
                           
              </div>
              
             <div id="products" class="container tab-pane fade"><br>
                <jsp:include page="products.jsp" />
             </div>
             <div id="vendors" class="container tab-pane fade"><br>
                    <h3>Vendors</h3>
                    <p>Ut enim ad minim veniam, hgjjk</p>
             </div>
    </div>


  </div>


</div>



</body>
</html>

     
