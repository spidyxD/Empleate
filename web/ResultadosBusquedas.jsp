<%-- 
    Document   : ResultadosBusquedas
    Created on : Apr 1, 2018, 12:44:20 AM
    Author     : Andrés Gutiérrez
--%>

<%@page import="Empleate.domain.Job"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <%@include file="includesHead.jspf"%>
    </head>
    <body>
        <%@include file="header.jspf"%>
        <h1>Resultados</h1>
       
        <!-- -->
        <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Salario</th>
                    <th>Empresa</th>
                </tr>
            </thead>
            <tbody id="results">
                
            </tbody>
        </table>
        <!-- -->
        <h>Resultados de busqueda: </h><br><br>
        <a class="col s2 btn mybtn" href="iniciar">Regresar </a><br><br>
        </div>
        <%@include file="footer.jspf"%>
    </body>
</html>

<style>
    thead{
        background-color: #c4c4c4;
    }
</style>