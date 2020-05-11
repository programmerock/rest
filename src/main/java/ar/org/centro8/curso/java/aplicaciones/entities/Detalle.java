package ar.org.centro8.curso.java.aplicaciones.entities;
public class Detalle {
    private int idFactura;
    private int idArticulo;
    private float precio;
    private int cantidad;

    public Detalle() {
    }

    public Detalle(int idFactura, int idArticulo, float precio, int cantidad) {
        this.idFactura = idFactura;
        this.idArticulo = idArticulo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Detalle{" + "idFactura=" + idFactura + ", idArticulo=" + idArticulo 
                + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
