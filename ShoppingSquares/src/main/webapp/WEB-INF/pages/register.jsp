<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">

.options{
display: none;
}
nav{
padding: 40px;
}
a[href="register.jsp"]
  {
       color:black;
    padding:10px;
    background:white;
  }

</style>
            <title>Registration</title>
        </head>

        <body>
 <jsp:include page="nav.jsp"/>
<div class="container">
<h1>Registration Form</h1>
<h2 style= "color:red;">${msg}</h2>
   <form:form id="regForm" modelAttribute="customer" method="post">
            <fieldset>
              <legend>Email</legend>
               <form:input path="email" name="email" id="email" />
            </fieldset>
            <fieldset>
              <legend>Phone</legend>
              <form:input path="phone" name="phone" id="phone" />
            </fieldset>
            <fieldset>
              <legend>UserName</legend>
               <form:input path="username" name="username" id="username" />
            </fieldset>
            <fieldset>
 	           <legend>Password</legend>
        	    <form:password path="password" name="password" id="password" />
    	    </fieldset>
            <form:button id="register" name="register">Register</form:button>
   </form:form>
</div>


        </body>

        </html>