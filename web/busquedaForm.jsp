<%-- 
    Document   : busquedaForm
    Created on : Mar 31, 2018, 5:05:46 PM
    Author     : Andrés Gutiérrez
--%>

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
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <jsp:useBean id="roots" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="cat" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="resumen" scope="request" type="List<Category>" class="java.util.ArrayList"/>
           <%for (Category j : roots) {//for root%>
            <div>
                <ol>
                <li><a href="desplegar?papa=<%=j.getIdCategory()%>"><%=j.getNameCategory()%></a><li>
                <%for (Category h : cat) {//for hijos%>
                    <%if(cat.size()>0 && h.getCategory().getIdCategory()==j.getIdCategory()){//if%>
                        <ol>
                            <li><a href="desplegar?papa=<%=h.getIdCategory()%>">&nbsp;&nbsp;<%=h.getNameCategory()%></a></li>
                        </ol>
                    <%}%>
                    <%}%>
                </ol>
            </div>
           <%}%>
           <div class="resumen">
            <%for(Category j : resumen){%>
            <p><%=j.getNameCategory()%></p>
            <%}%>
           </div>
<%@ include file="footer.jspf" %>
</body>
</html>

<style>
    .resumen{
        text-align: right;
        background-color: yellow;
        height: 200px;
        color: white;
    }
</style>
