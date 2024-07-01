<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.utp.modamovil.modelo.Producto"%>
<%@page import="com.utp.modamovil.modelo.Usuario" %>
<%@page import="java.util.List"%>

<%
    HttpSession miSesion = request.getSession();
    Usuario user = (Usuario) miSesion.getAttribute("usuario");
    String nombreUsuario = user != null ? user.getNombre() : "Usuario";
%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pagina Productos</title>
    <link href="CSS/productos.css?v=<%= System.currentTimeMillis() %>" rel="stylesheet" type="text/css"/>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>    
</head>
<body>
    
        <nav>
            <div>
                <ul>
                    <li>
                        <a href="<%= request.getContextPath()%>/Controlador?menu=Nosotros">Nosotros</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath()%>/Controlador?menu=Productos&accion=Listar">Productos</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath()%>/Controlador?menu=Contacto">Contactanos</a>
                    </li>
                </ul>                
            </div>
            <div class="div-c">
                <div class="div-icon">
                    <i style="font-size: 25px;" class='bx bxs-user-rectangle'></i>                    
                    <%=nombreUsuario%>
                </div>
                <form action="Validar" method="post">
                    <button class="btn-cerrar" type="submit" name="accion" value="Salir">
                        Cerrar Sesion
                    </button>                    
                </form>
            </div>
        </nav>    
    
    
    <div class="global-div">
    <div class="father-c">
        <% 
            List<Producto> productos = (List<Producto>) request.getAttribute("producto");
            if (productos != null) {
                for (Producto prod : productos) { 
        %>
        <div class="container-p">
            <h3 class="h2-div color-p"><%= prod.getNombre() %></h3>
            <div class="img-div">
                <img src="<%= prod.getUrlImagen() %>" alt="<%= prod.getUrlImagen() %>"/>
            </div>
            <p class="color-p">
                <%= prod.getDescripcion() %>
            </p>
            <p class="color-p"><span class="span-color">Precio: </span>S/<%= prod.getPrecio() %></p>
            <form action="Controlador" method="POST">
                <input type="hidden" name="menu" value="Productos">
                <input type="hidden" name="accion" value="AgregarCarrito">
                <input type="hidden" name="id" value="<%= prod.getId() %>">
                <button type="submit" class="btn-div">Agregar al carrito</button>
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
    
    <div class="carrito">
        <div class="div-h2">
            <i class='bx bxs-cart' style='color:black; font-size: 30px; color: #AB9DB3;' ></i>
            <h2>Carrito de Compras</h2>            
        </div>
        
        <div class="global-carrito">
        <% 
            List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
            if (carrito != null && !carrito.isEmpty()) {
                double total = 0;
                for (Producto prod : carrito) { 
                    total += prod.getPrecio() * prod.getCantidad();
        %>
        <div class="container-c">
            <h3 class="color-p"><%= prod.getNombre() %></h3>
            <div class="father-carrito">
                <div class="img-carrito">
                    <img src="<%= prod.getUrlImagen() %>" alt="<%= prod.getUrlImagen() %>"/>
                </div>
            <div>
                <p class="carrito-p color-p"><span class="span-color">Precio: </span>S/ <%= prod.getPrecio() %></p>
                <p class="carrito-p color-p"><span class="span-color">Cantidad: </span><%= prod.getCantidad() %></p>
            <form class="form-carrito" action="Controlador" method="POST">
                <input type="hidden" name="menu" value="ActualizarCarrito">
                <input type="hidden" name="id" value="<%= prod.getId() %>">
                <input type="hidden" name="cantidad" value="<%= prod.getCantidad() %>">
                <button class="btn-o" type="submit" name="accion" value="Restar">-</button>
                <input class="in-cant" type="text" name="cantidad" value="<%= prod.getCantidad() %>">
                <button class="btn-o" type="submit" name="accion" value="Sumar">+</button>
                <button class="btn-e" type="submit" name="accion" value="Eliminar">Eliminar</button>
            </form>
            </div>
            </div>
        </div>
        <% 
                }
        %>
        </div>                
        
        <div class="container-pago">
            <div class="total">
                <span>Total: <%= total %></span>
            </div>
            <form action="Controlador" method="POST">
                <input type="hidden" name="menu" value="Pago">
                <button class="btn-gencompra" type="submit">Generar Compra</button>
                <input type="hidden" name="nombreUsuario" value="<%= nombreUsuario %>">
            </form>            
        </div>

        <% 
            } else { 
        %>
        <h3 class="h3-div">No hay productos en el carrito</h3>
        <% 
            }
        %>
    </div>
    
    </div>
</body>
</html>
