<%-- 
    Document   : categoryTree
    Created on : 04/04/2018, 10:59:36 PM
    Author     : Addiel
--%>


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
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <jsp:useBean id="cat" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="resumen" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        
        <%List<Category> ls =CategoryModel.instance().giveRootParents();%>
        <%List<Category> chC =CategoryModel.instance().findAllCategories();%>        
                <div >
                     
                        <ul class="collapsible expandable">
                            <%for (Category j: ls){%>
                            <li><div class="collapsible-header"><i class="material-icons">whatshot</i> <a href="desplegar?papa=<%=j.getIdCategory()%>"><%=j.getNameCategory()%></a></div> 
                                 <%}%>
                                <%for (Category r: resumen) { %>   
                                <%for (Category h: cat) {//hijos%>
                                 
                                <%if(h.getCategory().getIdCategory()==r.getIdCategory()){%>
                                <ul>
                                    <li><div class="collapsible-header"><i class="material-icons">whatshot</i>><span><a href="desplegar?papa=<%=h.getIdCategory()%>"><%=h.getNameCategory()%></a></span></div></li><br>
                                    
                                </ul>
                                    <%cat = new ArrayList();%>
                                    <%}%>
                                 <%}%>
                                 <%}%>
                               
                                </li><br>    
                        </ul><br>   
                   
                </div><br>   
            
           
           <div class="resumen">
            <%for(Category j : resumen){%>
            <p><%=j.getNameCategory()%></p>
            <%}%>
           </div>
    </div>
</div>
<%@ include file="footer.jspf" %>
</body>
</html>

<style>
    .resumen{
        text-align: right;
        background-color:  wheat;
        height: 200px;
        color: black;
       
    }
</style>
