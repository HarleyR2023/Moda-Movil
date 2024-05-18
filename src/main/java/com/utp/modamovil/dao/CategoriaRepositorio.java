package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class CategoriaRepositorio extends CrudRepositorio<Categoria> {

    @Override
    public void guardar(Categoria entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Categoria VALUES (?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setString(1, entidad.getNombre());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Categoria> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Categoria WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Categoria categoria = new Categoria();
            categoria.setId(id);
            categoria.setNombre(rs.getString("nombre"));
            return Optional.of(categoria);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Categoria entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Categoria SET nombre = ? WHERE id = ?")) {
            statement.setString(0, entidad.getNombre());
            statement.setInt(1, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Categoria WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
