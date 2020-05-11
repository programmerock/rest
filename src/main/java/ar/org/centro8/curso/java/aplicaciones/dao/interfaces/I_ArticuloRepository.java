package ar.org.centro8.curso.java.aplicaciones.dao.interfaces;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ArticuloRepository {
    void save(Articulo articulo);
    void remove(Articulo articulo);
    void update (Articulo articulo);
    List<Articulo>getAll();
    default Articulo getById(int id){
        return getAll()
                .stream()
                .filter(a->a.getId()==id)
                .findFirst()
                .orElse(new Articulo());
    }
    default List<Articulo>getLikeDescripcion(String descripcion){
        if(descripcion==null) return new ArrayList<Articulo>();
        return getAll()
                .stream()
                .filter(a->a.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                .collect(Collectors.toList());                
    }
    default List<Articulo>getByStock(int stock){
        return getAll()
                .stream()
                .filter(a->a.getStock()==stock)
                .collect(Collectors.toList());
    }
}
