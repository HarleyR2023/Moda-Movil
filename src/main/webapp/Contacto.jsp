<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Acerca de Nosotros</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <style>
        
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; 
            color: #333; 
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }

        h1 {
            color: #0056b3; 
            text-align: center;
            padding: 20px 0;
            margin-top: 0;
            background-color: #e1e1e1; 
            border-bottom: 2px solid #ccc; 
        }

        .about-section {
            max-width: 800px; 
            margin: 20px auto;
            padding: 20px;
            background-color: #fff; 
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
        }

        .image-gallery {
            text-align: center;
            margin: 20px auto;
        }

        .image-gallery h2 {
            color: #0056b3;
            margin-bottom: 20px;
        }

        .image-gallery .image-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 10px; 
        }

        .image-gallery img {
            width: 200px; 
            height: 150px; 
            object-fit: cover; 
            border-radius: 10px; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s; 
        }

        .image-gallery img:hover {
            transform: scale(1.05); 
        }

        a {
            color: #0056b3;
            text-decoration: none; 
        }

        a:hover {
            text-decoration: underline; 
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
