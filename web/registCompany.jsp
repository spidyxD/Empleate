<%-- 
    Document   : registCompany
    Created on : 24/03/2018, 05:13:12 PM
    Author     : Addiel
--%>

<%@page import="Empleate.domain.Login"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
         <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <title>Empleate</title>
        <%@include file="includesHead.jspf"%>
        <%@include file="createLocate.jspf"%>
        <%Login login = (Login)session.getAttribute("login");%>
       <link rel="stylesheet" type="text/css" href="css/registCompany.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="error" scope="request" class="java.lang.String"/>
        <jsp:useBean id="param" scope="request" type="List<String>" class="java.util.ArrayList"/>
        <%boolean lleno = param.size()>0;%>
        <div class="cuerpo container"><!-- nom,apel,nation,phone,email,recidence**login** -->
            <h4>Formulario para registro de Empresas</h4>
            <div class="row">
                <form action="RegistCompany" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s4">
                            <input name="nombreEmpresa" id="nombreEmpresa" type="text" class="validate" <%if(lleno){ %>value="<%=param.get(0)%>" <%}%>> 
                            <label for="nombreEmpresa">Nombre de la empresa</label>
                        </div>
                        <div class="input-field col s4">
                            <input name="telefono" id="telefono" type="text" class="validate" <%if(lleno){ %>value="<%=param.get(1)%>" <%}%>>
                            <label for="telefono">Telefono</label>
                        </div>
                        <div class="input-field col s4">
                            <input name="website" id="website" type="url" class="validate" <%if(lleno){ %>value="<%=param.get(2)%>" <%}%>>
                            <label for="website">website</label>
                        </div>

                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input name="direccion" id="direccion" type="text"   readonly>
                            <label for="direccion">Direccion </label>
                        </div>
                    </div>         
                    <div class="row">
                        <div class="input-field col s4">
                           <a class="waves-effect waves-light btn modal-trigger" href="#createLocate">Ubicacion </a>
                        </div>
                        <div class="input-field col s4">
                           <input name="localeX" id="localeX" type="value" class="validate" readonly hidden>
                           
                    </div>
                        <div class="input-field col s4">    
                            <input name="localeY" id="localeY" type="value" class="validate" readonly hidden>
                            
                        </div>
                    </div>
                           
                    <div class="row">
                        <div class="input-field col s12">
                            <input name="descripcion" id="descripcion" type="text" class="validate" <%if(lleno){ %>value="<%=param.get(4)%>" <%}%>>
                            <label for="descripcion">Descripcion de la empresa</label>
                        </div>

                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input name="username" id="username" type="text" class="validate" <%if(lleno){ %>value="<%=param.get(5)%>" <%}%>>
                            <label for="username">Username</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="password" id="key" type="password" class="validate">
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
                    <div class="input-field col s12">
                        <input class="btn"  type="submit" value="Ingresar">
                    </div>
                </form>
            </div>
        </div>
        <div class="error">
            <%if (error != null) {%>
            <p><%=error%></p>
            <%}%>
        </div>
        <h3 id="t"></h3>
        <h id="login"> <%=login.getUsername()%></h>
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
    </body>
</html>




