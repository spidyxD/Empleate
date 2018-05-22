
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
    
    //PARA LA ACTUALIZACION DE DATOS DEL OFERENTE
    function giveOfferer(){
        offerer = {nameOfferer:$("#nombre").val(),lastname:$("#apellido").val(),nationality:$("#nacionalidad").val(),email:$("#email").val(),phone:$("#telefono").val(),residence:$("#direccion").val()};     
        $.ajax({type: "POST", 
        url:"UpdateInfOfferer", 
        data: JSON.stringify(offerer), 
        dataType:"json",
        success: 
          function(){
              console.log("success");
          },
        error: function(){
               console.log("error"+offerer.nameOfferer);
          }                    
      });    
    }
    function giveLogOff(){
        login = {username:$("#username").val(),password:$("#password").val()};     
        $.ajax({type: "POST", 
        url:"UpdateInfOfferer", 
        data: JSON.stringify(login), 
        dataType:"json",
        success: 
          function(){
              console.log("success");
          },
        error: function(){
               console.log("error"+login.username);
          }                    
      });    
    }
     function updateOff(){
       offerer = {nameOfferer:$("#nombre").val(),lastname:$("#apellido").val(),nationality:$("#nacionalidad").val(),email:$("#email").val(),phone:$("#telefono").val(),residence:$("#direccion").val()};     
        login = {username:$("#username").val(),password:$("#password").val()};     
        data=new FormData();
        data.append("company",JSON.stringify(offerer));
        data.append("login",JSON.stringify(login));
        $.ajax({type: "POST", 
        url:"UpdateInfOfferer", 
        data: data,
        dataType:"json",
        processData: false,
        contentType: false,  
        success: 
          function(){
              console.log("success");
          },
        error: function(){
               console.log("error"+offerer.nameOfferer);
          }  
           });   
    }
    //PARA LA ACTUALIZACION DE DATOS DE UNA COMPAÑIA
    function giveCompany(){
        company = {nameCompany:$("#nombreEmpresa").val(),email:$("#website").val(),phone:$("#telefono").val(),description:$("#descripcion").val(),address:$("#direccion").val()};     
        $.ajax({type: "POST", 
        url:"UpdateInfCompany", 
        data: JSON.stringify(company), 
        dataType:"json",
        success: 
          function(){
              console.log("success");
          },
        error: function(){
               console.log("error"+company.nameCompany);
          }                    
      });    
    }
    
     function giveLogComp(){
        login = {username:$("#username").val(),password:$("#password").val()};     
        $.ajax({type: "POST", 
        url:"UpdateInfCompany", 
        data: JSON.stringify(login), 
        dataType:"json",
        success: 
          function(){
              console.log("success");
          },
        error: function(){
               console.log("error"+login.username);
          }                    
      });  
    }
    
    function updateComp(){
        company = {nameCompany:$("#nombreEmpresa").val(),email:$("#website").val(),phone:$("#telefono").val(),description:$("#descripcion").val(),address:$("#direccion").val()};     
        login = {username:$("#username").val(),password:$("#password").val()};     
        data=new FormData();
        data.append("company",JSON.stringify(company));
        data.append("login",JSON.stringify(login));
         $.ajax({type: "POST", 
        url:"UpdateInfCompany", 
        data: data,
        dataType:"json",
        processData: false,
        contentType: false,      
        success: 
          function(){
              console.log("success");
          },
        error: function(){
               console.log("error"+company.nameCompany);
          }                    
      });    
    }