<%-- 
    Document   : busquedaForm
    Created on : Mar 31, 2018, 5:05:46 PM
    Author     : Andrés Gutiérrez
--%>

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
    </head>
    <body>
        <%@ include file="header.jspf" %>
        <div class="row">
            <div class="cuerpo container">
               <h2 class="col s12">Busqueda por categoria<h2>
                       <h4>Categorias</h4>
                <form action="consultasEmpleateJobsByCategory" method="post">
                    <%ArrayList<Category> ct = CategoryModel.instance().findAllCategories(); %>
                    <%for(int i=0;i<ct.size();i++){%>
                    <p>
                        <label>
                            <input type="checkbox" name="cbx" onclick="myFunction()" value="<%=ct.get(i).getNameCategory()%>" id="<%=ct.get(i).getNameCategory()%>">
                            <span><%=ct.get(i).getNameCategory()%></span>
                            <%}%>
                        </label>
                    </p>
                      <div class="input-field col s12">
                        <input class="btn"  type="submit" value="Buscar">
                      </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jspf" %>
</body>
</html>

<script type="text/javascript">
function myFunction() {
    /*var newE = document.createElement("input"); 
    newE.setAttribute("type", "text");
    var newContent = document.createTextNode("sexo"); 
    //newE.appendChild(newContent);
   
    var x = document.getElementsByName("cbx");
    var current = document.getElementById("demo"); //x[0].value
    //document.body.insertBefore(newE, current);
    current.appendChild(newE); 
    var i;
    for(i=0;i<x.length;i++) {
        if(x[0].checked){
            var current = document.getElementById(x[i].value); 
            //document.body.insertBefore(newE, current);
            current.appendChild(newE); 
            //return x[i].value;
        }
    }*/
   // return "";
}
</script>