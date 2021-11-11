<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <style media="screen">
 
 main{
  width: 80%;
  margin: auto;
  margin-top: 100px;
}
main div{
  width: 100%;
background: lightgray;
}
table{
  font-size: 25px;
margin: auto;
}
td,th{
  padding: 15px;
}
    </style>
  </head>
  <body>


<jsp:include page="adminNav.jsp"/><main>
  <div>
    <table>
      <tr>
        <th>Customer UserName</th>
        <th>Customer Email</th>
        <th>Customer Phone No.</th>
        <th>Password</th>
        <th> Action </th>
      </tr>
  <c:forEach var="cust" items="${custList}">
      <tr>
          <td>${cust.username}</td>
          <td>${cust.email}</td>
          <td>${cust.phone}</td>
          <td>${cust.password}</td>
          <td><a href="#">Delete</a> </td>
      </tr>
  </c:forEach>
      
    </table>
  </div>
</main>

  </body>
</html>
