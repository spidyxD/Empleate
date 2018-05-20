
$(document).ready(function(){
    $('.parallax').parallax();
});

$('.carousel.carousel-slider').carousel({
fullWidth: true,
indicators: true
});
autoplay() //para hacer que el carrusel se mueva solo
function autoplay() {
    $('.carousel').carousel('next');
    setTimeout(autoplay, 4500);
}
  $(document).ready(function(){
    $('.modal').modal();
  });
  
  
  // FUNCIONES NECESARIAS PARA LA BUSQUEDA DE PUESTO POR CATEGORIA Y UBICACION
   function alerta(){
        giveLat();
        giveLng();
        window.alert("Ubicacion añadida a la busqueda!");       
    }

    function showX(x){
        document.getElementById("localeX").value = x;
    }
    
    function giveLat(){
        var x = marker.getPosition().lat();
        showX(x);       
    }        

    function showY(y){
	document.getElementById("localeY").value = y;
    }
    
    function giveLng(){
        var y = marker.getPosition().lng();  
        showY(y);     
    }
    //envia el porcentaje escogido en la categoria seleccionada
    function givePercent(i){
        porcentaje = {percent: i};     
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
    }
    //envia el id de la categoria para buscar los hijos
    function giveParent(i){
        dad = {dady: i};     //averiguar como extraer el valor del atributo del anchor
        $.ajax({type: "POST", 
        url:"desplegar", 
        data: JSON.stringify(dad), 
        dataType:"json",
        success: 
            function(obj){
              loadList(obj);
              $("#listSons").trigger("reset");
              console.log("success"+dad.dady);
          },
        error:
            function(status){
               console.log("error"+dad.dady);
          }                    
      });    
    }
    
    function loadList(num){        
        var ul =$("<ul />");
	ul.html( "<li>" + num['dady'] + "</li>" );
	$("#listSons").append(ul);     
    }
    
    //PARA EL MENU DESPLEGABLE DE CATEGORIAS
    function expandAll(){
    $(".collapsible-header").addClass("active");
    $(".collapsible").collapsible({accordion: false});
    }

    function collapseAll(){
    $(".collapsible-header").removeClass(function(){
    return "active";
    });
    $(".collapsible").collapsible({accordion: true});
    $(".collapsible").collapsible({accordion: false});
    }