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
            function seleccionar(obj) {
                var a = document.getElementById("codCat")
                var b = document.getElementById("myCat")

                a.setAttribute("value", obj.id);
                b.setAttribute("value", obj.text);
                b.setAttribute("style", "display:block;")
            }
        </script>
    </head>
    <body>
        <jsp:useBean id="categories" scope="request" type="ArrayList<Category>" />
        <jsp:useBean id="error" scope="request" type="String" />
        <%@include file="header.jspf"%>

        <div class="container">
            <div><h5>Agregar Categoria</h5></div>
            <div id="nube">
                <%for (Category c : categories) {%>
                <a class="botones" id="<%=c.getIdCategory()%>" onclick="seleccionar(this)"><%=c.getNameCategory()%></a>
                <%}%>
            </div>
            <div class="formulario" >
                <form action="redireccionarPuestos" method="post">
                    <div>
                        <a class="btn" href="javascript:mostrar();">Seleccionar un categoria</a>
                    </div> 
                    <div id="resumen">
                        <input id="codCat" type="text" name="codCat" class="validate" value="">
                        <input id="myCat" type="text" name="myCat" class="validate" value="">
                    </div>
                    <div id="porcentajeHabi">
                        <label>Agregue un porcentaje</label>
                        <input id="porcHab" type="text" name="porcHab" class="validate" value="">
                    </div>
                    <div id="a">
                        <label>Agregue un nombre</label>
                        <input id="porcHab" type="text" name="nomb" class="validate" value="">
                    </div>
                    <div id="b">
                        <label>Agregue una descripcion</label>
                        <input id="porcHab" type="text" name="descr" class="validate" value="">
                    </div>
                    <div id="c">
                        <label>Agregue un salario</label>
                        <input id="porcHab" type="text" name="sal" class="validate" value="">
                    </div>
                    <div id="d">
                        <label>Agregue un tipo (private/public)</label>
                        <input id="porcHab" type="text" name="tip" class="validate" value="">
                    </div>
                    <div>
                        <input class="btn"  type="submit" value="Agregar" style="margin-top: 10px;">
                    </div>
                </form>
            </div>
            <%if (!error.equals("")) {%>
            <p style="color:red;"><%=error%></p>
            <%}%>
        </div>
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
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

                    function mostrar() {
                        nube.show();
                    }


</script>