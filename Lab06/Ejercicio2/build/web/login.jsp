<%-- 
    Document   : login
    Created on : 03-jun-2024, 0:46:07
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Segundo Formulario</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 300px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="ProcesarDatosServlet" method="post">
            <%-- Obtener los datos del primer formulario --%>
            <% String usu1 = request.getParameter("usu1"); %>
            <% String contra1 = request.getParameter("contra1"); %>
            
            <%-- Campos ocultos para usu1 y contra1 --%>
            <input type="hidden" id="usu1_hidden" name="usu1_hidden" value="<%= usu1 %>">
            <input type="hidden" id="contra1_hidden" name="contra1_hidden" value="<%= contra1 %>">
            
            <%-- Campos para ingresar usu2 y contra2 --%>
            <label for="usu2">Usuario 2:</label>
            <input type="text" id="usu2" name="usu2"><br><br>
            <label for="contra2">Contraseña 2:</label>
            <input type="password" id="contra2" name="contra2"><br><br>
            
            <input type="submit" value="Enviar">
        </form>
    </div>
</body>
</html>
