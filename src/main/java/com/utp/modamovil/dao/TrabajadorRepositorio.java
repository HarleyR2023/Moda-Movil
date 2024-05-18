package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class TrabajadorRepositorio extends CrudRepositorio<Trabajador> {
    private static final UsuarioRepositorio USUARIO_REPOSITORIO = new UsuarioRepositorio();

    @Override
    public void guardar(Trabajador entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Trabajadores VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getUsuario().getId());
            statement.setString(3, entidad.getNombre());
            statement.setString(4, entidad.getApellido());
            statement.setString(5, entidad.getCargo());
            statement.setDate(6, entidad.getFechaContratacion());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Trabajador> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Trabajadores WHERE id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.next()) return Optional.empty();
            
            Trabajador trabajador = new Trabajador();
            int usuarioId = rs.getInt("usuario_id");
            
            trabajador.setId(id);
            if (USUARIO_REPOSITORIO.existe(usuarioId)) {
                trabajador.setUsuario(USUARIO_REPOSITORIO.buscar(usuarioId).get());
            }
            trabajador.setNombre(rs.getString("nombre"));
            trabajador.setApellido(rs.getString("apellido"));
            trabajador.setCargo(rs.getString("cargo"));
            trabajador.setFechaContratacion(rs.getDate("fecha_contratacion"));
            return Optional.of(trabajador);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void actualizar(Trabajador entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Trabajadores SET usuario_id, nombre = ?, apellido = ?, cargo = ?, fecha_contratacion = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getUsuario().getId());
            statement.setString(1, entidad.getNombre());
            statement.setString(2, entidad.getApellido());
            statement.setString(3, entidad.getCargo());
            statement.setDate(4, entidad.getFechaContratacion());
            statement.setInt(5, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Trabajadores WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
