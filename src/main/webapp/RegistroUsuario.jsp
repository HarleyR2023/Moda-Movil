<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuario</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
        <link href="CSS/registroUsuario.css?v=<%= System.currentTimeMillis()%>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="RegistroUsuario" method="post">
            <div class="container">
                <h2>Registrar Usuario</h2>
                
                <div class="img-div-sesion">
                    <img class="img-sesion" src="IMG/modamovil.jpeg" alt="modamovillogo"/>
                </div>
                
                <div class="div-l">
                    <label class="text-sesion">Usuario</label>
                    <input type="text" name="username" class="input-1">
                    
                    <label class="text-sesion">Nombre</label>
                    <input type="text" name="nombre" class="input-1">
                    
                    <label class="text-sesion">Apellidos</label>
                    <input type="text" name="apellidos" class="input-1">
                </div>
                
                <div class="div-l">
                    <label class="text-sesion">Contraseņa</label>
                    <input type="password" name="password" class="input-1">
                    
                    <label class="text-sesion">Confirmar Contraseņa</label>
                    <input type="password" name="confirmar_password" class="input-1">
                   
                </div>
                
                <input class="btn-enviar" type="submit" name="accion" value="Crear Cuenta">
            </div>
        </form>
    </body>
</html>
