package com.utp.modamovil.dao;

import com.utp.modamovil.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.utp.modamovil.modelo.Usuario;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario buscar(String nombreUsuario) {
        Usuario u = null; // Inicia con null para manejar casos donde no se encuentra el usuario
        String sql = "SELECT * FROM Usuarios WHERE nombreuser=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombreUsuario(rs.getString("nombreuser"));
                u.setContra(rs.getString("contra")); // Cambiar para obtener una cadena de caracteres
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setTelefono(rs.getString("telefono"));
                u.setCorreo(rs.getString("correo"));
                u.setIndicador(rs.getString("indicador"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return u;
    }
    
    // Método para validar un usuario por nombre de usuario y contraseña
    public Usuario validar(String nombreUsuario, String contra) { // Cambiar el tipo de dato de la contraseña
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuarios WHERE nombreuser=? AND contra=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contra); // Cambiar para establecer una cadena de caracteres
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombreUsuario(rs.getString("nombreuser"));
                usuario.setContra(rs.getString("contra")); // Cambiar para obtener una cadena de caracteres
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIndicador(rs.getString("indicador"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }    
    
    public List<Usuario> listar(){
        String sql = "SELECT * FROM Usuarios";
        List<Usuario> lista = new ArrayList<>();    
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombreUsuario(rs.getString("nombreuser"));
                usuario.setContra(rs.getString("contra")); // Cambiar para obtener una cadena de caracteres
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIndicador(rs.getString("indicador"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
    
    public int agregar(Usuario usuario){
        String sql = "INSERT INTO Usuarios(nombreuser, contra, nombre, apellido, telefono, correo, indicador) VALUES (?,?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContra()); // Cambiar para establecer una cadena de caracteres
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getIndicador());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;
    }
    
    public Usuario listarId(int id){
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM Usuarios WHERE id=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                usuario.setNombreUsuario(rs.getString("nombreuser"));
                usuario.setContra(rs.getString("contra")); // Cambiar para obtener una cadena de caracteres
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setIndicador(rs.getString("indicador"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
            
    public int actualizar(Usuario usuario){
        String sql = "UPDATE Usuarios SET nombreuser=?, contra=?, nombre=?, apellido=?, telefono=?, correo=?, indicador=? WHERE id=?";
        try {
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContra()); // Cambiar para establecer una cadena de caracteres
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getIndicador());
            ps.setInt(8, usuario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;        
    }
    
    public void delete(int id){
           String sql = "DELETE FROM Usuarios WHERE id=?";
           try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}