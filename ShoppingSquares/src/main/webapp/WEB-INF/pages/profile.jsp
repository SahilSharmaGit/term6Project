<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<!--

   <link rel="stylesheet" href="css/style.css">
--><meta charset="ISO-8859-1">
<style>
table,table h1{
	margin: auto;
	background: white;
	width: 50%;
	font-size: 30px;
	line-height: 80px;
	text-align: center;
background: rgba(255, 255, 255, 0.4);
}
#tab:hover{
	transition: 0.1s;
	background: rgba(255, 255, 255, 0.9);
border:10px solid gray;
}
#tab tr:hover{
	background: black;
	color:white;
}
#tab tr:first-of-type:hover{
background: none;
}

#tab tr td a{
	color:black;
	margin-right: 30px;
	font-size: 20px;
	float: right;
}
</style>
<title>Customer Profile Page</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<table id="tab">
<br>
<br>
<br><br>
<br><br>

	<h1>	Welcome to Profile Customer</h1>
<tr >
<td colspan="2"><a href="#">update profile?</a></td>
</tr>
	<tr>
		<th>UserName: </th> <td>${name}</td>
	</tr>
	<tr>
		<th>Phone: </th>    <td>${phone}</td>
</tr>
<tr>
		<th>Email: </th>    <td>${email}</td>
	</tr>
</table>
</body>
</html>
