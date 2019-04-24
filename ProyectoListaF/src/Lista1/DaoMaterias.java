/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista1;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rockm
 */
public interface DaoMaterias {
    public List<String> getDatos2() throws SQLException;
    public int borrarDatos2() throws SQLException;
    public int agregarDatos2(String nombre,String nrc,int horas1,int horas2,int creditos) throws SQLException;
    public String sacarNombre(int idMateria) throws SQLException;
}
