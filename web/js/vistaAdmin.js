



function initMap(x, y) {
    var myLatLng = {lat: 10.0345799, lng: -84.1374039};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
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

    map.addListener('click', function (e) {
        //placeMarkerAndPanTo(e.latLng, map);
    });
}

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

function iniciarTodo() {
    company = {idCompany: 1
    };
    $.ajax({type: "POST",
        url: "localizar",
        data: JSON.stringify(company),
        dataType: "json",
        success:
                function (obj) {
                    initMap(obj.X, obj.Y);
                    //window.alert(obj.X);
                },
        error: function (status) {
            window.alert("Error");
            console.log(status);
        }
    });
}

//window.onload = iniciarTodo;
function ocultarTabla() {
        $("#miTabla").hide();
        $("#miTabla2").hide();
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


    
    function showTableComp(){
        $("miTabla").show();     
    }
   
    
    //para los activar cuentas de oferente
    function offActivas() {
        $("#listado2").empty();
        opcion = {respuesta: 1};
        data = new FormData();
        data.append("opcion", JSON.stringify(opcion));
        $.ajax({type: "POST",
            url: "listarOferentes",
            data: data,
            processData: false,
            contentType: false,
            dataType: "json",
            success:
                    function (obj) {
                        llenarActivosOFF(obj);
                    },
            error: function (status) {
                window.alert("Error");
                console.log(status);
            }
        });
    }

    function offNOActivas() {
        $("#listado2").empty();
        opcion = {respuesta: 0};
        data = new FormData();
        data.append("opcion", JSON.stringify(opcion));
        $.ajax({type: "POST",
            url: "listarOferentes",
            data: data,
            processData: false,
            contentType: false,
            dataType: "json",
            success:
                    function (obj) {
                        llenarNOActivosOFF(obj);
                    },
            error: function (status) {
                window.alert("Error");
                console.log(status);
            }
        });
    }
    
    //PARA ACTUALIZAR EL ESTADO DE ACTIVACION DE LAS CUENTAS
    function activeComp(){
         var result = [];
            var i = 0;
            // para cada checkbox "chequeado"
            $("input[type=checkbox]:checked").each(function(){
              // buscamos el td más cercano en el DOM hacia "arriba"
              // luego encontramos los td adyacentes a este
              $(this).closest('td').next().next().next().next().each(function(){
                // obtenemos el texto del td 
                result[i] = $(this).text();
                ++i;
              });
            });
        opcion = {respuesta: 1};
        data=new FormData();
        data.append("emails",JSON.stringify(result));
        data.append("opcion", JSON.stringify(opcion));
        $.ajax({type: "POST", 
        url:"activarAC", 
        data: data,
        dataType:"json",
        processData: false,
        contentType: false,  
        success: 
          function(obj){
              console.log("success");
              window.alert(obj.toString());
              location.href = "visMan?idMan="+1;
          },
        error: function(status){
                window.alert("Error");
                console.log(status);
          }  
           });   
         
    }
    
     function activeOff(){
          var result = [];
            var i = 0;
            // para cada checkbox "chequeado"
            $("input[type=checkbox]:checked").each(function(){
              // buscamos el td más cercano en el DOM hacia "arriba"
              // luego encontramos los td adyacentes a este
               $(this).closest('td').next().next().next().each(function(){
                // obtenemos el texto del td 
                result[i] = $(this).text();
                ++i;
              });
            });
      opcion = {respuesta: 0};
        data=new FormData();
        data.append("emails",JSON.stringify(result));
        data.append("opcion", JSON.stringify(opcion));
         $.ajax({type: "POST", 
        url:"activarAC", 
        data: data,
        dataType:"json",
        processData: false,
        contentType: false,      
        success: 
          function(obj){
              console.log("success");
               window.alert(obj.toString());
              location.href = "visMan?idMan="+1;
          },
        error: function(status){
                window.alert("Error");
                console.log(status);
          }                    
      });           
           

    }
    
  