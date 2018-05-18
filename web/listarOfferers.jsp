<%-- 
    Document   : listarOfferers
    Created on : May 10, 2018, 1:59:27 PM
    Author     : andres
--%>

<%@page import="Empleate.domain.Category"%>
<%@page import="Empleate.domain.Company"%>
<%@page import="Empleate.domain.Offerer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oferentes</title>
        <%@include file="includesHeadVistas.jspf"%>
    </head>
    <body>
        <%@include file="../header.jspf"%>
        <jsp:useBean id="oferentesLS" scope="request" type="List<Offerer>" />
        <jsp:useBean id="companyLs" scope="request" type="List<Company>" />
        <h1>Lista oferentes</h1>
        <div class="container">
            <%if (!oferentesLS.isEmpty()) {%>
            <table class="striped centered">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Phone</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Offerer item : oferentesLS) {%>
                    <tr>
                        <td><a href="visPubOff?idOf=<%=item.getIdOfferer()%>"><%=item.getNameOfferer()%></a></td>
                        <td><%=item.getLastname()%></td>
                        <td><%=item.getPhone()%></td>
                        <td><%=item.getEmail()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <%}%>
        </div>   
        <h1>Lista Companies</h1>
        <div class="container">
            <%if (!companyLs.isEmpty()) {%>
            <table class="striped centered">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Phone</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Company item : companyLs) {%>
                    <tr>
                        <td><a href="visPubCom?idCom=<%=item.getIdCompany()%>"><%=item.getNameCompany()%></a></td>
                        <td><%=item.getDescription()%></td>
                        <td><%=item.getPhone()%></td>
                        <td><%=item.getEmail()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <%}%>
        </div>   
        <%@include file="../footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="../js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="../js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="../js/myScript.js"></script><!--codigo js para inicializar js-->
    </body>
</html>
