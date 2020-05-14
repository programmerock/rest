package ar.org.centro8.curso.java.aplicaciones.rest;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/articulos/v1")
public class ArticuloServicio {
    @GET
    public String info(){
        return "Servicio de artículos activo";
    }
    @GET
    @Path("alta")
    public String alta(
            @QueryParam("descripcion") String descripcion,
            @QueryParam("costo") String costo,
            @QueryParam("precio") String precio,
            @QueryParam("stock") String stock,
            @QueryParam("stockMin") String stockMin,
            @QueryParam("stockMax") String stockMax
    ){
        ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
        Articulo articulo=new Articulo(
                descripcion,
                Float.parseFloat(costo),
                Float.parseFloat(precio),
                Integer.parseInt(stock),
                Integer.parseInt(stockMin),
                Integer.parseInt(stockMax)
        );
        ar.save(articulo);
        return articulo.getId()+"";        
    }
    
    
    @GET
    @Path("baja")
    public String baja(@QueryParam("id") String id){
        try {
            ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
            ar.remove(ar.getById(Integer.parseInt(id)));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
    
    @GET
    @Path("getAll")
    public String getAll(){
        String text="";
        ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
        for(Articulo a:ar.getAll()) text+=a+"\n";
        return text;
    }
    
    
    @GET
    @Path("getLikeDescripcion")
    public String getLikeDescripcion(@QueryParam("descripcion") String descripcion){
        String text="";
        ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
        for(Articulo a:ar.getLikeDescripcion(descripcion)) text+=a+"\n";
        return text;
    }
}
