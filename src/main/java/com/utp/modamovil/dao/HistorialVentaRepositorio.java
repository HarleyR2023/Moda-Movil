package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.HistorialVenta;
import com.utp.modamovil.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class HistorialVentaRepositorio extends CrudRepositorio<HistorialVenta>{
    private static final VentaRepositorio VENTA_REPOSITORIO = new VentaRepositorio();
    
    @Override
    public void guardar(HistorialVenta entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO historialVentas VALUES (?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getVenta().getId());
            statement.setDate(2, entidad.getFecha());
            statement.setFloat(3, entidad.getTotal());
            statement.setString(4, entidad.getMetodoPago());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<HistorialVenta> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM historialVentas WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            HistorialVenta historial = new HistorialVenta();
            int ventaId = rs.getInt("venta_id");
            
            historial.setId(id);
            if (VENTA_REPOSITORIO.existe(ventaId)) {
                Venta venta = VENTA_REPOSITORIO.buscar(ventaId).get();
                historial.setVenta(venta);
            }
            historial.setFecha(rs.getDate("fecha"));
            historial.setTotal(rs.getFloat("total"));
            historial.setMetodoPago(rs.getString("metodo_pago"));
            return Optional.of(historial);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(HistorialVenta entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE historialVentas SET venta_id = ?, fecha = ?, total = ?, metodo_pago = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getVenta().getId());
            statement.setDate(1, entidad.getFecha());
            statement.setFloat(2, entidad.getTotal());
            statement.setString(3, entidad.getMetodoPago());
            statement.setInt(4, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM historialVentas WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
