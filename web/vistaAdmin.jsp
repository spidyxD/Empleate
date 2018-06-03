<%-- 
    Document   : vistaOfferer
    Created on : May 9, 2018, 4:37:07 PM
    Author     : andres
--%>

<%@page import="Empleate.domain.Manager"%>
<%@page import="Empleate.domain.Login"%>
<%@page import="Empleate.domain.Category"%>
<%@page import="java.util.List"%>
<%@page import="Empleate.domain.Offerer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <%@include file="includesHead.jspf"%>
        <link rel="stylesheet" type="text/css" href="css/vistaAdmin.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="man" scope="request" type="Manager" />
        <jsp:useBean id="login" scope="session" type="Login" />
        <div class="container">
            <div class="row">
                <div class="perfil col s12">
                    <div class='barra'></div>
                    <div class="row">
                        <div class="foto col s3">
                            <div id="foto">
                                <img id="image" src="images/avatares/Manager/<%=man.getIdManager()%>.png">
                            </div>
                            <p>Administrador</p>
                            <p><%=man.getEmail()%></p>
                        </div>  
                        <div class="opciones col s9"> <!-- Dropdown Trigger -->
                            <a class='dropdown-trigger btn' href='#' data-target='dropdown1' >Reportes</a>
                            <!-- Dropdown Structure -->
                            <ul id='dropdown1' class='dropdown-content'>
                                <li><a href="#!">Puestos solicitados por mes</a></li>
                            </ul>  
                            <a class='dropdown-trigger btn' href='#' data-target='dropdown2' id="lc">Listar empresas</a>
                            
                            <a class='dropdown-trigger btn' href='#' data-target='dropdown3' id="lo">Listar Oferente</a>
                            <!-- Dropdown Structure -->
                            <ul id='dropdown2' class='dropdown-content'>
                                <li><a href="javascript: empActivas()">Empreas aprobadas</a></li>
                                <li><a href="javascript: empNOActivas()">Empreas no aprobadas</a></li>
                            </ul>  
                            <div id="tabla1">
                            <table id="miTabla" style="display:none">
                                <thead id="theader">
                                    <tr id="trow">
                                        <th>Nombre</th>
                                        <th>Descricion</th>
                                        <th>Ubicacion</th>
                                        <th>email</th>
                                        <th>Telefono</th>
                                    </tr>
                                </thead>
                                <tbody id="listado"> 
                                </tbody><br>
                               
                            </table>
                                 <a class='waves-effect waves-light btn modal-trigger' href='#'onclick="activeComp()" id="actComp" style="display: none">Activar cuentas</a>
                            </div>    
                            <ul id='dropdown3' class='dropdown-content'>
                                <li><a href="javascript: offActivas()">Oferentes aprobados</a></li>
                                <li><a href="javascript: offNOActivas()">Oferentes no aprobados</a></li>
                            </ul> 
                              <div id="tabla2">  
                              <table id="miTabla2" style="display:none">
                                <thead id="theader2">
                                    <tr id="trow2">
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>email</th>
                                        <th>Nacionalidad</th>
                                        <th>Telefono</th>
                                    </tr>
                                </thead>
                                <tbody id="listado2"> 
                                </tbody><br>
                                
                            </table>
                                  <a class='waves-effect waves-light btn modal-trigger' href='#' onclick="activeOff()" id="actOff" style="display: none">Activar cuentas</a>
                              </div>
                        </div>   
                    </div>

                </div>
            </div>
        </div>
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
        <script type="text/javascript" src="js/vistaAdmin.js"></script><!--codigo js para inicializar js-->
    </body>
</html>
<script>
    window.onload = ocultarTabla;
    var lo = $("#lo").click(function(){
        $("#actOff").css("display","inline");
         $("#actComp").css("display","none");
    });
    var lo = $("#lc").click(function(){
        $("#actOff").css("display","none");
        $("#actComp").css("display","inline");
    });
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.dropdown-trigger');
        var instance = M.Dropdown.getInstance(elems);
    });
    $(".dropdown-trigger").dropdown({constrainWidth: false});
    function llenarActivosOFF(obj) {
        $("#miTabla").hide();
        $("#miTabla2").show();
        $("#act2").remove();
        for (var i = 0; i < obj.length; i++) {
            var tr = $("<tr />");
            tr.html("<td><a href=\"visPubOff?idOf=" + obj[i].idOfferer + "\">" + obj[i].nameOfferer + "</a></td>" +
                    "<td>" + obj[i].lastname + "</td>" +
                    "<td>" + obj[i].email  + "</td>" +
                    "<td>" + obj[i].nationality  + "</td>" +
                    "<td>" + obj[i].phone + "</td>");
            $("#listado2").append(tr);
        }
    }
    
    
    function llenarNOActivosOFF(obj) {
        $("#miTabla").hide();
        $("#miTabla2").show();
        $("#act2").remove();
        var th = $("#trow2");
        var thead = $("#theader2");
        th.prepend("<th id='act2'>Activar</th>");
        thead.append(th);
        for (var i = 0; i < obj.length; i++) {
            var tr = $("<tr />");
            tr.html("<td><p><label><input type=\"checkbox\" id='checkO'/><span></span></label></p></td>"+
                    "<td><a href=\"visPubOff?idOf=" + obj[i].idOfferer + "\">" + obj[i].nameOfferer + "</a></td>" +
                    "<td>" + obj[i].lastname  + "</td>" +
                    "<td id='em'>" + obj[i].email  + "</td>" +
                    "<td>" + obj[i].nationality + "</td>" +
                    "<td>" + obj[i].phone + "</td>");
            $("#listado2").append(tr);
        }
    }
    
    function llenarActivos(obj) {
        $("#miTabla2").hide();
        $("#miTabla").show();
        $("#act").remove();
         $("#act2").remove();
        for (var i = 0; i < obj.length; i++) {
            var tr = $("<tr />");
            tr.html("<td><a href=\"visPubCom?idCom=" + obj[i].idCompany + "\">" + obj[i].nameCompany + "</a></td>" +
                    "<td>" + obj[i].description + "</td>" +
                    "<td>" + obj[i].address + "</td>" +
                    "<td>" + obj[i].email + "</td>" +
                    "<td>" + obj[i].phone + "</td>");
            $("#listado").append(tr);
        }
    }
    
    
    function llenarNOActivos(obj) {
        $("#miTabla2").hide();
        $("#miTabla").show();
        $("#act").remove();
        $("#act2").remove();
        var th = $("#trow");
        var thead = $("#theader");
        th.prepend("<th id='act'>Activar</th>");
        thead.append(th);
        for (var i = 0; i < obj.length; i++) {
            var tr = $("<tr />");
            tr.html("<td><p><label><input type=\"checkbox\" id='checkC'/><span></span></label></p></td>"+
                    "<td><a href=\"visPubCom?idCom=" + obj[i].idCompany + "\">" + obj[i].nameCompany + "</a></td>" +
                    "<td>" + obj[i].description + "</td>" +
                    "<td>" + obj[i].address + "</td>" +
                    "<td>" + obj[i].email + "</td>" +
                    "<td>" + obj[i].phone + "</td>");
            $("#listado").append(tr);
        }
    }
    var select = new Array();
  
</script>

