package ar.org.centro8.curso.java.aplicaciones.entities;
public class Articulo {
    private int id;
    private String descripcion;
    private float costo;
    private float precio;
    private int stock;
    private int stockMin;
    private int stockMax;

    public Articulo() {}

    public Articulo(int id, String descripcion, float costo, float precio, 
            int stock, int stockMin, int stockMax) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
    }

    public Articulo(String descripcion, float costo, float precio, int stock, 
            int stockMin, int stockMax) {
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", descripcion=" + descripcion + ", costo=" 
                + costo + ", precio=" + precio + ", stock=" + stock + ", stockMin=" + stockMin 
                + ", stockMax=" + stockMax + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStockMax() {
        return stockMax;
    }

    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }
    
    
}
