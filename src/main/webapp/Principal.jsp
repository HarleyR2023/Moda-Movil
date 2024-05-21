<%-- 
    Document   : Principal
    Created on : 18 may. 2024, 00:55:57
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.utp.modamovil.modelo.Usuario"%>

<%
    HttpSession miSesion = request.getSession();
    Usuario user = (Usuario) miSesion.getAttribute("usuario");
    String nombreUsuario = user != null ? user.getNombre() : "Usuario";
%>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <link href="CSS/principal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <div>
                <ul>
                    <li>
                        <a href="#">Nosotros</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath()%>/Controlador?menu=Productos&accion=Listar">Productos</a>
                    </li>
                    <li>
                        <a href="#">Contactanos</a>
                    </li>
                </ul>                
            </div>
            <div class="div-c">
                <div><%=nombreUsuario%></div>
                <button class="btn-cerrar" type="button">
                    Cerrar Sesion
                </button>
            </div>
        </nav>
    </body>
</html>
