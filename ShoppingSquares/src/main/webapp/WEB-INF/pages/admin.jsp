<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="css/style.css">
                 <title>Admin Login</title>
        </head>

        <body>
<div class="container admin">
	<h1>Admin Login</h1>
	<h2 style="color: red">${message}</h2>
    <form:form id="AdminloginForm" modelAttribute="admin" method="post">
   		<fieldset>
        	<legend>Admin Name</legend>   
            <form:input path="aname" name="aname" id="aname" />
        </fieldset>
        <fieldset>
        	<legend>Password</legend>   
        	<form:password path="apassword" name="apassword" id="apassword" />
         </fieldset>
         <form:button id="admin" name="admin">Login</form:button>
         <a href="home.htm">Home</a>
   </form:form>
</div>

        </body>

        </html>