<%-- 
    Document   : registCompany
    Created on : 24/03/2018, 05:13:12 PM
    Author     : Addiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
      <title>Empleate</title>
      <%@include file="includesHead.jspf"%>
  </head>
  <body>
    <%@include file="header.jspf"%>
    <div class="cuerpo container"><!-- nom,apel,nation,phone,email,recidence**login** -->
      <h4>Formulario para registro de Empresas</h4>
      <div class="row">
    <form action="RegistCompany" method="post" class="col s12">
      <div class="row">
        <div class="input-field col s4">
          <input id="nombreEmpresa" type="text"  class="validate">
          <label for="nombreEmpresa">Nombre de la empresa</label>
        </div>
           <div class="input-field col s4">
          <input id="telefono" type="tel" class="validate">
          <label for="telefono">Telefono</label>
        </div>
          <div class="input-field col s4">
          <input id="website" type="url" class="validate">
          <label for="website">website</label>
        </div>
        
      </div>
      <div class="row">
        <div class="input-field col s6">
          <input id="Direccion" type="text" class="validate">
          <label for="Direccion">Direccion </label>
        </div>
        
        <div class="input-field col s6">
          <input id="location" type="text" class="validate">
          <label for="location">Localizacion</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="descripcion" type="text" class="validate">
          <label for="descripcion">Descripcion de la empresa</label>
        </div>
        
      </div>
      <div class="row">
        <div class="input-field col s6">
          <input id="username" type="text" class="validate">
          <label for="username">usename</label>
        </div>
        <div class="input-field col s6">
          <input id="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
      </div>
      <div class="input-field col s12">
        <input class="btn"  type="submit" value="Ingresar">
      </div>
    </form>
  </div>
    </div>
    <%@include file="footer.jspf"%>
    <!--JavaScript at end of body for optimized loading-->
    <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
    <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
    <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
  </body>
</html>

<style media="screen">

.cuerpo{
  height: auto;
  box-shadow: 8px 8px 13px #999;
  margin-top: 20px;
}
.input-field label{
  color:black;
}

p,h1{
  margin: 0;
}

</style>

