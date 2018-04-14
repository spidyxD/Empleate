<%-- 
    Document   : popUpErrorLogin
    Created on : 03/04/2018, 09:05:55 PM
    Author     : Addiel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="alertSssion" class="modal">
     <div class="modal-content">
        <form action="Login" method="post" class="col s12">
            <div class="row">
                <div class= "col s12"><h4>Ups hubo un error!</h4></div>
            </div>
             <jsp:useBean id="username" scope="request" type="java.lang.String" class="java.lang.String" />
              <jsp:useBean id="password" scope="request" type="java.lang.String" class="java.lang.String" />
            <div class="row">
                <div class="input-field col s12">
                    <input name ="username" id="username" type="text" class="validate" value=username>
                    <label for="username">username</label>
                </div>
            </div>  
            <div class="row">
                <div class="input-field col s6" data-validate="Enter password">
                    <span class="btn-show-pass">
                    <i class="zmdi zmdi-eye"></i>
                    </span>
                    <input name="password" id="password" type="password" class="validate" value=password>
                    <label for="password" color="white">Password</label>
                </div> 
            </div>
            <div class="row">  
                <div class="input-field col s12" >
                    <p>Datos ingresados invalidos, intentelo nuevamente!</p>
                </div>   
            </div>
            
            
            <div class="input-field col s12">
                <div class="container-login100-form-btn">
                <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                                Login
                        </button>
                </div>
                </div>
            </div>
        </form>
    </div>
    </div>
    </body>
</html>

<style>
    .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 450px;
    height: 500px;
    background-color:#53167dcc;
    overflow: auto; /* Enable scroll if needed */
}

.input-field label{
  color:black;
}

.btn{
    text-align:center;
}
    
</style>

