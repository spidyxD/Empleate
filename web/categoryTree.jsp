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
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <jsp:useBean id="cat" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="resumen" scope="session" type="List<Category>" class="java.util.ArrayList"/>        
        <jsp:useBean id="por" scope="request" type="String" class="java.lang.String"/>
        <jsp:useBean id="resumenCompleto" scope="session" type="HashMap<Category, String>" />
        <%Login login = (Login)session.getAttribute("login");%>
        <div class="cuerpoConsulta container">
            <div>
                <ul>
                    <%for (Category j: cat){%>
                    <%if(CategoryModel.instance().giveChilds(j.getIdCategory()).size() == 0){%>
                        <li><div class="collapsible-header">
                                <i class="material-icons">fiber_manual_record</i> 
                                <a href="desplegar?papa=<%=j.getIdCategory()%>" id="code"><%=j.getNameCategory()%></a>
                                <input name="porcentaje" id="porcentaje" type="text" class="validate" style="color:black;width: 90px;margin-left: 100px;" placeholder="porcentaje"> 
                                <script>
                                    function percent(){
                                        if(document.getElementById("porcentaje").value = ""){
                                            console.log('Porcentaje no almacenado');
                                        }
                                        else{
                                             p = {percent:document.getElementById("porcentaje").value}    
                                             console.log(document.getElementById("porcentaje").value);
                                              ajax({"method": "POST", 
                                                "url":"desplegar", 
                                                "data": p, 
                                                "success": 
                                                  function(obj){
                                                      console.log("success");
                                                  },
                                                "error": function(status){
                                                       window.alert("Error");
                                                  }                    
                                              });  
                                        }
                                    }   
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
                <h> <%=login.getUsername()%></h>
        </div>
</div>
<%@ include file="footer.jspf" %>

</body>
</html>
