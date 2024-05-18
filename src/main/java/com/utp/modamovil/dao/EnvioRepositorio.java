package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Envio;
import com.utp.modamovil.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class EnvioRepositorio extends CrudRepositorio<Envio> {
    private static final VentaRepositorio VENTA_REPOSITORIO = new VentaRepositorio();
    
    @Override
    public void guardar(Envio entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Envio VALUES (?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getVenta().getId());
            statement.setString(2, entidad.getTipoEnvio());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Envio> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Envio WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Envio envio = new Envio();
            int ventaId = rs.getInt("venta_id");
            
            envio.setId(id);
            if (VENTA_REPOSITORIO.existe(ventaId)) {
                Venta venta = VENTA_REPOSITORIO.buscar(ventaId).get();
                envio.setVenta(venta);
            }
            envio.setTipoEnvio(rs.getString("tipo_envio"));
            return Optional.of(envio);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Envio entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Envio SET venta_id = ?, tipo_envio = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getVenta().getId());
            statement.setString(1, entidad.getTipoEnvio());
            statement.setInt(2, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Envio WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
