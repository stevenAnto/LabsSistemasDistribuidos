<%-- 
    Document   : error
    Created on : 02-jun-2024, 23:48:59
    Author     : USUARIO
--%>

<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>Oops! Algo salio mal.</h1>
    <p>Un error ocurrio: <%= request.getAttribute("errorMessage") %></p>
    <p>Intente nuevamente.</p>
    <a href='index.html'>Volver al Registro</a>"
</body>
</html>
