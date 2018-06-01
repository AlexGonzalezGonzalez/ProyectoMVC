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
 *Clase modelo encargada de los datos de la base
 * @author estudios
 */
public class Modelo {

    boolean conectado;
    DatabaseMetaData meta;
    Connection conn;

    /**
     *Constructor por defecto
     */
    public Modelo() {

    }

    /**
     *metodo que se conecta a la base
     * @return retorna un boolean dependiendo si se ha conectado o no
     */
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

    /**
     * metodo que se encarga de hacer los inserts en la base de datos
     * @param id
     * @param nombre
     * @return
     */
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

    /**
     *metodo que se encarga de mostrar los datos de la tabla
     * @return un arraylist con los datos de la tabla
     */
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

    /**
     *getter de meta
     * @return
     */
    public DatabaseMetaData getMeta() {
        return meta;
    }

    /**
     *setter de meta
     * @param meta
     */
    public void setMeta(DatabaseMetaData meta) {
        this.meta = meta;
    }

    /**
     * getter connexion
     * @return
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     *setter connexion
     * @param conectado
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    /**
     *getter conn
     * @return
     */
    public Connection getConn() {
        return conn;
    }

    /**
     *setter conn
     * @param conn
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

}
