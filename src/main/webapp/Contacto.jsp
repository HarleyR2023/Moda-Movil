<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Acerca de Nosotros</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
        /* Incluye aquí las mismas reglas CSS para depuración */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Color de fondo suave */
            color: #333; /* Color de texto oscuro */
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }

        h1 {
            color: #0056b3; /* Color azul para el título */
            text-align: center;
            padding: 20px 0;
            margin-top: 0;
            background-color: #e1e1e1; /* Fondo gris claro */
            border-bottom: 2px solid #ccc; /* Línea inferior */
        }

        .about-section {
            max-width: 800px; /* Ancho máximo de los párrafos */
            margin: 20px auto; /* Centrados horizontalmente */
            padding: 20px;
            background-color: #fff; /* Fondo blanco */
            border-radius: 5px; /* Bordes redondeados */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra ligera */
        }

        .image-gallery {
            text-align: center;
            margin: 20px auto;
        }

        .image-gallery h2 {
            color: #0056b3; /* Color azul para el subtítulo */
            margin-bottom: 20px;
        }

        .image-gallery .image-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 10px; /* Espacio entre imágenes */
        }

        .image-gallery img {
            width: 200px; /* Ajusta el tamaño de las imágenes */
            height: 150px; /* Mantiene una altura uniforme */
            object-fit: cover; /* Asegura que la imagen se ajuste a las dimensiones */
            border-radius: 10px; /* Bordes redondeados */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Sombra ligera */
            transition: transform 0.3s; /* Transición suave */
        }

        .image-gallery img:hover {
            transform: scale(1.05); /* Efecto de zoom al pasar el cursor */
        }

        a {
            color: #0056b3; /* Color azul */
            text-decoration: none; /* Sin subrayado */
        }

        a:hover {
            text-decoration: underline; /* Subrayado al pasar el cursor */
        }

        .comment-button {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #0056b3;
            color: #fff;
            text-align: center;
            border-radius: 5px;
            text-decoration: none;
        }

        .comment-button:hover {
            background-color: #004494;
        }
        
        p {
            text-align: center;
        }        
        
    </style>
</head>
<body>
    <h1>Contactanos</h1>
    <div class="about-section">
        <p>Si tiene alguna duda o consulta, no dude en usar nuestros canales de atención!</p>
    </div>
    <div class="image-gallery">
        <h2>Nuestros canales de atención al cliente</h2>
        <div class="image-container">
            <img src="IMG/face.PNG" alt="face">
            <img src="IMG/insta.PNG" alt="insta">
            <img src="IMG/wsp.PNG" alt="wsp">
        </div>
    </div>
</body>
</html>
