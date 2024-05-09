package com.utp.modamovil.modelo;

public abstract class Entidad {
    private int id;
    
    public Entidad() {
        
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
