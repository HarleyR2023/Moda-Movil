package com.utp.modamovil;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/modamovil";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static Connection conexion;
    
    public BaseDatos() {
        
    }
    
    private static void crearConexion() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conexion = connection;
        }
        catch (Exception e) {
            System.out.println("Error: No se logro establecer una conexión con la base de datos.\n" + e);
        }
    }
    
    public static Connection getConexion() {
        if (conexion == null) {
            crearConexion();
        }
        return conexion;
    }
}
