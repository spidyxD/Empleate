
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
    
    function giveParent(i){
        dad = {dady: i};     //averiguar como extraer el valor del atributo del anchor
        $.ajax({type: "POST", 
        url:"desplegar", 
        data: JSON.stringify(dad), 
        dataType:"json",
        success: 
            function(obj){
              loadList(obj);
              $("#categories").trigger("reset");
              console.log("success"+dad.dady);
          },
        error:
            function(status){
               console.log("error"+dad.dady);
          }                    
      });    
    }
    
    function loadList(num){        
         var n = num;     
    }