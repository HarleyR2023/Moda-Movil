package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class VentaRepositorio extends CrudRepositorio<Venta> {
    private static final UsuarioRepositorio USUARIO_REPOSITORIO = new UsuarioRepositorio();
    
    @Override
    public void guardar(Venta entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Ventas VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getUsuario().getId());
            statement.setDate(2, entidad.getFecha());
            statement.setFloat(3, entidad.getTotal());
            statement.setString(4, entidad.getMetodoPago());
            statement.setString(5, entidad.getEstado());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Venta> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Ventas WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Venta venta = new Venta();
            int usuarioId = rs.getInt("usuario_id");
            
            venta.setId(id);
    
            if (USUARIO_REPOSITORIO.existe(usuarioId)) {
                venta.setUsuario(USUARIO_REPOSITORIO.buscar(usuarioId).get());
            }
            venta.setFecha(rs.getDate("fecha"));
            venta.setTotal(rs.getFloat("total"));
            venta.setMetodoPago(rs.getString("metodo_pago"));
            venta.setEstado(rs.getString("estado"));
            return Optional.of(venta);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Venta entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Ventas SET usuario_id = ?, fecha = ?, total = ?, metodo_pago = ?, estado = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getUsuario().getId());
            statement.setDate(1, entidad.getFecha());
            statement.setFloat(2, entidad.getTotal());
            statement.setString(3, entidad.getMetodoPago());
            statement.setString(4, entidad.getEstado());
            statement.setInt(5, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Ventas WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
