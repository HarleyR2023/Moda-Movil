package com.utp.modamovil.dao;

import com.utp.modamovil.Conexion;
import com.utp.modamovil.modelo.Envio;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnvioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    int r;

    public int agregar(Envio envio) {
        String sql = "INSERT INTO Envio(venta_id, tipo_envio) VALUES (?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, envio.getVentaId());
            ps.setString(2, envio.getTipoEnvio());
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
}
