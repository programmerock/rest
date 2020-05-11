package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;

public class TestArticuloRepository {
    public static void main(String[] args) {
        I_ArticuloRepository ar= new ArticuloRepository(Connector.getConnection());
        System.out.println("Inicio del TestArticuloRepository\n");
        System.out.println("****************************\n");
        
        System.out.println("Ingreso 3 artículos 'remera blanca, camisa celeste "
                + "y pantalón negro' con el método save");
        Articulo articulo= new Articulo("Remera blanca", 70, 100, 200, 50, 500);
        ar.save(articulo);
        Articulo articulo2=new Articulo("Camisa celeste", 130, 200, 200, 50, 500);
        ar.save(articulo2);
        Articulo articulo3=new Articulo("Pantalón negro", 400, 200, 200, 50, 500);
        ar.save(articulo3);
        System.out.println(articulo+"\n"+articulo2+"\n"+articulo3);
        System.out.println("\n****************************\n");
        
        System.out.println("Recorro la lista de artículos con un foreach del método 'getAll'");
        ar.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Actualizo el stock de remeras a '250' con el método 'update'");
        articulo.setStock(250);
        ar.update(articulo);
        System.out.println(articulo);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco el registro de id:2 con el método 'getById'");
        System.out.println(ar.getById(2));
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros que contengan la palabra 'negro' con el método 'getLike");
        ar.getLikeDescripcion("negro").forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros que tengan en sotck 200 unidades con el método 'getByStock");
        ar.getByStock(200).forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Elimino el registro de id:3 con el método 'remove'");
        ar.remove(ar.getById(3));
        ar.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Fin del TestArticuloRepository");
    }
}
