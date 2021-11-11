<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Billing Address</title>
    
<style media="screen">
  .options{
display: none;
}
  
  .ship{
    width:80%;
    background: rgba(250,250,250,0.5);
    margin:auto;
    margin-top: 100px;
    font-size: 20px;
  }
  body{
  background-image: url(back.jpg);
background-position: fixed;
background-repeat: no-repeat;
background-size: cover;
background-attachment: fixed;

}
  
  .ship:hover{
  border:2px solid black;
   background: rgba(250,250,250,0.6);
  
 } 
  .ship table{
    margin: auto;
}
.ship input{
  margin-top: 10px;
height: 30px;
width: 100%;
}
.ship tr:last-of-type input:hover{
  background: white;
  color: black;
}
.ship h1,h2{
  text-align: center;
}
h2{
color:yellow;
}
.ship tr:last-of-type input{
  padding: 5px;
  background: black;
  color:white;
  float: right;
}
.ship a{
  padding: 5px;
  color:white;
  background: black;
margin-left: 50px;
}
nav{
padding: 40px;
}

.ship p{
  text-align: center;
  background: black;
  color:white;
  padding: 3px;
}
</style>
  </head>
  <body>
  <jsp:include page="nav.jsp"/>
  
    <div class="ship">
<h1>Billing Address</h1>
<h2>${msg}</h2>
    <form:form id="addressForm" action="saveAddress.htm"  modelAttribute="shipping" method="post">

      <table>
        <tr>
          <td>Full Name: </td>
          <td> 
 		     <form:input autofocus="autofocus" path="fullname" name="fullname" id="fullname" />
	 	  </td>
       	 </tr>
        <tr>
          <td> Address </td>
          <td>
          <form:textarea  path="address" name="address" id="address" 
          rows="5" cols="30" placeholder="Enter your address"/>
          </td>
        </tr>
        <tr>
            <td>City</td>
            <td> <form:input path="city" name="city" id="city"/> </td>
        </tr>
        <tr >
          <td>Total Products</td>
          <td > <form:input  path="totalProducts" readonly="true" id="totalProducts" name="totalProducts" value="${productsCount}"/> </td>
        </tr>
        <tr>
        <td>Total Amount</td>
          <td>
           <form:input  path="totalAmount" readonly="true" name="totalAmount" id="totalAmount" value="${amount}"/>
          </td>
        </tr>

        <tr >
          <td>Mode of Payment: </td>
          <td ><p>Cash on Delivery</p></td>
        </tr>
        <tr>
          <td> <input type="submit" value="Confirm and Buy"> </td>
          <td> <a href="home.htm">Cancel</a> </td>
        </tr>
      </table>
    </form:form>
  </div>

  </body>
</html>
