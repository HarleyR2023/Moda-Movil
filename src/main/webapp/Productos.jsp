<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.utp.modamovil.modelo.Producto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pagina Productos</title>
    <link href="CSS/productos.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <h1>Productos</h1>
    
    <div class="father-c">
        <% 
            List<Producto> productos = (List<Producto>) request.getAttribute("producto");
            if (productos != null) {
                for (Producto prod : productos) { 
        %>
        <div class="container-p">
            <h2><%= prod.getNombre() %></h2>
            <p>
                <%= prod.getDescripcion() %>
            </p>
            <p><span>Precio: </span><%= prod.getPrecio() %></p>
            <form action="Controlador" method="POST">
                <input type="hidden" name="menu" value="Productos">
                <input type="hidden" name="accion" value="AgregarCarrito">
                <input type="hidden" name="id" value="<%= prod.getId() %>">
                <button type="submit">Agregar al carrito</button>
            </form>
        </div>
        <% 
                }
            } else { 
        %>
        <h2>No hay Productos</h2>
        <% 
            }
        %>
    </div>
    
    <h1>Carrito de Compras</h1>
    <div class="carrito">
        <% 
            List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
            if (carrito != null && !carrito.isEmpty()) {
                for (Producto prod : carrito) { 
        %>
        <div class="container-p">
            <h2><%= prod.getNombre() %></h2>
            <p><span>Precio: </span><%= prod.getPrecio() %></p>
        </div>
        <% 
                }
            } else { 
        %>
        <h2>No hay productos en el carrito</h2>
        <% 
            }
        %>
    </div>
</body>
</html>
