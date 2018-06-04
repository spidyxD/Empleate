<%--
    Document   : vistaOfferer
    Created on : May 9, 2018, 4:37:07 PM
    Author     : andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Empleate.domain.Manager"%>
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
        <link rel="stylesheet" type="text/css" href="css/vistaAdmin.css">
                <script type="text/javascript">    
            function seleccionar(obj){
                var a = document.getElementById("codCat")
                var b = document.getElementById("myCat")
                
                a.setAttribute("value", obj.id);
                b.setAttribute("value", obj.text);
                b.setAttribute("style","display:block;")
          }   
        </script>
    </head>
    <body>

        <jsp:useBean id="categories" scope="request" type="ArrayList<Category>" />
        <%@include file="header.jspf"%>

        <div class="container">
            <div><h5>Agregar Categoria</h5></div>
            <div id="nube">
                <%for (Category c : categories) {%>
                <a class="botones" id="<%=c.getIdCategory()%>" onclick="seleccionar(this)"><%=c.getNameCategory()%></a>
                <%}%>
            </div>
            <div class="formulario" >
                <form action="redireccionar" method="post">
                    <div>
                        <label for="nombre">Nombre</label>
                        <input id="nombre" type="text" name="nombre" class="validate" value="">
                    </div>
                    <div>
                        <a class="btn" href="javascript:mostrar();">Seleccionar un categoria</a>
                    </div> 
                    <div id="resumen">
                        <input id="codCat" type="text" name="nombre" class="validate" value="">
                        <input id="myCat" type="text" name="nombre" class="validate" value="">
                    </div>
                    <div>
                         <input class="btn"  type="submit" value="Agregar" style="margin-top: 10px;">
                    </div>
                </form>
            </div>
        </div>
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript1.js"></script><!--codigo js para inicializar js-->
        <script type="text/javascript" src="js/vistaAdmin1.js"></script><!--codigo js para inicializar js-->
    </body>
</html>


<style>

    .container{
        width: 800px;  
    }

    .botones{
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        padding: 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 8px;
    }

    #nube{
        background-color: #1CE89A;
        border-radius: 8px;
        margin: 10px;
    }

    .formulario{
        margin:10px;
        width: 600px;
    }

</style>

<script>
    var padre;
    var nube = $("#nube");
    nube.hide(); 
    $("#myCat").hide();
    $("#codCat").hide();
    
    function mostrar(){
        nube.show();
    }
 
    
</script>