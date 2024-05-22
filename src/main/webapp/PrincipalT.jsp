
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>   
        <div class = "d-flex">
            <div class ="card col-sm-6">
                <div class = "card-body">
                <form>
                    <div class = "form-group">
                        <label> ID </label>
                    <input type="text" name="txtID" class="form-control">
                    </div>
                    <div class = "form-group">
                        <label> Nombre </label>
                    <input type="text" name ="txtNom" class="form-control">
                    </div>
                    <div class = "form-group">
                        <label> Direccion </label>
                    <input type ="text" name = "txtDirec" class= "form-control">
                    </div>
                    <div class = "form-group">
                        <label> Telefono </label>
                    <input type ="text" name = "txtTel" class= "form-control">
                    </div>
                    <div class = "form-group">
                        <label> Correo </label>
                    <input type ="text" name = "txtCorreo" class= "form-control">
                    </div>
                <input type = "submit" name = "accion" value = "Agregar" class = "btn btn-info">
                </form>
            </div>
        </div>
        <div class="col-sm-8"> 
            <table class = "table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>DIRECCION</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "em" items = "${Proveedores}">
                    <tr>
                        <td>${em.getId()}</td>
                        <td>${em.getNombre()}</td>
                        <td>${em.getDireccion()}</td>
                        <td>${em.getTelefono()}</td>
                        <td>${em.getCorreo()}</td>
                    </tr>
                    </c:forEach>
                </tbody>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
    