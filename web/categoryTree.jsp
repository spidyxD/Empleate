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
                    <%for (Category j: cat){%>
                    <%if(CategoryModel.instance().giveChilds(j.getIdCategory()).size() == 0){%>
                       
                        <li id="list"><div class="collapsible-header">
                                <i class="material-icons">fiber_manual_record</i> 
                                <a href="desplegar?papa=<%=j.getIdCategory()%>" id="code"><%=j.getNameCategory()%></a>
                                <select id="porcentaje">
                                    <option value="10">10%</option>
                                    <option value="20">20%</option>
                                    <option value="30">30%</option>
                                    <option value="40">40%</option>
                                    <option value="50">50%</option>
                                    <option value="60">60%</option>
                                    <option value="70">70%</option>
                                    <option value="80">80%</option>
                                    <option value="90">90%</option>
                                    <option value="100">100%</option>
                                 </select> 
                                
                                <script>
                                    function givePercent(){
                                            porcentaje = {percent: $("#porcentaje").val()};     
                                            $.ajax({type: "POST", 
                                            url:"desplegar", 
                                            data: JSON.stringify(porcentaje), 
                                            dataType:"json",
                                            success: 
                                              function(){
                                                  console.log("success");
                                              },
                                            error: function(){
                                                   console.log("error"+porcentaje.percent);
                                              }                    
                                          });    

                                    };
                                    $('#code').click( function(e) {e.preventDefault(); givePercent();return false;} );
                                  
                                     
                                </script>
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
