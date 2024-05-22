<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Compra Confirmada</title>
    <link href="CSS/compraconfirmada.css?v=<%= System.currentTimeMillis() %>" rel="stylesheet" type="text/css"/>

</head>
<body>
    <div class="container-confirmacion">
        <h1 class="color-of">Compra Confirmada</h1>
        <p class="color-of">Gracias por tu compra. Tu pedido ha sido procesado exitosamente.</p>
        <a href="<%= request.getContextPath()%>/Controlador?menu=Productos&accion=Listar">Volver a la tienda</a>        
    </div>
</body>
</html>
