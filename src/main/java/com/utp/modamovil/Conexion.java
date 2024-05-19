package com.utp.modamovil;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    
    Connection con;
    String url = "jdbc:mysql://localhost:3306/modamovil";
    String user = "root";
    String pass = "";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println("Conexion Mala " + e);
        }
        return con;
    }
    
}
