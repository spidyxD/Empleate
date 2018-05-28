<%-- 
    Document   : registOfferer
    Created on : 24/03/2018, 05:13:36 PM
    Author     : Addiel
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Empleate</title>
        <%@include file="includesHead.jspf"%>
        <%@include file="createLocate.jspf"%>
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
        <link rel="stylesheet" type="text/css" href="css/registOfferer.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="error" scope="request" class="java.lang.String"/>
        <div class="cuerpo container"><!-- nom,apel,nation,phone,email,recidence**login** -->
            <h4>Formulario para registro de Oferentes</h4>
            
            <div class="row">
                <form enctype="multipart/form-data" id="formularioOff" action="javascript:uploadOfferer_CV();" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s4">
                            <input id="nombre" type="text" name="nombre" class="validate" value="">
                            <label for="nombre">Nombre</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="apellido" type="text" name="apellido" class="validate" value="">
                            <label for="apellido">Apellido</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="nacionalidad" type="text" name="nacionalidad" class="validate" value="">
                            <label for="nacionalidad">Nacionalidad</label>
                        </div>
                    </div>
                    <div class="row">

                        <div class="input-field col s6">
                            <input id="telefono" type="text" name="telefono" class="validate" value="">
                            <label for="telefono">Telefono</label>
                        </div>

                        <div class="input-field col s6">
                            <input id="email" type="email" name="email" class="validate" value="">
                            <label for="email">Email</label>
                        </div>
                    </div>
                    <div class="row">        
                        <div class="input-field col s3">
                            <input id="direccion" type="text" name="residencia" class="validate" value="">
                            <label for="direccion">Residencia</label>
                            <h1 hidden name="locate"></h1>
                        </div>
                        <div class="input-field col s3">
                            <a class="waves-effect waves-light btn modal-trigger" href="#createLocate">Ubicacion </a>
                        </div>
                        <div class="input-field col s3">
                            <input name="localeX" id="localeX" type="value" class="validate" readonly hidden value="">                           
                        </div>
                        <div class="input-field col s3">    
                            <input name="localeY" id="localeY" type="value" class="validate" readonly hidden value="">

                        </div>    
                    </div>        
                    <div class="row">

                        <div class="input-field col s6">
                            <input  name="username" id="userN" type="text" class="validate" value="">
                            <label for="username">Username</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="password" id="key" type="password" name="password" class="validate"  value="">
                            <label for="password">Password</label>
                            <p>
                            <label>
                            <input type="checkbox" onclick="showPass()">
                            <span>Show Password</span>
                            </label>
                            </p>
                            <script>
                            function showPass() {
                                var x = document.getElementById("key");
                                if (x.type === "password") {
                                    x.type = "text";
                                } else {
                                    x.type = "password";
                                }
                            }
                            </script>
                        </div>
                            
                    </div>
                    <div class="input-field col s6">
                        <input class="btn"  type="submit" value="Ingresar" >
                    </div>
                     <div class="input-field col s6">
                         
                        <fieldset>
                          <legend>Agregar Curriculum</legend>
                          <input class="btn" type="file" name="pdf" id="pdf">
                        </fieldset>        
                          
                    </div>  
                      <div id="mensaje"></div>
                </form>
            </div>
        </div>
        <div class="error">
            <%if (error != null) {%>
            <p><%=error%></p>
            <%}%>
        </div>
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        
    </body>
</html>
<script>   
   function loaded(event){	
        $("#formularioOff").on("submit",validate);
     }
   $(loaded);        
</script>


