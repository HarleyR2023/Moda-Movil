package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ProductoRepositorio extends CrudRepositorio<Producto> {
    private static final CategoriaRepositorio CATEGORIA_REPOSITORIO = new CategoriaRepositorio();
    private static final ProveedorRepositorio PROVEEDOR_REPOSITORIO = new ProveedorRepositorio();

    @Override
    public void guardar(Producto entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Productos VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getCategoria().getId());
            statement.setInt(2, entidad.getProveedor().getId());
            statement.setString(3, entidad.getNombre());
            statement.setString(4, entidad.getDescripcion());
            statement.setFloat(5, entidad.getPrecio());
            statement.setInt(6, entidad.getStock());
            statement.setDate(7, entidad.getFechaIngreso());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Producto> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Productos WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Producto producto = new Producto();
            int categoriaId = rs.getInt("categoria_id");
            int proveedorId = rs.getInt("proveedor_id");
            
            producto.setId(id);
            if (CATEGORIA_REPOSITORIO.existe(categoriaId)) {
                producto.setCategoria(CATEGORIA_REPOSITORIO.buscar(categoriaId).get());
            }
            if (PROVEEDOR_REPOSITORIO.existe(proveedorId)) {
                producto.setProveedor(PROVEEDOR_REPOSITORIO.buscar(proveedorId).get());
            }
            producto.setNombre(rs.getString("nombre"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecio(rs.getFloat("precio"));
            producto.setStock(rs.getInt("stock"));
            producto.setFechaIngreso(rs.getDate("fecha_ingreso"));
            return Optional.of(producto);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Producto entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Productos SET categoria_id = ?, producto_id = ?, nombre = ?, descripcion = ?, precio = ?, stock = ?, fecha_ingreso = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getCategoria().getId());
            statement.setInt(1, entidad.getProveedor().getId());
            statement.setString(2, entidad.getNombre());
            statement.setString(3, entidad.getDescripcion());
            statement.setFloat(4, entidad.getPrecio());
            statement.setInt(5, entidad.getStock());
            statement.setDate(6, entidad.getFechaIngreso());
            statement.setInt(7, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Productos WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
