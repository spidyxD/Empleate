



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
        localeHX = marker.getPosition().lat();         
        //showX(localeHX);
        
    }        

    function showY(y){
	document.getElementById("localeY").value = y;
    }
    
    function giveLng(){
       localeHY = marker.getPosition().lng(); 
        //showY(localeHY);
        
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
                window.alert("Error");
                console.log(status);
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
        offerer = {idOfferer:$("#idOff").val(),nameOfferer:$("#nombre").val(),lastname:$("#apellido").val(),nationality:$("#nacionalidad").val(),email:$("#email").val(),phone:$("#telefono").val(),residence:$("#direccion").val()};     
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
        offerer = {idOfferer:$("#idOff").data("value"),nameOfferer:$("#nombre").val(),lastname:$("#apellido").val(),nationality:$("#nacionalidad").val(),email:$("#email").val(),phone:$("#telefono").val(),residence:$("#direccion").val()};     
        login = {idLogin:$("#idLog").data("value"),username:$("#userName").val(),password:$("#keyP").val()};     
        data=new FormData();
        data.append("offerer",JSON.stringify(offerer));
        data.append("login",JSON.stringify(login));
        $.ajax({type: "POST", 
        url:"UpdateInfOfferer", 
        data: data,
        dataType:"json",
        processData: false,
        contentType: false,  
        success: 
          function(obj){
              console.log("success");
              window.alert("Informacion de oferente "+obj.nameOfferer+" actualizada");
              location.href = "visPubOff?idOf="+obj.idOfferer;
          },
        error: function(status){
                window.alert("Error");
                console.log(status);
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
        company = {idCompany:$("#idCmp").data("value"),nameCompany:$("#nombreEmpresa").val(),email:$("#website").val(),phone:$("#telefono").val(),description:$("#descripcion").val(),address:$("#direccion").val()};     
        login = {idLogin:$("#idLog").data("value"),username:$("#userNC").val(),password:$("#keyP").val()};     
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
          function(obj){
              console.log("success");
               window.alert("Informacion de la compañia "+obj.nameCompany+" actualizada");
              location.href = "visPubCom?idCom="+obj.idCompany;
          },
        error: function(status){
                window.alert("Error");
                console.log(status);
          }                    
      });    
    }
    
    
    // FUNCIONES NECESARIAS PARA registro de oferentes y SUBIR ARCHIVOS PDF 
        
        function uploadOfferer_CV() {
            if($("#pdf").val().length<1){window.alert("NO CV ADJUNTO");return;}
           offerer = {nameOfferer:$("#nombre").val(),lastname:$("#apellido").val(),nationality:$("#nacionalidad").val(),email:$("#email").val(),phone:$("#telefono").val()
              ,location_X:$("#localeX").val(),location_Y:$("#localeY").val(),residence:$("#direccion").val()};
             login = {username:$("#userNa").val(),password:$("#keyp").val()};    
            data=new FormData();
            data.append("offerer", JSON.stringify(offerer));
            data.append("login", JSON.stringify(login));
            data.append("pdf", $("#pdf")[0].files[0]);
            $.ajax({
                url: "RegistroOffer",
                type: "POST",
                dataType: "json",
                data: data,
                processData: false,
                contentType: false,  
                success: function(obj){
                     console.log("success"+offerer.nameOfferer);
                     window.alert("Te damos la bienvenida a Empleate "+obj.nameOfferer+" !");
                     location.href ="Home";
                } ,
                error: function(jqXHR, textStatus, errorThrown){
                          window.alert(errorThrown);
                        }    
            });
                
        }
        function validate(event){
        var nombre=$("#nombre");
        var apellido=$("#apellido"); 
        var nacionalidad=$("#nacionalidad");
        var telefono = $("#telefono");
        var email = $("#email");
        var address = $("#direccion");
        var user = $("#userNa");
        var key = $("#keyp");
            var error=false;
            $("#formularioOff input").removeClass("invalid");
            if (nombre.val().length===0){
                    nombre.addClass("invalid");
                    error=true;
            }

            if (apellido.val().length===0){
                    apellido.addClass("invalid");
                    error=true;
            }

             if (nacionalidad.val().length===0){
                    nacionalidad.addClass("invalid");
                    error=true;
            }
             if (telefono.val().length===0){
                    telefono.addClass("invalid");
                    error=true;
            }
             if (email.val().length===0){
                    email.addClass("invalid");
                    error=true;
            }
             if (address.val().length===0){
                    address.addClass("invalid");
                    error=true;
            }
             if (user.val().length===0){
                    user.addClass("invalid");
                    error=true;console.log("1")
            }
             if (key.val().length===0){
                    key.addClass("invalid");
                    error=true;console.log("2")
            }
            if (error){event.preventDefault();
                window.alert("Datos vacios, por favor ingrese datos validos");
            }
      }
      
      function loaded(event){	
        $("#formularioOff").on("submit",validate);
     }
     // funciones necesarias para el registro de una compañia
     
      function addComp(){
        company = {nameCompany:$("#nombreEmpresa").val(),email:$("#website").val(),phone:$("#telefono").val(),description:$("#descripcion").val(),address:$("#direccion").val(),location_X:$("#localeX").val(),location_Y:$("#localeY").val()};     
        login = {username:$("#userNc").val(),password:$("#keyc").val()};     
        data=new FormData();
        data.append("company",JSON.stringify(company));
        data.append("login",JSON.stringify(login));
         $.ajax({type: "POST", 
        url: "RegistroCompany", 
        data: data,
        dataType:"json",
        processData: false,
        contentType: false,      
        success: 
          function(obj){
              console.log("success");
               window.alert("Le damos la bienvenida a la empresa "+obj.nameCompany+" a la comunidad de Empleate!");
              location.href = "Home";
          },
        error: function(jqXHR, textStatus, errorThrown){
            window.alert(errorThrown);
          }                    
      });    
    }
    
    function validateComp(event){
        var nombre=$("#nombreEmpresa");
        var descrip=$("#descripcion"); 
        var telefono = $("#telefono");
        var email = $("#website");
        var address = $("#direccion");
        var user = $("#userNc");
        var key = $("#keyc");
            var error=false;
            $("#formularioComp input").removeClass("invalid");
            if (nombre.val().length===0){
                    nombre.addClass("invalid");
                    error=true;
            }

             if (descrip.val().length===0){
                    descrip.addClass("invalid");
                    error=true;
            }
             if (telefono.val().length===0){
                    telefono.addClass("invalid");
                    error=true;
            }
             if (email.val().length===0){
                    email.addClass("invalid");
                    error=true;
            }
             if (address.val().length===0){
                    address.addClass("invalid");
                    error=true;
            }
             if (user.val().length===0){
                    user.addClass("invalid");
                    error=true;
            }
             if (key.val().length===0){
                    key.addClass("invalid");
                    error=true;
            }
            if (error){event.preventDefault();
                window.alert("Datos vacios, por favor ingrese datos validos");
            }
      }
      //PARA VALIDAR EL LOGIN
    function validateLogin(){
        login = {username:$("#userN").val(),password:$("#key").val()};   
        data=new FormData();
        data.append("login",JSON.stringify(login));
        $.ajax({type: "POST", 
        url:"doLogin", 
        data: JSON.stringify(login), 
        dataType:"json",
        processData: false,
        contentType: false,     
        success: 
          function(obj){
              location.href = "Home";
          },
        error: function(obj){
              window.alert("El usuario "+ login.username + " no existe, registrese!");
          }                    
      });    
    }
      // FUNCIONES NECESARIAS PARA LA BUSQUEDAS POR CATEGORIAS, UBICACION Y PORCENTAJE!
      function addElementToSearch(localeHX,localeHY){
        $("#results").hide();
        ubicacion = {localeHX:localeHX,localeHY:localeHY}; 
        data=new FormData();
        data.append("categories",JSON.stringify(ids));
        data.append("percents",JSON.stringify(percents));
        data.append("location",JSON.stringify(ubicacion));        
        $.ajax({type: "POST", 
        url:"consultas", 
        data: data, 
        dataType:"json",
        processData: false,
        contentType: false,     
        success: 
          function(obj){
              buildTableJobs(obj);
             
          },
       error: function(jqXHR, textStatus, errorThrown){
                    window.alert(errorThrown);
                }                 
      });    
          
      }
      function buildReview(r,cods,id){
           r.push($(id).data("value")); 
           cods.push($(id).data("codes"));
           console.log(review[count].toString());
           console.log(ids[count].toString());
           $("#resumen").append(                         
           "<li>"+ review[count].toString() + "</li>"
            );            
            count++;
        
      }
      function buildPercents(p,id){
           p.push($(id).val());
           if(percents[c] === null){
               percents[c] = 0;
           }
           console.log(percents[c].toString());
           
           c++;
           
      }
      function getLocateS(){
          localeHX = marker.getPosition().lat();
          localeHY = marker.getPosition().lng();
      }
      function clean(r,p){
          window.confirm("desea borrar el historial de categorias de la busqueda?")
          if(confirm){
          r = [];
          p =[];
          $("#resumen").children("li").remove();
          }
      }
      
      // PARA EL RESULTADO DE LA BUSQUEDA DE PUESTOS
      function buildTableJobs(obj) {          
          $("#results").show();
        var op;
        for (var i = 0; i < obj.length; i++) {
            if(obj[i].statusJob === 1){
            op = "<td>" + "disponible" + "</td>";
            }else{
            op = "<td>" + "no disponible" + "</td>";    
            }
            tr = $("<tr />");           
            
            tr.html( 
                    "<td>" + obj[i].nameJob + "</td>" +
                    "<td>" + obj[i].descriptionJob + "</td>" +
                    "<td>" + obj[i].salary + "</td>" +
                    "<td>"+"company"+"</td>" +
                    op);
            $("#results").append(tr);
        }
    }