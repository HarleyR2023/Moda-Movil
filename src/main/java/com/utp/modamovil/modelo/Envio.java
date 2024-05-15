package com.utp.modamovil.modelo;

public class Envio extends Entidad {
    private Venta venta;
    private String tipoEnvio;
    
    public Envio() {
    }

    public Venta getVenta() {
        return this.venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getTipoEnvio() {
        return this.tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }
}
