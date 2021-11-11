<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC</title>
</head>
<body>
<h1> ${msg} </h1>
    <div align="center">
        <h1>Spring MVC</h1>
        <form method="post" action="upload.htm" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Pick :</td>
                    <td><input type="file" name="file"  /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>