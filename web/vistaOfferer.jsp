<%-- 
    Document   : vistaOfferer
    Created on : May 9, 2018, 4:37:07 PM
    Author     : andres
--%>

<%@page import="Empleate.domain.Login"%>
<%@page import="Empleate.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="Empleate.domain.Offerer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <%@include file="includesHead.jspf"%>
        <%@include file="header.jspf"%>
        <%@include file="updateOffererInf.jspf"%>
        <link rel="stylesheet" type="text/css" href="css/vistaOfferer.css">
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
        <script type="text/javascript" src="js/vistaOfferer.js"></script><!--codigo js para inicializar js-->

    </head>
    <body>      
        <div class="row">
            <div class="perfil col s8">
                <div class='barra'></div>
                <div class="row">
                    <div class="col s3">
                        <div id="foto">
                            <img id="image" src="images/avatares/offerer/<%=idOf.getIdOfferer()%>.png">
                        </div>
                        <p><%=idOf.getNameOfferer()%>&nbsp;<%=idOf.getLastname()%></p>
                        <p><%=idOf.getEmail()%></p>
                        <p><%=idOf.getPhone()%></p>
                        <p><%=idOf.getNationality()%></p>
                    </div>  
                    <div class="skills col s9">
                        <div class='barra2'></div>
                        <h4 id="habilidades">Habilidades</h4>
                        <%for (Category ct : cats) {%>
                        <div class="row">
                            <div class="col s12">
                                <div class="cat"><h5><%=ct.getNameCategory()%></h5></div>
                            </div>
                        </div>
                        <%}%>
                    </div>    
                </div>

            </div>
            <div class="mapa col s4">
                <div id="map"></div>
                <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBqQdsFpuwxCwJcv_mFXDemq3DQRApLdJY&callback=initMap">
                </script>
            </div>
        </div>       
        <div class="input-field" >
            <% Offerer o = (Offerer) session.getAttribute("offerer");%>
            <%if (o != null) {%>
            <a class="waves-effect waves-light btn modal-trigger" 
               href="#updateOffererInf" style="margin: 20px!important">Editar perfil </a>
            <%}%>
            <a class="waves-effect waves-light btn modal-trigger" 
               href="agregarHabilidades" style="margin: 20px!important">Agregar Habilidades </a>
        </div>  
        <%@include file="footer.jspf"%>

    </body>



</html>