package com.utp.modamovil.dao;

import com.utp.modamovil.BaseDatos;
import com.utp.modamovil.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ClienteRepositorio extends CrudRepositorio<Cliente> {
    private static final UsuarioRepositorio USUARIO_REPOSITORIO = new UsuarioRepositorio();

    @Override
    public void guardar(Cliente entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("INSERT INTO Clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setInt(0, entidad.getId());
            statement.setInt(1, entidad.getUsuario().getId());
            statement.setString(2, entidad.getNombre());
            statement.setString(3, entidad.getApellido());
            statement.setString(4, entidad.getCiudad());
            statement.setString(5, entidad.getDireccion());
            statement.setString(6, entidad.getTelefono());
            statement.setString(7, entidad.getCorreo());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public Optional<Cliente> buscar(int id) {
        Connection conexion = BaseDatos.getConexion();
        
        try (PreparedStatement statement = conexion.prepareStatement("select * from Clientes where id = ?")) {
            statement.setInt(0, id);
            ResultSet rs = statement.executeQuery();
            
            if (!rs.next()) return Optional.empty();
            
            Cliente cliente = new Cliente();
            int usuarioId = rs.getInt("usuario_id");
            
            cliente.setId(id);
            if (USUARIO_REPOSITORIO.existe(usuarioId)) {
                cliente.setUsuario(USUARIO_REPOSITORIO.buscar(usuarioId).get());
            }
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setCiudad(rs.getString("ciudad"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setCorreo(rs.getString("correo"));
            return Optional.of(cliente);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }
    
    
    @Override
    public void actualizar(Cliente entidad) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("UPDATE Clientes SET usuario_id = ?, nombre = ?, apellido = ?, direccion = ?, ciudad = ?, telefono = ?, correo = ? WHERE id = ?")) {
            statement.setInt(0, entidad.getUsuario().getId());
            statement.setString(1, entidad.getNombre());
            statement.setString(2, entidad.getApellido());
            statement.setString(3, entidad.getDireccion());
            statement.setString(4, entidad.getCiudad());
            statement.setString(5, entidad.getTelefono());
            statement.setString(6, entidad.getCorreo());
            statement.setInt(7, entidad.getId());
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }

    @Override
    public void eliminar(int id) {
        Connection conexion = BaseDatos.getConexion();
        try (PreparedStatement statement = conexion.prepareStatement("DELETE FROM Clientes WHERE id = ?")) {
            statement.setInt(0, id);
            statement.execute();
        }
        catch (Exception e) {
            
        }
    }
}
