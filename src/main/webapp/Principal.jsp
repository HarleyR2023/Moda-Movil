<%-- 
    Document   : Principal
    Created on : 18 may. 2024, 00:55:57
    Author     : Arturo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </nav>
    </body>
</html>
