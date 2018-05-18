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
        <jsp:useBean id="jobsByCategory" scope="request" type="List<Job>" class="java.util.ArrayList"/>
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
            <%for (Job j : jobsByCategory) {%>   
            <tbody>
                <tr>
                    <td><%=j.getNameJob()%></td>
                    <td><%=j.getDescriptionJob()%></td>
                    <td><%=j.getSalary()%>&nbsp colones</td>
                    <td><%=j.getCompany().getNameCompany()%></td>
                </tr>
             <%}%>
            </tbody>
        </table>
        <!-- -->
        <h>Resultados de busqueda: <%=jobsByCategory.size()%></h><br><br>
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