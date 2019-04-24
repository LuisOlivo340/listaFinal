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
public interface DaoHorario {
    public List<String> getDatos2() throws SQLException;
    public int borrarDatos2() throws SQLException;
    public int agregarDatos2(int idMateria,String salon,int dia,String horaInicio,String horaFin) throws SQLException;
}
