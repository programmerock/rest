package ar.org.centro8.curso.java.aplicaciones.entities;

import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private int numeroDocumento;
    private String direccion;
    private String comentarios;

    public Cliente() {}

    public Cliente(int id, String nombre, String apellido, TipoDocumento tipoDocumento, 
            int numeroDocumento, String direccion, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.comentarios = comentarios;
    }

    public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, int numeroDocumento,
            String direccion, String comentarios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento=" 
                + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", direccion=" + direccion 
                + ", comentarios=" + comentarios + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
    
    
    
    
}
