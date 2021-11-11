<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="upload.htm" method="post" enctype="multipart/form-data">
<p>Upload file: </p>
<input type="file" name="image">
<input type="text" name="id">

<input type="submit" value="upload">
</form>
</body>
</html>