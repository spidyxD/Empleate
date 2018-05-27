
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
        <% String[] images = {"images/1.jpg","images/2.jpg","images/3.jpg","images/4.jpg","images/5.jpg"};%>
        <%@ include file="headerHome.jspf" %>
        <div class="cuerpo">
            <section class="section">
                <jsp:useBean id="top" scope="request" type="List<Job>" class="java.util.ArrayList"/>
                <div class="row">
                    <div class="carousel carousel-slider center">
                        <div class="carousel-fixed-item center">
                        </div>
                        <%int cont =0;%>
                        <%for (Job j : top) {%>
                        <div class="carousel-item white-text" id="myCarousel" style="background-image:url(<%=images[top.indexOf(j)]%>);">                            
                            <div class="aches">
                                <!-- <img id="imgCarousel" src="<%=images[4]%>">-->
                                <h4><a href="visPubCom?idCom=<%=j.getCompany().getIdCompany()%>"><h4><%=j.getNameJob()%><h4></a></h4>
                                <h3><%=j.getDescriptionJob()%></a></h3>
                                <h2><%=j.getSalary()%>&nbsp colones</h2>
                            </div>                            
                        </div>
                        <%}%>
                    </div>
                </div>
            </section>
        </div>
        <div class="cuerpo2">
            <div class="parallax-container">
                <div class="parallax"><img src="images/8.jpg"></div>
            </div>
        </div>
        <%@ include file="footer.jspf" %>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
    </body>
</html>

<style>
    
.carousel-item{
   background-color: #cccccc; 
   display: flex;
   align-items: center;
} 
.aches{
    margin: 0 auto;
}

</style>

