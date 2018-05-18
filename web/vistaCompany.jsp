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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
    </head>
    <body>
        <%@include file="header.jspf"%>
        <jsp:useBean id="comp" scope="request" type="Company" />
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
        <%@include file="footer.jspf"%>
        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/jquery.js"></script> <!--necesario para los carruseles-->
        <script type="text/javascript" src="js/materialize.min.js"></script><!--js de materialize-->
        <script type="text/javascript" src="js/myScript.js"></script><!--codigo js para inicializar js-->
    </body>
</html>


<style> 
    .barra{
        background-color: #99433D;
        height: 50px;
        margin-right: 11.5px;
        margin-top: 10px;
    }
    .barra2{
        background-color: #99433D;
        height: 100px;
    }
    #foto{
        height: 200px;
        width: 200px;
        /*background-color: #BA68C8;*/
    }

    .perfil{
        margin: 5px;
        width: 800px;
        aling-items: center;
        justify-content: center;
        margin:auto;
    }    
    .cat{
        height: 50px;
        width: 95%;
        background-color: #F44336;
        margin-left: 5px;
        align-items: center;
        justify-content: center; display: flex;
    }
    .cat h5{
        color:white;
    }

    p{
        color:black;
    }
    img {
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 5px;
        width:95%;
        margin: 5px;

        #puestos{
            margin: 10px 0px 10px 4px;        
        }
    }
     #map{
       height: 500px; /*debe ser un valor fijo */
       border: 2px solid black;
       border-radius: 5px;
       margin-top: 10px;
    }

</style>

<script>    
      function initMap() {
          var myLatLng = {lat: 10.0345799, lng: -84.1374039};
          var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: myLatLng, 
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
        
        var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Hello World!'
        });

        map.addListener('click', function(e) {
          //placeMarkerAndPanTo(e.latLng, map);
        });
      }
      
      function placeMarkerAndPanTo(latLng, map) {
        if ( marker ) {
          marker.setPosition(latLng);
          console.log(marker.getPosition().lat()+" "+marker.getPosition().lng());
        } else {
          marker = new google.maps.Marker({
          position: latLng,
          map: map});
          console.log(marker.getPosition().lat()+" "+marker.getPosition().lng());
       }
      }
      
      function iniciarTodo(){
          company = {idCompany:1
		};
            $.ajax({type: "POST", 
                  url:"localizar", 
                  data: JSON.stringify(company), 
                  dataType:"json",
                  success: 
                    function(obj){
                        //initMap(obj.getLocation_X,obj.getLocation_X);
                        window.alert("Funciona");
                    },
                  error: function(status){
                         window.alert("Error");
                         console.log(status);
                    }                    
                });          
      }
      
      window.onload = iniciarTodo;
    </script>
    
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBqQdsFpuwxCwJcv_mFXDemq3DQRApLdJY&callback=initMap"
            type="text/javascript">
         
    </script>