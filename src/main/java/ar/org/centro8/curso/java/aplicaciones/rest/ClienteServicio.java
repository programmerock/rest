package ar.org.centro8.curso.java.aplicaciones.rest;


import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("clientes/v1")
public class ClienteServicio {
    @GET
    public String info(){
        return "Servicio de clientes activo";
    }
    /*
    http://localhost:8080/Server/clientes/v1/alta?nombre=Juan&apellido=perez&tipoDocumento=DNI&numeroDocumento=90909091&direcion=medrano162&comentarios=null
    */
    @GET
    @Path("alta")
    public String alta(@QueryParam("nombre")String nombre,
            @QueryParam("apellido")String apellido,
            @QueryParam("tipoDocumento")String tipoDocumento,
            @QueryParam("numeroDocumento")String numeroDocumento,
            @QueryParam("direccion")String direccion,
            @QueryParam("comentarios")String comentarios
    ){
        ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        Cliente cliente=new Cliente(
                nombre,
                apellido,
                TipoDocumento.valueOf(tipoDocumento),
                Integer.parseInt(numeroDocumento),
                direccion,
                comentarios
        );
        cr.save(cliente);
        return cliente.getId()+"";
    }
    
    
    
    
    @GET
    @Path("baja")
    public String baja(@QueryParam("id")String id){
        try {
            ClienteRepository cr=new ClienteRepository(Connector.getConnection());
            cr.remove(cr.getById(Integer.parseInt(id)));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
    
    
    
    @GET
    @Path("all")
    public String getAll(){
        String text="";
        ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        for(Cliente c:cr.getAll()) text+=c+"\n";
        return text;
    }
    
    
    
    @GET
    @Path("likeApellido")
    public String getLikeApellido(@QueryParam("apellido") String apellido){
        String text="";
        ClienteRepository cr=new ClienteRepository(Connector.getConnection());
        for(Cliente c: cr.getLikeApellido(apellido)) text+=c+"\n";
        return text;
    }
}
