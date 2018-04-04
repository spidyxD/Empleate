<%-- 
    Document   : Error
    Created on : 22/03/2018, 09:04:18 AM
    Author     : Addiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <link href="css/style.css" rel="stylesheet" type="text/css"/>
       <%@ include file="includesHead.jspf" %> 
    </head>
    <body>
         <%@include file="header.jspf"%>
    
  <div id="body" style="margin: 0 auto; width:100%; height: 100%">    
    <jsp:useBean id="error" scope="request" type="java.lang.String" class="java.lang.String" />
     <div class="row">
    <div class="area" style="width:100%">   
        <div style="color:black; font-size: 40px;"> <%=error%></div>
        <div style="color:red; font-size: 40px;"> Nombre de usuario o contraseña incorrecta o no existe intente  <a href="Home"> ingresar</a> de nuevo</div><br>
        <img src="images/notFound.jpg" alt="ERROR" width=100% height=100%>  
    
    </div>
     </div>     
  </div>
  <%@ include file="footer.jspf" %>      
</body>
    </body>
</html>
