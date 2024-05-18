package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ProveedorRepositorio extends CrudRepositorio<Proveedor> {

    @Override
    public void guardar(Proveedor entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Proveedor VALUES (?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setString(1, entidad.getNombre());
            statement.setString(2, entidad.getDireccion());
            statement.setString(3, entidad.getTelefono());
            statement.setString(4, entidad.getCorreo());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Proveedor> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Proveedor WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Proveedor proveedor = new Proveedor();
            proveedor.setId(id);
            proveedor.setNombre(rs.getString("nombre"));
            proveedor.setDireccion(rs.getString("direccion"));
            proveedor.setTelefono(rs.getString("telefono"));
            proveedor.setCorreo(rs.getString("correo"));
            return Optional.of(proveedor);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Proveedor entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Proveedor SET nombre = ?, direccion = ?, telefono = ?, correo = ? WHERE id = ?")) {
            statement.setString(0, entidad.getNombre());
            statement.setString(1, entidad.getDireccion());
            statement.setString(2, entidad.getTelefono());
            statement.setString(3, entidad.getCorreo());
            statement.setInt(4, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Proveedor WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
