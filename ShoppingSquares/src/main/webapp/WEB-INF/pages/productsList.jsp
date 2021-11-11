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
background: gray;
}
table{
  font-size: 25px;
margin: auto;
}
td{
color:white;
font-weight:bold;}
td,th{
  padding: 15px;
}
    </style>
  </head>
  <body>


<jsp:include page="adminNav.jsp"/><main>
  <div>
    <table border='1'	>
      <tr>
		<th>Product Id</th>
		<th>Product Title</th>
		<th>Description</th>
		<th>Price</th>
		<th>Discount</th>
		<th>Quantity</th>
		<th>Category</th>
        <th>Action </th>
      </tr>
  <c:forEach var="product" items="${productsList}">
      <tr>
          <td>${product.pid}</td>
          <td>${product.pTitle}</td>
          <td>${product.pDesc}</td>
          <td>${product.price}</td>
          <td>${product.discount}%</td>
          <td>${product.quantity}</td>
          <td>${product.category}</td>
          <td><a href="#">Delete</a> </td>
      </tr>
  </c:forEach>
      
    </table>
  </div>
</main>

  </body>
</html>
