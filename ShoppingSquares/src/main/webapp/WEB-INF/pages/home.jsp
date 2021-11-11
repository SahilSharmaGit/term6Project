	<%@page import="java.sql.Blob"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="java.io.InputStream"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <script type="text/javascript" src="css/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<style type="text/css">
.options{
display:block;
}
a[href="home.htm"]
  {
     color:white;
    padding:5px 20px;
    background:green;  
   }

</style>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
<jsp:include page="nav.jsp"/>

    <section>
      <button id="btn1" type="button" onclick="reverseImage()"><</button>
      <img src="css/shopping0.jpg" id ="nature"  alt="">
      <button id="btn2" type="button" onclick="forwardImage()">></button>
    </section>
<figure>
<c:forEach var="product" items="${productsList}">
<div class="shirt">
<!--  <img src="css/shirt.jpg">-->
<img src="http://localhost:8080/ShoppingSquares/css/${product.photo_name}">
		<div class="hover">
  			<ul>
<!-- 			   <li><c:out value="css/${product.photo_name}"></c:out></li>-->
			    <li>Name:  ${product.pTitle}</li>
			    <li>About:  ${product.pDesc}</li>
			    <li>Price: ${product.price}</li>
			    <li>Discount: ${product.discount}</li>
			   	<form action="cartCount.htm" method="post">
			     <input type="hidden" name="sid" value="${product.supplier_id}">
			    <li>
				    <input type="submit" 
				    style="color:white; background:black; padding: 5px; " 
				    value="ADD TO CART">
			    </li>
			   
					   
			    </form>
 
			</ul>
		</div>
</div>

</c:forEach>
</figure>
</div>
  </body>
</html>
