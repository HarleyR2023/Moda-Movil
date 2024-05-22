<%@ page import="com.utp.modamovil.modelo.Proveedor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>   
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <%
                        Proveedor proff = (Proveedor) request.getAttribute("proveedor");
                    %>                    
                    <form action="Controlador?menu=PrincipalT" method="POST">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="<%= (proff != null) ? proff.getNombre() : "" %>" name="txtNom" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="<%= (proff != null) ? proff.getDireccion() : "" %>" name="txtDirec" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="<%= (proff != null) ? proff.getTelefono() : "" %>" name="txtTel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="<%= (proff != null) ? proff.getCorreo() : "" %>" name="txtCorreo" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
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
                        <% 
                            List<Proveedor> prov = (List<Proveedor>) request.getAttribute("proveedores");
                            if (prov != null) {
                                for (Proveedor pro : prov) { 
                        %>
                        <tr>
                            <td><%= pro.getId() %></td>
                            <td><%= pro.getNombre() %></td>
                            <td><%= pro.getDireccion() %></td>
                            <td><%= pro.getTelefono() %></td>
                            <td><%= pro.getCorreo() %></td>
                            <td>
                                <a class="btn btn-primary btn-sm" href="Controlador?menu=PrincipalT&accion=Editar&id=<%= pro.getId()%>">Editar</a>
                                <a class="btn btn-danger btn-sm" href="Controlador?menu=PrincipalT&accion=Delete&id=<%= pro.getId()%>">Eliminar</a>
                            </td>
                        </tr>
                        <% 
                                }
                            } else { 
                        %>
                        <tr>
                            <td colspan="6" class="text-center">No hay proveedores disponibles</td>
                        </tr>
                        <% 
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
