package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;

public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connector
                .getConnection()
                .createStatement()
                .execute("delete from clientes where numeroDocumento='12345678'");
        Connector
                .getConnection()
                .createStatement()
                .execute(
                        "insert into clientes "
                        + "(nombre, apellido, tipoDocumento, numeroDocumento, direccion)"
                        + "values "
                        + "('Ana','Soto','DNI','12345678','Medrano 182')"
                );

    }
}
