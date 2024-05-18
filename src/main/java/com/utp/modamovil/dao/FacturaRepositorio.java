package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Factura;
import com.utp.modamovil.modelo.Usuario;
import com.utp.modamovil.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class FacturaRepositorio extends CrudRepositorio<Factura> {
    private static final VentaRepositorio VENTA_REPOSITORIO = new VentaRepositorio();
    private static final UsuarioRepositorio USUARIO_REPOSITORIO = new UsuarioRepositorio();

    @Override
    public void guardar(Factura entidad) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Facturas VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getVenta().getId());
            statement.setInt(2, entidad.getUsuario().getId());
            statement.setDate(3, entidad.getFecha());
            statement.setFloat(4, entidad.getTotal());
            statement.setString(5, entidad.getMetodoPago());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Factura> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Facturas WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            
            Factura factura = new Factura();
            int ventaId = rs.getInt("venta_id");
            int usuarioId = rs.getInt("usuario_id");
            
            
            if (VENTA_REPOSITORIO.existe(ventaId)) {
                Venta venta = VENTA_REPOSITORIO.buscar(ventaId).get();
                factura.setVenta(venta);
            }
            if (USUARIO_REPOSITORIO.existe(usuarioId)) {
                Usuario usuario = USUARIO_REPOSITORIO.buscar(usuarioId).get();
                factura.setUsuario(usuario);
            }
            factura.setFecha(rs.getDate("fecha"));
            factura.setTotal(rs.getFloat("total"));
            factura.setMetodoPago(rs.getString("metodo_pago"));
            return Optional.of(factura);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }
    
    @Override
    public void actualizar(Factura entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Facturas SET venta_id = ?, usuario_id = ?, fecha = ?, total = ?, metodo_pago = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getVenta().getId());
            statement.setInt(1, entidad.getUsuario().getId());
            statement.setDate(2, entidad.getFecha());
            statement.setFloat(3, entidad.getTotal());
            statement.setString(4, entidad.getMetodoPago());
            statement.setInt(5, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Facturas WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    
    
    
}
