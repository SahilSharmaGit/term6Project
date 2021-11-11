<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
<style media="screen">
.products h1{
  position: relative;
  top: -21px;
}
.products h1, a{
  text-align: center;
  background: black;
  color:white;
  padding: 10px;
}
.products a{
  margin-right: 30px;

  padding: 5px;
}
  .products{
    position: absolute;
    top:100px;
    left: 10%;
    width:80%;
    margin:auto;
background:lightgray;
  }
  table{
font-size:20px;
    margin:auto;
  }
  input,select{
    width:100%;
    height:30px;
    font-size:20px;
margin-top:5px;
margin-bottom:10px;
  }
  input[type='submit'], input[type='reset']{
    width: auto;
 }
h2{
  text-align: center;
  color:red;
}
h3{
  color:red;
}
h3:first-of-type{
  color:green;
}

</style>
      </head>
  <body>

<jsp:include page="adminNav.jsp"/>
<div class="products">
  <h1> Product Insert Form </h1>
<h2> ${msg} </h2>
    <form  action="insertProducts.htm" enctype="multipart/form-data" method="post">
      <table>
             <tr>
            <td>Supplier Id: </td>
            <td> <input type="text" name="supplier_id" ></td>
          </tr>
          <tr>
            <td>Product Title: </td>
            <td> <input type="text" name="pTitle" ></td>
          </tr>
          <tr>
            <td>Product Description: </td>
            <td> <input type="text" name="pDesc" ></td>
          </tr>
          <tr>
            <td>Product Price: </td>
            <td> <input type="text" name="price" ></td>
          </tr>
          <tr>
            <td>Product Discount: </td>
            <td> <input type="text" name="discount" ></td>
          </tr>
          <tr>
            <td>Product Quantity: </td>
            <td> <input type="text" name="quantity" ></td>
          </tr>
          <tr>
            <td>Product Category: </td>
            <td >
               <select class="" name="category">
                 <!-- for each loop -->
                 <option>Product_Id Category_Name</option>
               <c:forEach items="${cateList}" var="list">
                    <option value="${list.cate_id} ${list.category}">
                    ${list.cate_id} ${list.category}
                    </option>
               
               </c:forEach>
                 
                </select>
            </td>
          </tr>
          <tr>
          	<td>Upload Photo</td>
          	<td> <input type="file" name="photo"> </td>
          </tr>
<tr>
  <td colspan="0" > <a href="insertCategory.htm">Add New Category</a>
</td>
</tr>
<tr>
  <td> <input type="submit" name="" value="Add Product"> </td>
  <td> <input type="reset" name="" value="Reset"> </td>
</tr>
      </table>
    </form>
</div>
  </body>
</html>
