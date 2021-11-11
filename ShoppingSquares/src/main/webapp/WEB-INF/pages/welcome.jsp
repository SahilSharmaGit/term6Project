<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <script type="text/javascript" src="script.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<style type="text/css">
.options{
display: none;
}
nav{
padding: 40px;
}

</style>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <div id="main">

      <div id="bigImg">
          <img src="css/cart.jpg" alt="CART IMAGE">
        <h2 style="color:yellow; font-size:20px; text-decoration: none">${msg}</h2>
          <h1>Shopping made Easy</h1>
      </div>
<jsp:include page="/WEB-INF/pages/nav.jsp"/>

</div>
<footer>
<h1>
copytright @ shoppingsquares.com
<h1></h1>
</footer>
  </body>
</html>
