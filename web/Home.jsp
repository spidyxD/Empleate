
<%@page import="java.util.ArrayList"%>
<%@page import="Empleate.domain.Job"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Empleate</title>
        <%@ include file="includesHead.jspf" %>
    </head>
    <body>
        <%@ include file="headerHome.jspf" %>
        <div class="cuerpo">
            <section class="section">
                <jsp:useBean id="top" scope="request" type="List<Job>" class="java.util.ArrayList"/>
                <div class="row">
                    <div class="carousel carousel-slider center">
                        <div class="carousel-fixed-item center">
                        </div>
                        <%String colores[]={"black","red","amber","green","blue"};//los colores para el carrusel%>
                        <%int cont =0;%>
                        <%for (Job j : top) {%>
                        <div class="carousel-item <%=colores[cont++]%> white-text" href="#one!">
                            <h4><%=j.getNameJob()%></h4>
                            <h3><%=j.getDescriptionJob()%></h3>
                            <h2><%=j.getSalary()%>&nbsp colones</h2>
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

