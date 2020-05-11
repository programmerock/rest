package ar.org.centro8.curso.java.aplicaciones.entities;

import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import java.text.DecimalFormat;

public class Factura {
    private int id;
    private Letra letra;
    private int numero;
    private String fecha;
    private double monto;
    private int idCliente;
    
    DecimalFormat df=new DecimalFormat(".00");

    public Factura() {
    }

    public Factura(int id, Letra letra, int numero, String fecha, double monto, int idCliente) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    public Factura(Letra letra, int numero, String fecha, double monto, int idCliente) {
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", letra=" + letra + ", numero=" 
                + numero + ", fecha=" + fecha + ", monto=" + df.format(monto) + ", idCliente=" + idCliente + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
