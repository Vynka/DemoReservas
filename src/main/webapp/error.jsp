<%-- 
    Document   : error
    Created on : 16-ene-2017, 8:54:56
    Author     : 2dawb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error: <%= request.getParameter("error")%></h1>
    </body>
</html>