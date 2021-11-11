
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
String uname=null;%>
<%
uname = (String)session.getAttribute("username");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <link rel="stylesheet" href="css/style.css">
 <script type="text/javascript" res="css/script.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="menu">
      <nav class="navbar">
 
        
        <a href="#"
         onmouseover="document.getElementById('custList').style.display='block';">
             Customer</a>
      <a  href="#">
      <%
      	if(null != uname || "".equals(uname))
      	{
      		out.print("Hello, "+uname);
      	}
      	%>
      </a>
      <a href="home.htm" >Home</a>
      <a href="about.jsp">About Us</a>
      <a href="contactus.jsp">Contact Us</a>
      <a href="admin.htm" >Admin</a>
          <ul id="custList"  
      onmouseover="document.getElementById('custList').style.display='block';"
     onmouseout="document.getElementById('custList').style.display='none';">

        <li><a href="login.htm" >Login</a></li>
        <li><a href="register.htm">Register</a></li>
        <li><a href="profile.htm">Profile</a> </li>
        <li><a href="logout.htm">Logout</a></li>
      </ul>
  
  <div class="options">
    <form class="" action="index.html" method="post">
      <select class="" name="">
          <option value="All">All</option>
       	  <c:forEach items="${categoryList}" var="list">
                    <option value="${list.category}">${list.category}</option>
          </c:forEach>
        </select>
      <input type="text" name="" value="">
        <i></i>
     <a href="mycart.htm" style="text-decoration: none">Cart
     <i class="fas fa-shopping-cart"></i>
       {
       <%! String val = null; %>
       <%
    	   val =(String)session.getAttribute("count");
       
       			if(val == null){
       			out.print("0");
       			}
       			else
       			{
       				out.print(val);
       			}
       	%>
       	}</a>
    </form>
  </div>
</nav>

      <header>
      <h1>Shopping Squares</h1>

      </header>
    </div>

</body>
</html>