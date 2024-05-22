<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesion</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
        <link href="CSS/index.css?v=<%= System.currentTimeMillis()%>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="Validar" method="post">
            <div class="container">
                <h2>Inicio Sesion</h2>
                <div class="img-div-sesion">
                    <img class="img-sesion" src="IMG/modamovil.jpeg" alt="modamovillogo"/>
                </div>
                <div class="div-l">
                    <label class="text-sesion">Usuario</label>
                    <input type="text" name="txtuser">
                </div>
                <div class="div-l">
                    <label class="text-sesion">Contraseña</label>
                    <input type="password" name="txtpass">
                </div>
                <input class="btn-enviar" type="submit" name="accion" value="Ingresar">
            </div>    
        </form>

    </body>
</html>
