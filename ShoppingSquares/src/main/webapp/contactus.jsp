<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <link rel="stylesheet" href="style.css">
    <meta charset="utf-8">
    <title></title>
<style media="screen">
.options{
display: none;
}
nav{
padding: 40px;
}
a[href="contactus.jsp"]
  {
           color:black;
    padding:10px;
    background:white;
  }

  .contactus{
    width: 80%;
margin: auto;
      background: rgba(0,0,0,0.5);
      margin-top: 100px;

  }
  main{
    width: 100%;

  margin: auto;

}
  table,tr{
width: 100%;
    margin: auto;
  }
  td{
text-align: center;
line-height: 80px;
  }
  tr:hover{
    background: rgba(0,0,0,0.7);
color:white;
  }
  tr:first-of-type{
    font-size: 4vw;
    color: white;
  }
  tr:first-of-type + tr{
    font-size: 4vw;
    color: white;
  }
  tr:last-of-type{
    color:white;
    font-size: 2.5vw;
  }
</style>
  </head>
  <body>

    <jsp:include page="/WEB-INF/pages/nav.jsp"/>
<div class="contactus">

<main>
  <table>
    <tr>
      <td> <i class="fas fa-map-marker-alt"></i></td>
      <td> <i class="fas fa-phone-alt"></i></td>
      <td><i class="fas fa-envelope"> </td>
    </tr>
<tr>
  <td>ADDRESS</td>
  <td>PHONE</td>
  <td>EMAIL</td>
</tr>
      <tr>
        <td>Shoppers Square has its head<br> office in Mumbai, India.</td>
        <td>8888888888</td>
        <td>shoppingsquares@gmail.com</td>
      </tr>
  </table>

</main>
</div>

  </body>
</html>
