/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cod_mvc2;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * clase controlador que se encarga del envio de datos entre la vista y el modelo
 * @author estudios
 */
public class Controlador {

    ArrayList lista;
    DefaultTableModel tm;
    Modelo modelo = new Modelo();

    /**
     * metodo que se encarga de la conexion de la base y retorna un boolean si se hizo correctamente
     * @return Si se conecta retorna true
     */
    public boolean crearBase() {
        return modelo.conectarse();

    }

    /**
     * Metodo que se encarga de realizar el insert de la clase modelo y recibe los datos de la vista
     * @param id
     * @param nombre
     * @return true si se realizo correctamente
     */
    public boolean insert(int id, String nombre) {

        return modelo.insert(id, nombre);

    }

    /**
     * metodo que se encarga de actualizar actualizar el modelo de la tabla para actualizar datos en ella
     * @return modelo de la tabla actualizado
     */
    public DefaultTableModel mostrar() {
        tm = new DefaultTableModel();
        lista = modelo.mostrar();
        tm.addColumn("ID");
        tm.addColumn("Nombre");
        for (int i = 0; i < lista.size(); i++) {
            ArrayList lista2 = new ArrayList();
            for (int j = 0; j < 2; j++) {
                lista2.add(lista.get(i));
                i++;
            }
            i--;
            tm.addRow(lista2.toArray());
        }
        return tm;
    }
}
