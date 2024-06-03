<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>¡Se ha producido un error!</title>
</head>
<body>
    <h1>¡Se ha producido un error!</h1>
    <p>Lo sentimos, algo salió mal. Aquí tienes los detalles del error:</p>
    <ul>
        <% 
            if (exception != null) { 
        %>
        <li><strong>Mensaje:</strong> <%= exception.getMessage() %></li>
        <li><strong>Tipo de excepción:</strong> <%= exception.getClass().getName() %></li>
        <% 
            } 
            if (request.getAttribute("errorMessages") != null) {
                Vector<String> errorMessages = (Vector<String>) request.getAttribute("errorMessages");
                for (String message : errorMessages) {
        %>
        <li><%= message %></li>
        <% 
                }
            } 
        %>
    </ul>
</body>
</html>
