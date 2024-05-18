/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.DetallesVenta;
import com.utp.modamovil.modelo.Producto;
import com.utp.modamovil.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class DetallesVentaRepositorio extends CrudRepositorio<DetallesVenta> {
    private static final VentaRepositorio VENTA_REPOSITORIO = new VentaRepositorio();
    private static final ProductoRepositorio PRODUCTO_REPOSITORIO = new ProductoRepositorio();
    
    @Override
    public void guardar(DetallesVenta entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO detallesVentas VALUES (?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getVenta().getId());
            statement.setInt(2, entidad.getProducto().getId());
            statement.setInt(3, entidad.getCantidad());
            statement.setFloat(4, entidad.getPrecioUnitario());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<DetallesVenta> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM detallesVentas WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            DetallesVenta detalles = new DetallesVenta();
            int ventaId = rs.getInt("venta_id");
            int productoId = rs.getInt("producto_id");
            
            detalles.setId(id);
            if (VENTA_REPOSITORIO.existe(ventaId)) {
                Venta venta = VENTA_REPOSITORIO.buscar(ventaId).get();
                detalles.setVenta(venta);
            }
            if (PRODUCTO_REPOSITORIO.existe(productoId)) {
                Producto producto = PRODUCTO_REPOSITORIO.buscar(productoId).get();
                detalles.setProducto(producto);
            }
            detalles.setCantidad(rs.getInt("cantidad"));
            detalles.setPrecioUnitario(rs.getFloat("precio_unitario"));
            return Optional.of(detalles);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(DetallesVenta entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE detallesVentas SET venta_id = ?, producto_id = ?, cantidad = ?, precio_unitario = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getVenta().getId());
            statement.setInt(1, entidad.getProducto().getId());
            statement.setInt(2, entidad.getCantidad());
            statement.setFloat(3, entidad.getPrecioUnitario());
            statement.setInt(4, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM detallesVentas WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
