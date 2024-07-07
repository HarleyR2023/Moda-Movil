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
                </div>
                <!--  
                    Falta nombre, apellidos, correo, telefono 
                --> 
                
                <div class="div-l">
                    <label class="text-sesion">Contraseña</label>
                    <input type="password" name="password" class="input-1">
                    
                    <label class="text-sesion">Confirmar Contraseña</label>
                    <input type="password" name="confirm_password" class="input-1">
                </div>
                
                <input class="btn-enviar" type="submit" name="register" value="Registrar">
            </div>
        </form>
    </body>
</html>
