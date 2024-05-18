package com.utp.modamovil.dao;

public abstract class CrudRepositorio<T> implements Repositorio<T> {
    
    public CrudRepositorio() {
    }
    
    public abstract void actualizar(T entidad);
    
    public abstract void eliminar(int id);
}
