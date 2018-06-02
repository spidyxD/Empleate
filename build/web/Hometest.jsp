<%-- 
    Document   : Hometest
    Created on : Mar 23, 2018, 9:45:43 AM
    Author     : Andrés Gutiérrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>HomePage</title>
    </head>
    <body>
         
        <Header> 
            <h1 align="center">Empleate</h1>
            <h2 align="center">  Tu lugar para encontrar tu empleo ideal</h2><br><br>
        </Header>
    <center>
            <div class="row">
              <form class="col s12">
                <div class="row">
                  <div class="input-field col s12">
                    <input id="email" type="email" class="validate" placeholder="email">
                    
                    <input id="password" type="password" class="validate" placeholder="password">
                     
                    <input id="submit" type="submit" value="login" class="login" />
                  </div>
                </div>
              </form>
            </div>
    </center>
    </body>
</html>
