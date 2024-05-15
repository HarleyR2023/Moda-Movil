package com.utp.modamovil;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    public static final BaseDatos INSTANCE = new BaseDatos();
    
    private static final String URL = "jdbc:mysql://localhost:3309/modamovil";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conexion;
    
    public BaseDatos() {
        
    }
    
    public void crearConexion() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            this.conexion = connection;
        }
        catch (Exception e) {
            
        }
    }
    
    public Connection getConexion() {
        return this.conexion;
    }

}
