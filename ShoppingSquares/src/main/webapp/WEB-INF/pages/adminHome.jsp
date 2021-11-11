<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.adminhome{
 width: 80%;
  margin: auto;
  margin-top: 100px;
background: lightgray;
padding: 50px;
}
h1{
margin-top: 50px;}
</style>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<jsp:include page="/WEB-INF/pages/adminNav.jsp"/>

<div class="adminhome">
<h1 >No. of customer visit today</h1>
<h1 >No. of products sold</h1>
<h1 >No. of customers</h1>
</div>
</body>
</html>