<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pago</title>
    <link href="CSS/pago.css?v=<%= System.currentTimeMillis() %>" rel="stylesheet" type="text/css"/>
</head>
<body>"Controlador" 
    <form action="Controlador" method="POST" class="form-pago">
        <div class="div-sup">
            <div>
                <h2 class="color-off">Seleccione el método de pago</h2>
                <input type="hidden" name="menu" value="ConfirmarCompra">
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
                <button class="btn-pagos" type="submit">Confirmar compra</button>
            </div>
        </div>            
    </form>
</body>
</html>
