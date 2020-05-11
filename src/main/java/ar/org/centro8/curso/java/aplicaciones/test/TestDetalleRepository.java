package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_DetalleRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.DetalleRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;

public class TestDetalleRepository {
    public static void main(String[] args) {
        I_DetalleRepository dr=new DetalleRepository(Connector.getConnection());
        System.out.println("Inicio del TestDetalleRepository");
        System.out.println("\n****************************\n");
        
        System.out.println("ingreso 3 nuevos detalles con el método 'save'");
        Detalle detalle = new Detalle(1, 1, 12.65f, 3);
        dr.save(detalle);
        Detalle detalle2 = new Detalle(2, 1, 22.44f, 5);
        dr.save(detalle2);
        Detalle detalle3 = new Detalle(2, 2, 100, 12);
        dr.save(detalle3);
        System.out.println(detalle+"\n"+detalle2+"\n"+detalle3);
        System.out.println("\n****************************\n");
        
        System.out.println("Actualizo la cantidad a '10' en el registro "
                + "idFactura=1 idArticulo=1 con el método 'update'");
        detalle.setCantidad(10);
        dr.update(detalle);
        System.out.println(detalle);
        System.out.println("\n****************************\n");
        
        System.out.println("Recorro la lista con un foreach del método 'getAll'");
        dr.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros de idFacturas=2 con el método 'getByIdFactura'");
        dr.getByIdFactura(2).forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros de idArticulo=1 con el método 'getByIdArticulo'");
        dr.getByIdArticulo(1).forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco el registro de idFactura=1 y idArticulo=1 con el método 'getByIdFacturaIdArticulo'");
        System.out.println(dr.getByIdFacturaIdArticulo(1, 1));
        System.out.println("\n****************************\n");
        
        System.out.println("Elimino el registro de idFactura:2 idArticulo:2 con el método 'remove'");
        dr.remove(dr.getByIdFacturaIdArticulo(2, 2));
        dr.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Fin de TestDetalleRepository");
    }
}
