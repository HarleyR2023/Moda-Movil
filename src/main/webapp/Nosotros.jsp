<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Acerca de Nosotros</title>
    <!-- Ruta relativa para el CSS -->
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
    </style>
</head>
<body>
    <h1>Acerca de Nosotros</h1>
    <div class="about-section">
        <p>Somos una empresa dedicada a ofrecer soluciones innovadoras y personalizadas para nuestros clientes. Nos esforzamos por proporcionar productos y servicios de la más alta calidad, adaptándonos a las necesidades específicas de cada proyecto.</p>
        <p>Nuestra misión es impulsar el éxito de nuestros clientes a través de la excelencia, la innovación y el compromiso. Creemos en el poder de la colaboración y el trabajo en equipo para lograr resultados excepcionales.</p>
        <p>Contacta con nosotros en <a href="mailto:contacto@empresa.com">contacto@empresa.com</a> o visita nuestras oficinas en la Calle Ejemplo 123, Ciudad, País.</p>
    </div>
    <div class="image-gallery">
        <h2>Nuestra Colección</h2>
        <div class="image-container">
            <img src="IMG/ropa1.png" alt="Ropa 1">
            <img src="IMG/ropa2.jpg" alt="Ropa 2">
            <img src="IMG/ropa3.jpg" alt="Ropa 3">
        </div>
    </div>
</body>
</html>

