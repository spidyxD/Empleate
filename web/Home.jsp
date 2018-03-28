
<%@page import="Empleate.domain.Job"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
      <title>Empleate</title>
      <%@ include file="includesHead.jspf" %>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="css/myStyle.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <link rel="stylesheet" type="text/css" href="css/util.css">
       <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
  </head>
  <body>
  <%@ include file="header.jspf" %>
    <div class="cuerpo">
      <section class="section">
          <jsp:useBean id="top" scope="request" type="List<Job>" class="java.util.ArrayList"/>
        <div class="row">
          <div class="carousel carousel-slider center">
            <div class="carousel-fixed-item center">
            </div>
              <%for(Job j: top){%>
              
            <div class="carousel-item red white-text" href="#one!">
              <h2><%=j.getNameJob()%></h2>
              <p class="white-text">job1 descrip</p>
            </div>
              <%}%>
          </div>
        </div>
      </section>
    </div>
    <div class="cuerpo2">
        <div class="parallax-container">
          <div class="parallax"><img src="images/5.jpg"></div>
        </div>
    </div>
   <%@ include file="footer.jspf" %>
    <!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
    <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
    <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
  </body>
</html>

