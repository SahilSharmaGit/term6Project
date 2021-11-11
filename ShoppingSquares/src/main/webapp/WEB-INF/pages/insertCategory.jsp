<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
<style media="screen">
 .cateForm{
    width:80%;
    background:lightgray;
    margin-top:100px;
    margin-left:10%;
  }
  table{
    background:gray;
    width:100%;
    margin:auto;
  }
  td:first-of-type{
    float:right;
    color:white;
  }
  td input{
    width:100%;
height:30px;
font-size:20px;
  }
  td{
    font-size:25px;

    padding:30px;
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
    <div class="cateForm">
      <form  action="savecat.htm" method="post" >
<table>
  <tr>
<td>Category Id</td>
    <td><input type="text" placeholder="category id  ${id} " name="cate_id" value="">
  </td>
    <td>
      </tr>
      <tr>
        <td>Category Name</td>
        <td>
      <input type="text" placeholder="enter category name" name="category" value="">
    </td>
    <td><h3>${cateS}</h3> <h3>${cateE}</h3></td>
    
  </tr>
  <tr>
    <td>
     <input type="submit" name="" value="Add Category">
</td>
  </tr>
</table>
      </form>

    </div>


  </body>
</html>
