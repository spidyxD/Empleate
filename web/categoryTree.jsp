<%-- 
    Document   : categoryTree
    Created on : 04/04/2018, 10:59:36 PM
    Author     : Addiel
--%>


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
        <script type="text/javascript" src="js/ajax.js"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <script>
        $(document).ready(function(){
          $('select').formSelect();
        });
        
         </script>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <jsp:useBean id="cat" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="resumen" scope="session" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="resumenCompleto" scope="session" type="HashMap<Category, String>" />
        <%Login login = (Login)session.getAttribute("login");%>
        <div class="cuerpoConsulta container">
            <div>
                <ul>
                    <%int count=0;%>
                    
                    <%for (Category j: cat){%>
                   
                    <h id="papa" hidden ><%=j.getIdCategory()%></h>
                     <%count = j.getIdCategory();%>
                    <%String id= "porcentaje_"+count;%>
                    <%if(CategoryModel.instance().giveChilds(j.getIdCategory()).size() == 0){%>
                       
                        <li id="list"><div class="collapsible-header">
                        <i class="material-icons">fiber_manual_record</i>
                        
                        <h><a href ="#" onclick="this.href='desplegar?papa=<%=j.getIdCategory()%>&percent='+document.getElementById('<%=id%>').value" id="son"><%=j.getNameCategory()%></a><br>
                               <div class = "row">
                                <div class="input-field col s12"> 
                                <select id="<%=id%>" value="${item.value}">
                                  <option value="" disabled selected>seleccione su nivel</option>
                                  <option value="10">10%</option>
                                  <option value="25">25%</option>
                                  <option value="50">50%</option>
                                  <option value="75">75%</option>
                                  <option value="85">85%</option>
                                  <option value="90">90%</option>
                                  <option value="100">100%</option>
                                </select>
                                <label>porcentaje</label>
                              </div>
                                </div></h>   
                            </div>
                             
                        </li> 
                        
                    <%}else{%>
                        <li><div class="collapsible-header"><i class="material-icons">add</i> <a href="desplegar?papa=<%=j.getIdCategory()%>"><%=j.getNameCategory()%></a></div></li> 
                    <%}%>
                    <%}%>
                     
                </ul>
            </div><br>  
            <div class = "row">
                <a class="col s2 btn mybtn" href="iniciar">Regresar por mas</a>
                <a class="col s2 btn mybtn" href="iniciar?limpiar=1">Limpiar consulta</a>
            </div>
            <div class="resumen row">
             <%for(Category j : resumen){%>
                <p><%=j.getNameCategory()%></p>
             <%}%>
            </div>
            
            <div class="row">
                <%if(!login.getUsername().isEmpty()){%>
                <a class="col s2 btn mybtn" href="consultasEmpleateAllJobsByCategory">Consultar</a>
                <%} else{%>
                 <a class="col s2 btn mybtn" href="consultasEmpleateJobsByCategory">Consultar</a>
                <%}%>
            </div>
                <h id="log"> <%=login.getUsername()%></h>
    </div>
<%@ include file="footer.jspf" %>

</body>
</html>
