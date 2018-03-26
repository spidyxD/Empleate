
<%@page import="Empleate.domain.Job"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
      <title>Empleate</title>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="css/myStyle.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  </head>
  <body>
    <div class="header">
      <div class="titulo">
        <h1>Empleate</h1>
        <h2>Busque su lugar!</h2>
      </div>
      <div class="test">
        <nav>
          <div class="nav-wrapper">
            <ul class="right hide-on-med-and-down">
              <li><input id="icon_prefix" type="text" class="validate"></li>
              <li><a href="#"><i class="material-icons right">search</i></a></li>
              <li><a href="#"class="waves-effect waves-light btn">Registrarse</a></li>
              <li><a href="#"class="waves-effect waves-light btn">Entrar</a></li>
            </ul>
          </div>
        </nav>
      </div>
    </div>
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
    <div class="footer contenedor">
      <a href="tel:+50661688613"><strong>Telefono </strong><span>61688613</span></a>
      <a href="mailto:andres.gutierrez.arcia@gmail.com"><strong>E-mail </strong><span>andres.gutierrez.arcia@gmail.com</span></a>
    </div>
    <!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
    <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
    <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
  </body>
</html>

