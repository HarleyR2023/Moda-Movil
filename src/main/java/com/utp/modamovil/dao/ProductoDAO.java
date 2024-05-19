package com.utp.modamovil.dao;

import com.utp.modamovil.Conexion;
import com.utp.modamovil.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    // Método para buscar un producto por nombre
    public Producto buscar(String nombreProducto) {
        Producto producto = null;
        String sql = "SELECT * FROM Productos WHERE nombre=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setCategoriaId(rs.getInt("categoria_id"));
                producto.setProveedorId(rs.getInt("proveedor_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setFechaIngreso(rs.getDate("fecha_ingreso"));
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
        return producto;
    }

    // Método para listar todos los productos
    public List<Producto> listar() {
        String sql = "SELECT * FROM Productos";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setCategoriaId(rs.getInt("categoria_id"));
                producto.setProveedorId(rs.getInt("proveedor_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setFechaIngreso(rs.getDate("fecha_ingreso"));
                lista.add(producto);
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

    // Método para agregar un nuevo producto
    public int agregar(Producto producto) {
        String sql = "INSERT INTO Productos(categoria_id, proveedor_id, nombre, descripcion, precio, stock, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getCategoriaId());
            ps.setInt(2, producto.getProveedorId());
            ps.setString(3, producto.getNombre());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setDate(7, new java.sql.Date(producto.getFechaIngreso().getTime()));
            r = ps.executeUpdate();
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

    // Método para listar un producto por ID
    public Producto listarId(int id) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM Productos WHERE id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setCategoriaId(rs.getInt("categoria_id"));
                producto.setProveedorId(rs.getInt("proveedor_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setFechaIngreso(rs.getDate("fecha_ingreso"));
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
        return producto;
    }

    // Método para actualizar un producto
    public int actualizar(Producto producto) {
        String sql = "UPDATE Productos SET categoria_id=?, proveedor_id=?, nombre=?, descripcion=?, precio=?, stock=?, fecha_ingreso=? WHERE id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getCategoriaId());
            ps.setInt(2, producto.getProveedorId());
            ps.setString(3, producto.getNombre());
            ps.setString(4, producto.getDescripcion());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setDate(7, new java.sql.Date(producto.getFechaIngreso().getTime()));
            ps.setInt(8, producto.getId());
            r = ps.executeUpdate();
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

    // Método para eliminar un producto por ID
    public void delete(int id) {
        String sql = "DELETE FROM Productos WHERE id=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
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