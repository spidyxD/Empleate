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
        <script type="text/javascript" src="js/myScript.js"></script>
        <script type="text/javascript" src="js/ajax.js"></script> 
        <link rel="stylesheet" type="text/css" href="css/lightbox.css"/>
        <link rel="stylesheet" type="text/css" href="css/index.css"/>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/lightbox.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

        <script>
            $(document).ready(function () {
                $('select').formSelect();
            });
        </script>
        <style>
            h1,h2,h3{
                font-size: 12px!important;
            }
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */

            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }

            .input-field label{
                color:black;
            }
            .gm-style{
                position: relative;
                z-index: 0;
                left: 0px;
                top: 0px;
                height: 100%!important;
                width: 100%!important;
                padding: 0px;
                border-width: 0px;
                margin: 0px;
                display: block;
            }
            .controls {
                margin-top: 10px;
                border: 1px solid transparent;
                border-radius: 2px 0 0 2px;
                box-sizing: border-box;
                -moz-box-sizing: border-box;
                height: 32px;
                outline: none;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
            }

            #pac-input {
                background-color: #ffff!important;
                font-family: Roboto!important;
                font-size: 15px!important;
                font-weight: 200!important;
                margin-left: 12px!important;
                padding: 0 11px 0 13px!important;
                text-overflow: ellipsis!important;
                height: 30px!important;
                width: 150px!important;
            }

            #pac-input:focus {
                border-color: #4d90fe!important;
            }

            .pac-container {
                font-family: Roboto!important;
            }

            #type-selector {
                color: #fff!important;
                background-color: #4d90fe!important;
                padding: 5px 11px 0px 11px!important;
            }

            #type-selector label {
                font-family: Roboto!important;
                font-size: 13px!important;
                font-weight: 300!important;
            }
            #target {
                width: 345px!important;
            }
            .select-wrapper{
                width: 50%!important;
            }

        </style>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <jsp:useBean id="cat" scope="request" type="List<Category>" class="java.util.ArrayList"/>
        <jsp:useBean id="resumen" scope="session" type="List<Category>" class="java.util.ArrayList"/>
        <%Login login = (Login) session.getAttribute("login");%>
        <%Category auxR = new Category();%>
        <%Category aux = new Category();%>
        <%Category aux2 = new Category();%>
        <h4>Seleccione una categoria de empleo</h4>
        <script>
            var review = [];
            var count = 0;
            var ids = [];
            var c = 0;
            var percents = [];
            var localeHX = 0;
            var localeHY = 0;
            var rs = 0;
        </script>       
        <div class="row">            
            <div class="col s6">
                <div class="cuerpoConsulta container" id="categoryList">
                    <ul class="collapsible" data-collapsible = "accordion" id="categories">
                        <%for (int i = 0; i < cat.size(); i++) {%>                                 
                        <%if (cat.get(i).getIsRoot() == 1) {%>                
                        <%auxR = cat.get(i);%>
                        <li>
                            <div class="collapsible-header">        
                                <i class="material-icons">add</i><%=auxR.getNameCategory()%></div>
                                <%}%>             
                                <%for (int j = cat.size() - 1; j >= 0; j--) {%>
                                <%if (cat.get(i).getIsRoot() == 0 && cat.get(i).getCategory().getIdCategory() == cat.get(j).getIdCategory()) {%>
                                <%if (cat.get(i).getIsDad() == 1) {%>
                                <%aux = cat.get(i);%>
                            <div class="collapsible-body">
                                <div class="row">
                                    <div class="col s12 m12">
                                        <ul class="collapsible" data-collapsible="popup">
                                            <li>
                                                <div class="collapsible-header">
                                                    <a><i class="material-icons">add</i><%=aux.getNameCategory()%></a><h1 data-value="<%=aux.getIdCategory()%>" hidden></h1>
                                                    <%aux2 = cat.get(i);%>
                                                </div>
                                                <%if (!CategoryModel.instance().giveChilds(aux2.getIdCategory()).isEmpty()) {%>
                                                <div class="collapsible-body">                                   
                                                    <%for (Category c : CategoryModel.instance().giveChilds(aux2.getIdCategory())) {%>
                                                    <%String idF = "porcentajeF_" + c.getIdCategory();%>  
                                                    <%String idFPS = "catFS_" + c.getIdCategory();%>
                                                    <a onclick="buildReview(review, ids,<%=idFPS%>);
                                                            buildPercents(percents,<%=idF%>)" id="<%=idFPS%>" data-value="<%=c.getNameCategory()%>" data-codes="<%=c.getIdCategory()%>"><i class="material-icons">fiber_manual_record</i><%=c.getNameCategory()%></a>                                                                  
                                                    <select id="<%=idF%>" value="${item.value}">
                                                        <option value="" disabled selected>seleccione su nivel</option>
                                                        <option value="10">10%</option>
                                                        <option value="25">25%</option>
                                                        <option value="50">50%</option>
                                                        <option value="75">75%</option>
                                                        <option value="85">85%</option>
                                                        <option value="90">90%</option>
                                                        <option value="100">100%</option>
                                                    </select>

                                                    <%}%>
                                                </div>
                                                <%}%> 
                                            </li>
                                        </ul>                  
                                    </div>
                                </div>
                            </div>
                            <% } else {%>               
                            <%List<Category> help = CategoryModel.instance().giveChilds(auxR.getIdCategory());%>
                            <%for (Category c : help) {%>                            
                            <%if (c.getIsDad() == 0) {%>
                            <%String idS = "porcentaje_" + c.getIdCategory();%> 
                            <%String idSP = "catS_" + c.getIdCategory();%>
                            <div class="collapsible-body">
                                <a onclick="buildReview(review, ids,<%=idSP%>);
                                        buildPercents(percents,<%=idS%>)" id="<%=idSP%>" data-value="<%=c.getNameCategory()%>" data-codes="<%=c.getIdCategory()%>"><i class="material-icons">fiber_manual_record</i><%=c.getNameCategory()%></a>                            
                                <select id="<%=idS%>" value="${item.value}">
                                    <option value="" disabled selected>seleccione su nivel</option>
                                    <option value="10">10%</option>
                                    <option value="25">25%</option>
                                    <option value="50">50%</option>
                                    <option value="75">75%</option>
                                    <option value="85">85%</option>
                                    <option value="90">90%</option>
                                    <option value="100">100%</option>
                                </select>

                            </div>
                            <%}%>   

                            <%}%> 
                        </li> 
                        <%}%>
                        <%}%>
                        <%}%>

                        <%}%>

                    </ul>
                </div>
                <a class="col s2 btn mybtn" onclick="clean(review, percents)"> Borrar </a>
                <h1 id="isLogin" data-value="<%=login.getUsername()%>"></h1>
                <script>var isLogin = $("#isLogin").data("value")</script>
                <a class="col s2 btn mybtn" onclick="addElementToSearch(localeHX, localeHY)">Buscar</a>

            </div>              

            <script>
                $(document).ready(function () {
                    $('.collapsible').collapsible();
                });

            </script>
            <div class="col s6">
                <div class="container map">
                    <input id="pac-input" class="controls" type="text" placeholder="Search Box">

                    <div id="peta" style="height:300px; width:500px; margin-bottom:10px; border:solid #999 2px; margin: 20px;"></div>
                    <a class="btn-floating btn-large waves-effect waves-light red" onclick="alerta()"><i class="material-icons">add</i></a>  
                    <script>
                        function load_peta()
                        {
                            var map = new google.maps.Map(document.getElementById('peta'), {
                                zoom: 12,
                                center: {lat: 9.8207388, lng: -84.2153649},
                                mapTypeControl: true,
                                mapTypeControlOptions: {
                                    style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
                                    position: google.maps.ControlPosition.TOP_CENTER
                                },
                                zoomControl: true,
                                zoomControlOptions: {
                                    position: google.maps.ControlPosition.LEFT_CENTER
                                },
                                scaleControl: true,
                                streetViewControl: true,
                                streetViewControlOptions: {
                                    position: google.maps.ControlPosition.LEFT_TOP
                                },
                                fullscreenControl: true
                            });


                            //guarda la ubicacion seleccionada 
                            map.addListener('click', function (e) {
                                placeMarkerAndPanTo(e.latLng, map);
                            });

                            //PARA LA GEOUBICACION ACTUAL DEL USUARIO
                            var infoWindow = new google.maps.InfoWindow({map: map});

                            // Try HTML5 geolocation.
                            if (navigator.geolocation) {
                                navigator.geolocation.getCurrentPosition(function (position) {
                                    var pos = {
                                        lat: position.coords.latitude,
                                        lng: position.coords.longitude
                                    };

                                    infoWindow.setPosition(pos);
                                    infoWindow.setContent('you are here!');
                                    map.setCenter(pos);
                                }, function () {
                                    handleLocationError(true, infoWindow, map.getCenter());
                                });
                            } else {
                                // Browser doesn't support Geolocation
                                handleLocationError(false, infoWindow, map.getCenter());
                            }


                            //caja box para busqueda especifica   NOTA HAY QUE ACTIVAR LA API EL SERVICIO PLACES PARA QUE FUNCIONE LA BUSQUEDA
                            // Create the search box and link it to the UI element.
                            var input = document.getElementById('pac-input');
                            var searchBox = new google.maps.places.SearchBox(input);
                            map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

                            // Bias the SearchBox results towards current map's viewport.
                            map.addListener('bounds_changed', function () {
                                searchBox.setBounds(map.getBounds());
                            });

                            var markers = [];
                            // Listen for the event fired when the user selects a prediction and retrieve
                            // more details for that place.
                            searchBox.addListener('places_changed', function () {
                                var places = searchBox.getPlaces();

                                if (places.length == 0) {
                                    return;
                                }

                                // Clear out the old markers.
                                markers.forEach(function (marker) {
                                    marker.setMap(null);
                                });
                                markers = [];

                                // For each place, get the icon, name and location.
                                var bounds = new google.maps.LatLngBounds();
                                places.forEach(function (place) {
                                    if (!place.geometry) {
                                        console.log("Returned place contains no geometry");
                                        return;
                                    }
                                    var icon = {
                                        url: place.icon,
                                        size: new google.maps.Size(71, 71),
                                        origin: new google.maps.Point(0, 0),
                                        anchor: new google.maps.Point(17, 34),
                                        scaledSize: new google.maps.Size(25, 25)
                                    };

                                    // Create a marker for each place.
                                    markers.push(new google.maps.Marker({
                                        map: map,
                                        icon: icon,
                                        title: place.name,
                                        position: place.geometry.location
                                    }));

                                    if (place.geometry.viewport) {
                                        // Only geocodes have viewport.
                                        bounds.union(place.geometry.viewport);
                                    } else {
                                        bounds.extend(place.geometry.location);
                                    }
                                });
                                map.fitBounds(bounds);
                            });


                            //para mostrar informacion del sitio seleccionado

                            var contentString = " ";

                            var infowindow = new google.maps.InfoWindow({
                                content: contentString
                            });

                            var marker = new google.maps.Marker({
                                position: map.getCenter(),
                                map: map,
                                title: 'Company Information'
                            });
                            marker.addListener('click', function (e) {
                                infowindow.open(map, marker);
                                placeMarkerAndPanTo(e.latLng, map);
                            });

                        }
                        function handleLocationError(browserHasGeolocation, infoWindow, pos) {
                            infoWindow.setPosition(pos);
                            infoWindow.setContent(browserHasGeolocation ?
                                    'Error: The Geolocation service failed.' :
                                    'Error: Your browser doesn\'t support geolocation.');
                        }


                        google.maps.event.addDomListener(window, 'load', load_peta);


                        //Muestra las coordenadas en consola del punto seleccionado en el mapa
                        var marker;
                        function placeMarkerAndPanTo(latLng, map) {
                            if (marker) {
                                marker.setPosition(latLng);
                                console.log(marker.getPosition().lat() + " " + marker.getPosition().lng());

                            } else {
                                marker = new google.maps.Marker({
                                    position: latLng,
                                    map: map});
                                console.log(marker.getPosition().lat() + " " + marker.getPosition().lng());
                            }
                        }

                    </script>
                    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAXHkW8XZy3R2tQa_326VbuFp29wDJ93Qw&libraries=places&callback=load_peta"></script>
                </div>  

            </div> 

        </div>
        <div class = "row">       
            <div class="input-field col s6">
                <input name="localeX" id="localeX" type="value" class="validate" readonly hidden>                          
            </div>
            <div class="input-field col s6">    
                <input name="localeY" id="localeY" type="value" class="validate" readonly hidden>
            </div>
        </div>
        <div class="row">
            <div class="col s2">
                <h1>Catgorias seleccionadas</h1>  
                <div class="resumen row" id="history">

                    <ul id="resumen">

                    </ul>

                </div>    
            </div>
            <div class="col s10">     
                <div class="container">
                    <h1>Resultados</h1>    
                    <table>
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Salario</th>
                                <th>Empresa</th>
                                <th>Condicion</th>
                            </tr>
                        </thead>
                        <tbody id="results">

                        </tbody><br>
                    </table>
                    <!-- -->
                    <h3 id="rss">  </h3><br><br>
                </div>
            </div>   
        </div>   

    <h id="log"> <%=login.getUsername()%></h>

    <%@ include file="footer.jspf" %>

</body>

</html>
