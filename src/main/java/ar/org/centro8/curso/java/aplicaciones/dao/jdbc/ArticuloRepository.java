package ar.org.centro8.curso.java.aplicaciones.dao.jdbc;

import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository implements I_ArticuloRepository{
    private Connection conn;
    public ArticuloRepository(Connection conn) { this.conn = conn; }

    @Override
    public void save(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into articulos "
                        + "(descripcion,costo,precio,stock,stockMin,stockMax) "
                        + "values (?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)
            ) {
            ps.setString(1, articulo.getDescripcion());
            ps.setFloat(2, articulo.getCosto());
            ps.setDouble(3, articulo.getPrecio());
            ps.setInt(4, articulo.getStock());
            ps.setInt(5, articulo.getStockMin());
            ps.setInt(6, articulo.getStockMax());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) articulo.setId(rs.getInt(1));
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void remove(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from articulos where id=?")){
            ps.setInt(1, articulo.getId());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Articulo articulo) {
        if(articulo==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update articulos set descripcion=?, costo=?, "
                + "precio=?,stock=?,stockMin=?,stockMax=? where id=?")){
            ps.setString(1, articulo.getDescripcion());
            ps.setFloat(2, articulo.getCosto());
            ps.setFloat(3, articulo.getPrecio());
            ps.setInt(4, articulo.getStock());
            ps.setInt(5, articulo.getStockMin());
            ps.setInt(6, articulo.getStockMax());
            ps.setInt(7, articulo.getId());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo> lista= new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from articulos")){
            while(rs.next()){
                lista.add(
                        new Articulo(
                                rs.getInt("id"),
                                rs.getString("descripcion"), 
                                rs.getFloat("costo"), 
                                rs.getFloat("precio"), 
                                rs.getInt("stock"), 
                                rs.getInt("stockMin"), 
                                rs.getInt("stockMax")
                        ));                
            }               
        } catch (Exception e) {e.printStackTrace();}
        return lista;
    }    
}
