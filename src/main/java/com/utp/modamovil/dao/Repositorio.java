package com.utp.modamovil.dao;

import java.util.Optional;

public interface Repositorio<T> {
    public abstract void guardar(T entidad);
    
    public abstract Optional<T> buscar(int id);
    
    public default boolean existe(int id) {
        return this.buscar(id).isPresent();
    }
}
