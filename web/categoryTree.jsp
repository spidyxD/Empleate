<%-- 
    Document   : categoryTree
    Created on : 04/04/2018, 10:59:36 PM
    Author     : Addiel
--%>


<%@page import="com.google.gson.Gson"%>
<%@page import="Empleate.domain.categorySimple"%>
<%@page import="java.util.HashMap"%>
<%@page import="Empleate.domain.Login"%>
<%@page import="Empleate.controller.consultasEmpleate"%>
<%@page import="java.util.List"%>
<%@page import="Empleate.domain.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Empleate.logica.CategoryModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda</title>
        <%@ include file="includesHead.jspf" %>
        <script type="text/javascript" src="js/myScript.js"></script>
        <script type="text/javascript" src="js/ajax.js"></script> 
        <link rel="stylesheet" type="text/css" href="css/lightbox.css"/>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <link rel="stylesheet" type="text/css" href="css/categoryTree.css">
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/lightbox.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <jsp:useBean id="catSim" scope="request" type="List<categorySimple>" class="java.util.ArrayList"/>
        <jsp:useBean id="myJson" scope="request" type="String"/>
        <!-- EMPEZAR LA LOGICA -->
        <h1>Hello</h1>
        <p id="myJ"><%=myJson%></p>

        <div id="magia">
            <h3>Categorias</h3>
            <ul id="listaCat" class="collection" >

            </ul>
        </div>
        <!-- FINAL DE LA PAGINA-->
        <%@ include file="footer.jspf" %>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXHkW8XZy3R2tQa_326VbuFp29wDJ93Qw&libraries=places&callback=load_peta"
        type="text/javascript"></script>
        <script type="text/javascript" src="js/categoryTree.js"></script> 
        <script>
            function hijos(idPadre, ls) {
                for (var i = 0; i < ls.length; i++) {
                    if (ls[i].padre === Number(idPadre)) {
                        console.log((ls[i].nombre));
                    }
                }
            }
            $(document).ready(function () {
                var x = $('#myJ').text();
                var list = [];
                list = JSON.parse(x);
                var ul = document.getElementById("listaCat")
                for (var i = 0; i < list.length; i++) {
                    if (list[i].padre === 0) {
                        var li = document.createElement("li");
                        li.setAttribute("id", list[i].id);
                        li.setAttribute("class", "collection-item");
                        li.appendChild(document.createTextNode(list[i].nombre));
                        ul.appendChild(li);
                        $("#" + list[i].id).click(function (quien) {
                            //alert(quien.target.id + " fue clicked");
                            hijos(quien.target.id,list);
                        });
                    }
                }

            });

        </script>
    </body>
</html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
    #myJ{
        display:none;
    }
</style>
