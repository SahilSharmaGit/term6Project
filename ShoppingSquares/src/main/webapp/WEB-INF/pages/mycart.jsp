<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <style media="screen">
   .options{
display: none;
}
nav{
padding: 40px;
}

  .div1 h1{
        color:black;
        margin-bottom:20px;
      }
  .div1 h2{
        color:yellow;
        margin-bottom:10px;
      }

.div1{
  color:white;
text-align:center;
  margin:auto;
  width:80%;
background:rgba(250,250,250,0.6);
margin-top:150px;
}
table{
  width:50%;
color:black;
font-size:20px;
  }
img{
  width:30%;
}
.div2{
width:40%;
  float:right;
}
tr td {
	background: yellow;
}
      </style>
  </head>
  <body>
<jsp:include page="nav.jsp"/>

<div class="div1">
  <h1>Welcome to your cart</h1>
	<h2>${msg}</h2>
  <div class="div2">
  <img src="shirt.jpg" alt="">

  </div>
  <table>
    <tr>
      <th>Product Name</th>
      <th>Original Price</th>
      <th>Discount</th>
      <th>Final Price</th>
    	<th>Action</th>
      <th>Quantity</th>
    
    </tr>
    <c:forEach var="p" items="${list}">
    	<tr>
    		<td>${p.pTitle}</td>
    		<td>${p.price}</td>
    		<td>${p.discount}%</td>
    		<td>${ p.price - (p.price * p.discount / 100)} </td>
    	
    		<td><a href="remove.htm?sid=${p.supplier_id}">Remove item</a></td>
    	</tr>
    
    </c:forEach>
    
    
    <tr>
      <td><a href="shipping.htm">Proceed to buy</a></td>
    <td><a href="home.htm"> Leave for now</a> </td>
    </tr>
    
  </table>
  </div>

  </body>
</html>
