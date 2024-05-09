package com.utp.modamovil.modelo;

public class Usuario extends Entidad {
    private String nombre;
    private String contrasena;
    
    public Usuario() {
        
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getContrasena() {
        return this.contrasena;
    }
}
