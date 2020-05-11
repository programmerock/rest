package ar.org.centro8.curso.java.aplicaciones.dao.jdbc;

import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements I_ClienteRepository{
    private Connection conn;
    public ClienteRepository(Connection conn) { this.conn = conn; }  

    @Override public void save(Cliente cliente) {
        if (cliente==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into clientes "
                        + "(nombre,apellido,tipoDocumento,numeroDocumento,direccion,comentarios) "
                        + "values (?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)
            ) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTipoDocumento().toString());
            ps.setInt(4, cliente.getNumeroDocumento());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getComentarios());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) cliente.setId(rs.getInt(1));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void remove(Cliente cliente) {
        if(cliente==null) return;
        try(PreparedStatement ps=conn.prepareStatement("delete from clientes where id=?"))
        {
            ps.setInt(1, cliente.getId());
            ps.execute();            
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Cliente cliente) {
        if(cliente==null) return;
        try(PreparedStatement ps=conn.prepareStatement("update clientes set nombre=?, apellido=?, "
                + "tipoDocumento=?, numeroDocumento=?, direccion=?, comentarios=? where id=?")) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTipoDocumento().toString());
            ps.setInt(4, cliente.getNumeroDocumento());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getComentarios());
            ps.setInt(7, cliente.getId());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override public List<Cliente> getAll() {
        List<Cliente>lista=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from clientes")){
            while(rs.next()){
                lista.add(
                        new Cliente(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                TipoDocumento.valueOf(rs.getString("tipoDocumento")),
                                rs.getInt("numeroDocumento"),
                                rs.getString("direccion"),
                                rs.getString("comentarios")
                        )
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
}
