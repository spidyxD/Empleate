<%-- 
    Document   : Home
    Created on : Mar 21, 2018, 9:39:14 PM
    Author     : Andrés Gutiérrez
--%>

<%@page import="Empleate.logica.JobModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
           <% for(int i = 0;i<JobModel.instance().top5().size();i++){ %>
           <p><%= JobModel.instance().top5().get(i).getNameJob() %></p>
           <% } %>
    </body>
</html>
