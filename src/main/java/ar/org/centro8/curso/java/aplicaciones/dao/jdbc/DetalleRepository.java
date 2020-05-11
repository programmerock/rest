package ar.org.centro8.curso.java.aplicaciones.dao.jdbc;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_DetalleRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleRepository implements I_DetalleRepository{
    private Connection conn;
    public DetalleRepository(Connection conn) {this.conn = conn;}   

    @Override
    public void save(Detalle detalle) {
        if(detalle==null) return;
        try (PreparedStatement ps=conn.prepareStatement("insert into detalles (idFactura,idArticulo,precio,cantidad)"
                + "values(?,?,?,?)")){
            ps.setInt(1, detalle.getIdFactura());
            ps.setInt(2, detalle.getIdArticulo());
            ps.setFloat(3, detalle.getPrecio());
            ps.setInt(4, detalle.getCantidad());
            ps.execute();
        } catch (Exception e) {
        }
    }

    @Override
    public void remove(Detalle detalle) {
        if(detalle==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from detalles where idFactura=? and idArticulo=?")){
        ps.setInt(1, detalle.getIdFactura());
        ps.setInt(2, detalle.getIdArticulo());
        ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Detalle detalle) {
        if(detalle==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update detalles set precio=?,cantidad=? "
                + "where idFactura=? and idArticulo=?")){
        ps.setFloat(1, detalle.getPrecio());
        ps.setInt(2, detalle.getCantidad());
        ps.setInt(3, detalle.getIdFactura());
        ps.setInt(4, detalle.getIdArticulo());
        ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public List<Detalle> getAll() {
        List<Detalle> lista=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from detalles")){
            while(rs.next()) {
                lista.add(
                        new Detalle(
                                rs.getInt("idFactura"),
                                rs.getInt("idArticulo"),
                                rs.getFloat("precio"),
                                rs.getInt("cantidad")
                                )
                );
            }
        } catch (Exception e) {e.printStackTrace();}
        return lista;
    }    
}
