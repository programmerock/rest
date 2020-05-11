package ar.org.centro8.curso.java.aplicaciones.dao.jdbc;

import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements I_FacturaRepository{
    private Connection conn;
    public FacturaRepository(Connection conn){this.conn=conn;}

    @Override
    public void save(Factura factura) {
        if(factura==null) return;
        try (PreparedStatement ps=conn.prepareStatement("insert into facturas "
                + "(letra,numero,fecha,monto,idCliente) values(?,?,?,?,?)"
                ,PreparedStatement.RETURN_GENERATED_KEYS)){
         ps.setString(1, factura.getLetra().toString());
         ps.setInt(2, factura.getNumero());
         ps.setString(3, factura.getFecha());
         ps.setDouble(4, factura.getMonto());
         ps.setInt(5, factura.getIdCliente());
         ps.execute();
         ResultSet rs=ps.getGeneratedKeys();
         if(rs.next()) factura.setId(rs.getInt(1));
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void remove(Factura factura) {
        if(factura==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from facturas where id=?")){
            ps.setInt(1, factura.getId());
            ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public void update(Factura factura) {
        if(factura==null) return;
        try (PreparedStatement ps=conn.prepareStatement("update facturas set "
                + "letra=?, numero=?, fecha=?, monto=?, idCliente=? where id=?")){
          ps.setString(1, factura.getLetra().toString());
          ps.setInt(2, factura.getNumero());
          ps.setString(3, factura.getFecha());
          ps.setDouble(4, factura.getMonto());
          ps.setInt(5, factura.getIdCliente());
          ps.setInt(6, factura.getId());
          ps.execute();
        } catch (Exception e) {e.printStackTrace();}
    }

    @Override
    public List<Factura> getAll() {
        List<Factura> lista=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from facturas")){
            while(rs.next()){
                lista.add(
                    new Factura(
                            rs.getInt("id"),
                            Letra.valueOf(rs.getString("letra")),
                            rs.getInt("numero"),
                            rs.getString("fecha"),
                            rs.getDouble("monto"),
                            rs.getInt("idCliente")));
            }
        } catch (Exception e) {e.printStackTrace();}
        return lista;
    }
    
}
