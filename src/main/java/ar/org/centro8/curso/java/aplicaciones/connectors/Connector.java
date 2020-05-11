package ar.org.centro8.curso.java.aplicaciones.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String vendor="mysql";
    private static String server="localhost";
    private static String port="3306";
    private static String database="negocioWeb";
    private static String params="?serverTimezone=UTC";
    private static String user="root";
    private static String pass="centro8";
    private static String url="jdbc:"+vendor+"://"+server+":"+port+"/"+database+params;
    
    // Prueba en base remota para corroborar que la base corra sobre Linux
//    private static String driver="com.mysql.cj.jdbc.Driver";
//    private static String vendor="mysql";
//    private static String server="remotemysql.com";
//    private static String port="3306";
//    private static String database="6spfXUpgZN";
//    private static String params="";
//    private static String user="6spfXUpgZN";
//    private static String pass="DvWRZDvTXn";
//    private static String url="jdbc:"+vendor+"://"+server+":"+port+"/"+database+params;
    
    private static Connection conn=null;
    private Connector(){}
    public synchronized static Connection getConnection(){
        try{
            if(conn==null || conn.isClosed()){
                try {
                    Class.forName(driver);
                    conn=DriverManager.getConnection(url, user, pass);
                } catch (Exception e) {e.printStackTrace();}
            }
        }catch (Exception e) {e.printStackTrace();}        
        return conn;
    }
    
}
