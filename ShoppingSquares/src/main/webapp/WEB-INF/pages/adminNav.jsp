<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <style media="screen">
    .adminNav{
        position: fixed;
        top:0;
        left:10%;
        width: 80%;
background: black;
padding: 20px;
      }
  nav{
        width: inherit;
width: 100%;
text-align: center;
margin: auto;
      }
   nav a{
        color:white;
        font-size: 25px;
margin-left: 20px;
      }

    </style>
  </head>
  <body>
<div class="adminNav">
  <nav>
	<a href="admin.htm">Home</a>
    <a href="customerList.htm">Customer List</a>
    <a href="insertProducts.htm">Add Products</a>
    <a href="productsList.htm">Products</a>
    <a href="#">Order Placed</a>
<%! String name = null; %>
    <%
    	String name = (String)session.getAttribute("aname");
    	if(name != null)
    	{
    		out.print("<a href='#'> Welcome, "+name.toUpperCase()+"</a>");
    	
    	}
    	%>
    <a href="adminLogout.htm">Logout</a>
  </nav>
</div>
  </body>
</html>
