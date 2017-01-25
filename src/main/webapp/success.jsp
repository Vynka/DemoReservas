<%-- 
    Document   : success
    Created on : 16-ene-2017, 8:55:30
    Author     : 2dawb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body>
        <h1>Reserva correcta.</h1>
        <h2>Precio:</h2>
        <h3><%= request.getParameter("precio") %> Euros</h3>
    </body>
</html>
