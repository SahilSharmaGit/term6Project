<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form id="image" modelAttribute="image"  method="post" enctype="multipart/form-data">
<p>Upload file: </p>
<form:input path="bytes" id="bytes"  type="file" name="bytes" />
<form:input  type="text" path="id" id="id" name="id"/>

<form:button id="upload" type="submit" value="upload"/>
</form:form>

</body>
</html>