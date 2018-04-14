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
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="error" scope="request" class="java.lang.String"/>
        <jsp:useBean id="param" scope="request" type="List<String>" class="java.util.ArrayList"/>
        <%boolean lleno = param.size()>0;%>
        <div class="cuerpo container"><!-- nom,apel,nation,phone,email,recidence**login** -->
            <h4>Formulario para registro de Oferentes</h4>
            <div class="row">
                <form action="RegistOffer" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s4">
                            <input id="nombre" type="text" name="nombre" class="validate" <%if(lleno){ %>value="<%=param.get(0)%>" <%}%>>
                            <label for="nombre">Nombre</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="apellido" type="text" name="apellido" class="validate" <%if(lleno){ %>value="<%=param.get(1)%>" <%}%>>
                            <label for="apellido">Apellido</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="nacionalidad" type="text" name="nacionalidad" class="validate" <%if(lleno){ %>value="<%=param.get(2)%>" <%}%>>
                            <label for="nacionalidad">Nacionalidad</label>
                        </div>
                    </div>
                    <div class="row">

                        <div class="input-field col s4">
                            <input id="telefono" type="tel" name="telefono" class="validate" <%if(lleno){ %>value="<%=param.get(3)%>" <%}%>>
                            <label for="telefono">Telefono</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="residencia" type="text" name="residencia" class="validate" <%if(lleno){ %>value="<%=param.get(4)%>" <%}%>>
                            <label for="residencia">Residencia</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="email" type="email" name="email" class="validate" <%if(lleno){ %>value="<%=param.get(5)%>" <%}%>>
                            <label for="email">Email</label>
                        </div>
                    </div>
                    <div class="row">

                        <div class="input-field col s6">
                            <input id="username" type="text" name="username" class="validate" <%if(lleno){ %>value="<%=param.get(6)%>" <%}%>>
                            <label for="username">Username</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="password" type="password" name="password" class="validate">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <div class="input-field col s12">
                        <input class="btn"  type="submit" value="Ingresar" >
                    </div>
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
    
    .error p{
        color:red;
    }

</style>

