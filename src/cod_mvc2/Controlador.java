/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cod_mvc2;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author estudios
 */
public class Controlador {

    ArrayList lista;
    DefaultTableModel tm;
    Modelo modelo = new Modelo();

    public boolean crearBase() {
        return modelo.conectarse();

    }

    public boolean insert(int id, String nombre) {

        return modelo.insert(id, nombre);

    }

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
