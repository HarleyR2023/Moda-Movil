package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class UsuarioRepositorio extends CrudRepositorio<Usuario> {

    @Override
    public void guardar(Usuario entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Usuarios VALUES (?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setString(1, entidad.getNombre());
            statement.setString(2, entidad.getContrasena());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Usuario> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Usuarios WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(rs.getString("nombre"));
            usuario.setContrasena(rs.getString("contra"));
            return Optional.of(usuario);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Usuario entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Usuarios SET nombre = ?, contra = ? WHERE id = ?")) {
            statement.setString(0, entidad.getNombre());
            statement.setString(1, entidad.getContrasena());
            statement.setInt(2, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Usuarios WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
