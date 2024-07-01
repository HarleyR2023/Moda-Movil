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
    <title>Pago</title>
    <link href="CSS/pago.css?v=<%= System.currentTimeMillis() %>" rel="stylesheet" type="text/css"/>
</head>
<body>
    
    <form action="Controlador" method="POST" class="form-pago">
        <div class="div-sup">
            <div>
                <h2 class="color-off">Seleccione el método de pago</h2>
                <input type="hidden" name="menu" value="ConfirmarCompra">
                <input type="hidden" name="nombreUsuario" value="<%=nombreUsuario%>">
                <div class="conteiner-card">
                <div class="div-con">
                    <div class="div-img-p">
                        <img class="img-p" src="IMG/CCARD.jpeg" alt="CCARD"/>
                    </div>
                    <div class="label-m">
                        <input type="radio" id="credito" name="metodoPago" value="Tarjeta de crédito">
                        <label class="color-off" for="credito">Tarjeta de Crédito</label>                        
                    </div>
                </div>
                <div class="div-con">
                    <div class="div-img-p">
                        <img class="img-p" src="IMG/DCARD.jpeg" alt="CCARD"/>
                    </div>
                    <div class="label-m">
                        <input type="radio" id="debito" name="metodoPago" value="Tarjeta de débito">
                        <label class="color-off" for="debito">Tarjeta de Débito</label>
                    </div>
                </div>
                <div class="div-con">
                    <div class="div-img-p">
                        <img class="img-p" src="IMG/EFEC.jpeg" alt="CCARD"/>
                    </div>  
                    <div class="label-m">
                        <input type="radio" id="efectivo" name="metodoPago" value="Efectivo">
                        <label class="color-off" for="efectivo">Efectivo</label>
                    </div>
                </div>
                </div>                    
            </div>
            <div>
                <h2 class="color-off">Seleccione el método de envío</h2>
                <div class="conteiner-card-t">
                    <div class="div-con">
                        <div class="div-img-p">
                            <img class="img-p" src="IMG/RECOJO.jpeg" alt="CCARD"/>
                        </div>    
                        <div class="label-m">
                            <input type="radio" id="tienda" name="metodoEnvio" value="Recogo En Tienda">
                            <label class="color-off" for="tienda">Recogo En Tienda</label>                       
                        </div>
                    </div>
                    
                    <div class="div-con">
                        <div class="div-img-p">
                            <img class="img-p" src="IMG/DELIVERY.jpeg" alt="CCARD"/>
                        </div>  
                        <div class="label-m">
                            <input type="radio" id="delivery" name="metodoEnvio" value="Delivery">
                            <label class="color-off" for="delivery">Delivery</label><br>                             
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <button type="button" class="btn-pagos btnComprafinta">Confirmar Compra</button>
            </div>
                
            <div class="tarjetaDiv modalNone">
                <div class="tarjetaFondo">
                    <h2>Ingresa Tarjeta</h2>

                    <div class="tar-form">
                        <div class="tar-div">
                            <label>Numero de Tarjeta:</label>
                            <input type="text" id="cardNumber" maxlength="19" oninput="formatCardNumber(this)" placeholder="xxxx xxxx xxxx xxxx"/>
                        </div>
                        <div class="tar-div">
                            <label>Cvv:</label>
                            <input id="cardNumber" type="password" maxlength="3"/>
                        </div>
                    </div>
                    <div class="tar-botones">
                        <button type="submit">Confirmar compra</button>
                        <button type="button" class="btnCerrar">Cerrar</button>
                    </div>
                </div>
            </div>                
                
                
        </div>            
    </form>
    <script src="JS/pago.js"></script>
</body>
</html>
