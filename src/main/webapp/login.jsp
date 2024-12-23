<%--
  Created by IntelliJ IDEA.
  User: elmo
  Date: 12/21/2024
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="login.css">

</head>
<body>
<h1><a href =http://localhost:8080/web_appp_war_exploded/> FSTM BUVETTE </a></h1>

    <form action="url_servlet" method="POST">  <!-- methode = "GET"  is  default-->
        <br/>

        <label for="first_number"> A </label>
        <input type="text" id="first_number" name="first_number">

        <br/>
        <label for="second_number"> B </label>
        <input type="text" id="second_number" name="second_number">


        <input type="submit" value="login">
    </form>
</body>
</html>
