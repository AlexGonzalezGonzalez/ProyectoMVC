/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cod_mvc2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudios
 */
public class Modelo {

    boolean conectado;
    DatabaseMetaData meta;
    Connection conn;

    public Modelo() {

    }

    public boolean conectarse() {
        try {
            String url = "jdbc:sqlite:C:\\Users\\estudios\\Desktop\\BaseDatosSQLite\\BaseCod.db";
            conn = DriverManager.getConnection(url);

            if (conn != null) {

                meta = conn.getMetaData();
                conectado = true;

            } else {
                conectado = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectado;
    }

    public boolean insert(int id, String nombre) {

        try {
            conectarse();
            PreparedStatement st = conn.prepareStatement("insert into Persona VALUES('" + id + "','" + nombre + "');");
            st.execute();
            st.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public ArrayList mostrar() {
        conectarse();
        ArrayList lista= new ArrayList();
        String ejec = "select * from Persona";

        if (conn != null) {
            try {
                
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(ejec);

                while (rs.next()) {
                    lista.add(rs.getString(1));
                    lista.add(rs.getString(2));
                }
                st.close();
                rs.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
return lista;
    }

    public DatabaseMetaData getMeta() {
        return meta;
    }

    public void setMeta(DatabaseMetaData meta) {
        this.meta = meta;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

}
