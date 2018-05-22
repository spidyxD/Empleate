<%-- 
    Document   : vistaCompany
    Created on : May 15, 2018, 10:45:28 PM
    Author     : Andrés Gutiérrez
--%>

<%@page import="Empleate.domain.Job"%>
<%@page import="Empleate.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="Empleate.domain.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <%@include file="includesHead.jspf"%>
        <%@include file="updateCompanyInf.jspf"%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
        <link rel="stylesheet" type="text/css" href="css/vistaCompany.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="jobs" scope="request" type="List<Job>" />
        <div class="row">
            <div class="perfil col s8">
                <div class='barra'></div>
                <div class="row">
                    <div class="col s3">
                        <div id="foto">
                            <img id="image" src="images/avatares/company/<%=comp.getIdCompany()%>.png">
                        </div>
                        <p><%=comp.getNameCompany()%></p>
                        <p><%=comp.getEmail()%></p>
                        <p><%=comp.getPhone()%></p>
                        <p><%=comp.getDescription()%></p>
                    </div>  
                    <div class="skills col s9">
                        <div class='barra2'></div>
                        <h4 id="puestos">Puestos</h4>
                        <table>
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Descripcion</th>
                                    <th>Salario</th>
                                    <th>Empresa</th>
                                </tr>
                            </thead>
                            <%for (Job j : jobs) {%>   
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
                    </div>    
                </div>               
            </div>
            <div class="col s4">
                <div id="map"></div>
            </div>
        </div>
         <div class="input-field" >
            <a class="waves-effect waves-light btn modal-trigger" href="#updateCompanyInf" style="margin: 20px!important">Editar perfil </a>
         </div>                    
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
        <script type="text/javascript" src="js/vistaCompany.js"></script><!--codigo js para inicializar js-->
    </body>
</html>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBqQdsFpuwxCwJcv_mFXDemq3DQRApLdJY&callback=initMap"
        type="text/javascript">  
</script>