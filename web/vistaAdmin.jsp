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
                            <a class='dropdown-trigger btn' href='#' data-target='dropdown2'>Listar empresas</a>
                            <!-- Dropdown Structure -->
                            <ul id='dropdown2' class='dropdown-content'>
                                <li><a href="javascript: empActivas()">Empreas aprobadas</a></li>
                                <li><a href="javascript: empNOActivas()">Empreas no aprobadas</a></li>
                            </ul>  
                            <table id="miTabla">
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
                                </tbody>
                            </table>
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
    function ocultarTabla() {
        $("#miTabla").hide();
    }
    function empActivas() {
        $("#listado").empty();
        opcion = {respuesta: 1};
        data = new FormData();
        data.append("opcion", JSON.stringify(opcion));
        $.ajax({type: "POST",
            url: "ListarEmpr",
            data: data,
            processData: false,
            contentType: false,
            dataType: "json",
            success:
                    function (obj) {
                        llenarActivos(obj);
                    },
            error: function (status) {
                window.alert("Error");
                console.log(status);
            }
        });
    }

    function empNOActivas() {
        $("#listado").empty();
        opcion = {respuesta: 0};
        data = new FormData();
        data.append("opcion", JSON.stringify(opcion));
        $.ajax({type: "POST",
            url: "ListarEmpr",
            data: data,
            processData: false,
            contentType: false,
            dataType: "json",
            success:
                    function (obj) {
                        llenarNOActivos(obj);
                    },
            error: function (status) {
                window.alert("Error");
                console.log(status);
            }
        });
    }


    function llenarActivos(obj) {
        $("#miTabla").show();
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
        $("#miTabla").show();
        var th = $("#trow");
        var thead = $("#theader");
        th.prepend("<th>Activar</th>")
        thead.append(th);
        for (var i = 0; i < obj.length; i++) {
            var tr = $("<tr />");
            tr.html("<td><p><label><input type=\"checkbox\" /><span></span></label></p></td>"+
                    "<td><a href=\"visPubCom?idCom=" + obj[i].idCompany + "\">" + obj[i].nameCompany + "</a></td>" +
                    "<td>" + obj[i].description + "</td>" +
                    "<td>" + obj[i].address + "</td>" +
                    "<td>" + obj[i].email + "</td>" +
                    "<td>" + obj[i].phone + "</td>");
            $("#listado").append(tr);
        }
    }

    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.dropdown-trigger');
        var instance = M.Dropdown.getInstance(elems);
    });
    $(".dropdown-trigger").dropdown({constrainWidth: false});

</script>

