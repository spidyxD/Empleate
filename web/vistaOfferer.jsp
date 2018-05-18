<%-- 
    Document   : vistaOfferer
    Created on : May 9, 2018, 4:37:07 PM
    Author     : andres
--%>

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
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="idOf" scope="request" type="Offerer" />
        <jsp:useBean id="cats" scope="request" type="List<Category>" />
        <div class="perfil">
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
                    <%for(Category ct : cats){%>
                    <div class="row">
                        <div class="col s12">
                            <div class="cat"><h5><%=ct.getNameCategory()%></h5></div>
                        </div>
                    </div>
                    <%}%>
                </div>    
            </div>               
        </div>
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
    </body>
</html>


<style> 
    .barra{
        background-color: #006064;
        height: 50px;
        margin-right: 11.5px;
        margin-top: 10px;
    }
    .barra2{
        background-color: #006064;
        height: 100px;
    }
    #foto{
        height: 200px;
        width: 200px;
        /*background-color: #BA68C8;*/
    }
    
    .perfil{
        margin: 5px;
        width: 800px;
        aling-items: center;
        justify-content: center;
        margin:auto;
    }    
    .cat{
        height: 50px;
        width: 95%;
        background-color: #F44336;
        margin-left: 5px;
        align-items: center;
        justify-content: center; display: flex;
    }
    .cat h5{
        color:white;
    }
    
    p{
        color:black;
    }
    img {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 5px;
    width:95%;
    margin: 5px;
    
    #habilidades{
        margin: 10px 0px 10px 4px;        
    }
}
    
</style>