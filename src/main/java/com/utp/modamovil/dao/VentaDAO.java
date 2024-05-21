package com.utp.modamovil.dao;

import com.utp.modamovil.Conexion;
import com.utp.modamovil.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class VentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    // Método para agregar una nueva venta
    public int agregar(Venta venta) {
        int ventaId = 0;
        String sql = "INSERT INTO Ventas(usuario_id, fecha, total, metodo_pago, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getUsuarioId());
            ps.setDate(2, new java.sql.Date(venta.getFecha().getTime()));
            ps.setDouble(3, venta.getTotal());
            ps.setString(4, venta.getMetodoPago());
            ps.setString(5, venta.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ventaId = rs.getInt(1);
            }
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
        return ventaId;
    }
}
