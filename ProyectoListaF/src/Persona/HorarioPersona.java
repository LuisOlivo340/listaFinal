
package Persona;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Luis Angel Olivo Martinez
 */
public class HorarioPersona {
    public SimpleIntegerProperty idHorario=new SimpleIntegerProperty();
    public SimpleStringProperty matricula=new SimpleStringProperty();
    public SimpleStringProperty materia=new SimpleStringProperty();
    public SimpleStringProperty lunes=new SimpleStringProperty();
    public SimpleStringProperty martes=new SimpleStringProperty();
    public SimpleStringProperty miercoles=new SimpleStringProperty();
    public SimpleStringProperty jueves=new SimpleStringProperty();
    public SimpleStringProperty viernes=new SimpleStringProperty();
    public SimpleStringProperty sabado=new SimpleStringProperty();
    public SimpleStringProperty domingo=new SimpleStringProperty();
    public SimpleStringProperty nrc=new SimpleStringProperty();

    public String getMateria() {
        return materia.get();
    }

    public String getLunes() {
        return lunes.get();
    }

    public String getMartes() {
        return martes.get();
    }

    public String getMiercoles() {
        return miercoles.get();
    }

    public String getJueves() {
        return jueves.get();
    }

    public String getViernes() {
        return viernes.get();
    }

    public String getSabado() {
        return sabado.get();
    }

    public String getDomingo() {
        return domingo.get();
    }

    public Integer getIdHorario() {
        return idHorario.get();
    }

    public String getMatricula() {
        return matricula.get();
    }
    
    
}//21 30 29 30
