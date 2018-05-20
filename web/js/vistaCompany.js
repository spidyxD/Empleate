



function initMap(x, y) {
    var myLatLng = {lat: x, lng: y};//{lat: 10.0345799, lng: -84.1374039};
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

window.onload = iniciarTodo;