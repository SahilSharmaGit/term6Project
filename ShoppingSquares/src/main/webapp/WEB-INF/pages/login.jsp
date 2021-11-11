<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <link rel="stylesheet" href="css/style.css">
<style type="text/css">
.options{
display: none;
}
nav{
padding: 40px;
}
a[href="login.htm"]
  {
          color:black;
    padding:10px;
    background:white;
  }

</style>        
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>

        <body>
<!-- <div class="loginContainer">

            <form:form id="loginForm" modelAttribute="login" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username: </form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password:</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="login" name="login">Login</form:button>
                        </td>
                    </tr>

                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="home.html">Home</a>
                        </td>
                        <td> <a href="register.htm">to log in plz register first</a> </td>
                    </tr>
                </table>
            </form:form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
</div>-->
<jsp:include page="nav.jsp"/>
<div class="container">
<h1>Login Form</h1>
<h2 style= "color:red;">
${message}</h2>
            <form:form id="loginForm" modelAttribute="login" method="post">
            <fieldset>
              <legend>UserName</legend>
              <form:input autofocus="autofocus" path="username" name="username" id="username" />
            </fieldset>
            <fieldset>
              <legend>Password</legend>
              <form:password path="password" name="password" id="password" />
            </fieldset>
            <form:button id="login" name="login">Login</form:button>
                        <a href="register.htm">to log in plz register first</a>
              </form:form>
      </div>

        </body>

        </html>