/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista1;

import Persona.Alumno;
import Persona.Horario;
import Persona.HorarioPersona;
import Persona.Materia;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author rockm
 */
public class HorarioAlumnoVistaController implements Initializable {
    
    
    //inicializacion botones
    @FXML private Button aniadir;
    @FXML private Button borrar;
    //inicializacion text fields
    //inicializacion tablas y colunas
    @FXML private TableView<HorarioPersona> horarioTV;
    @FXML private TableColumn materiaTC;
    @FXML private TableColumn lunesTC;
    @FXML private TableColumn martesTC;
    @FXML private TableColumn miercolesTC;
    @FXML private TableColumn juevesTC;
    @FXML private TableColumn viernesTC;
    @FXML private TableColumn sabadoTC;
    @FXML private TableColumn domingoTC;
    @FXML private TableView<HorarioPersona> horarioTV2;
    @FXML private TableColumn materiaTC2;
    @FXML private TableColumn lunesTC2;
    @FXML private TableColumn martesTC2;
    @FXML private TableColumn miercolesTC2;
    @FXML private TableColumn juevesTC2;
    @FXML private TableColumn viernesTC2;
    @FXML private TableColumn sabadoTC2;
    @FXML private TableColumn domingoTC2;
    //inicializacion extras
    ObservableList<HorarioPersona> horarios;
    ObservableList<HorarioPersona> horarios2;
    private int posicionHorarioPersonaEnTabla;
    private int posicionHorarioPersonaEnTabla2;
    @FXML
    private Font x1;

    
    
    /**
     * Listener de la tabla horarios
     */
    private final ListChangeListener<HorarioPersona> selectorTablaHorarioPersona =
            new ListChangeListener<HorarioPersona>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends HorarioPersona> c) {
                    try {
                        ponerHorarioPersonaSeleccionado();
                    } catch (SQLException ex) {
                        Logger.getLogger(MateriasVistaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
    @FXML
    private TableColumn nrcTC;
    @FXML
    private TableColumn nrcTC2;
    @FXML
    private TextField alumnoTF;
    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    
    public HorarioPersona getTablaHorarioPersonaSeleccionado() {
        if (horarioTV != null) {
            List<HorarioPersona> tabla = horarioTV.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final HorarioPersona competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerHorarioPersonaSeleccionado() throws SQLException {
        final HorarioPersona horario = getTablaHorarioPersonaSeleccionado();
        posicionHorarioPersonaEnTabla = horarios.indexOf(horario);

        if (horario != null) {

            /*// Pongo los textFields con los datos correspondientes
            nombreTF.setText(materia.getNombre());
            nrcTF.setText(materia.getNrc());
            horasTeoricasTF.setText(String.valueOf(materia.getHoras1()));
            horasPracticasTF.setText(String.valueOf(materia.getHoras2()));
            creditosTF.setText(String.valueOf(materia.getCreditos()));

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);*/

        }
        //Integer xd;
        //this.cargarMaterias(horarios.get(posicionHorarioPersonaEnTabla).getNombre());
        //xd = new Integer(posicionHorarioPersonaEnTabla);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.inicializarTablaHorariosPersona();
        this.inicializarTablaHorariosPersona2();
        System.out.println("problema antes");
        cargarHorariosGenerales();
        System.out.println(" problema despues");
        final ObservableList<HorarioPersona> tablaPersonaSel = horarioTV.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaHorarioPersona);
        // Inicializamos la tabla de horarios
        final ObservableList<HorarioPersona> tablaPersonaSe2 = horarioTV.getSelectionModel().getSelectedItems();
        tablaPersonaSe2.addListener(selectorTablaHorarioPersona);
        
            ///////////////////////////////////////////////////////////////////
    }    
    private void inicializarTablaHorariosPersona() {
        materiaTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("materia"));
        lunesTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("lunes"));
        martesTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("martes"));
        miercolesTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("miercoles"));
        juevesTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("jueves"));
        viernesTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("viernes"));
        sabadoTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("sabado"));
        domingoTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("domingo"));
        nrcTC.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("nrc"));
        

        horarios = FXCollections.observableArrayList();
        horarioTV.setItems(horarios);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
        /**
     * Listener de la tabla horarios2
     */
    private final ListChangeListener<HorarioPersona> selectorTablaHorarioPersona2 =
            new ListChangeListener<HorarioPersona>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends HorarioPersona> c) {
                    try {
                        ponerHorarioPersonaSeleccionado2();
                    } catch (SQLException ex) {
                        Logger.getLogger(MateriasVistaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    
    public HorarioPersona getTablaHorarioPersonaSeleccionado2() {
        if (horarioTV2 != null) {
            List<HorarioPersona> tabla = horarioTV2.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final HorarioPersona competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerHorarioPersonaSeleccionado2() throws SQLException {
        final HorarioPersona horario2 = getTablaHorarioPersonaSeleccionado();
        posicionHorarioPersonaEnTabla2 = horarios2.indexOf(horario2);

        if (horario2 != null) {

            /*// Pongo los textFields con los datos correspondientes
            nombreTF.setText(materia.getNombre());
            nrcTF.setText(materia.getNrc());
            horasTeoricasTF.setText(String.valueOf(materia.getHoras1()));
            horasPracticasTF.setText(String.valueOf(materia.getHoras2()));
            creditosTF.setText(String.valueOf(materia.getCreditos()));

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);*/

        }
        //Integer xd;
        //this.cargarMaterias(horarios.get(posicionHorarioPersonaEnTabla).getNombre());
        //xd = new Integer(posicionHorarioPersonaEnTabla);
    }
    
    /**
     * Initializes the controller class.
     */
    /*@Override*/
    /*public void initialize(URL url, ResourceBundle rb) {
        //inicializacion de las tablas
    } */   
    private void inicializarTablaHorariosPersona2() {
        materiaTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("materia"));
        lunesTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("lunes"));
        martesTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("martes"));
        miercolesTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("miercoles"));
        juevesTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("jueves"));
        viernesTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("viernes"));
        sabadoTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("sabado"));
        domingoTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("domingo"));
        nrcTC2.setCellValueFactory(new PropertyValueFactory<HorarioPersona, String>("nrc"));
        

        horarios2 = FXCollections.observableArrayList();
        horarioTV2.setItems(horarios2);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void aniadir(ActionEvent event) throws SQLException {
        
    }

    @FXML
    private void borrar(ActionEvent event) {
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    private void cargarHorariosGenerales(){
    horarios.clear();
    SqlHorario sqlHorariosMaterias= new SqlHorario();
    SqlMateria sqlMaterias= new SqlMateria();
    //Primero obtenemos los ID de todas las materias que tienen horarios.
    List<String> listaIDMaterias = null;
    System.out.println("1");
    try {
      listaIDMaterias = sqlHorariosMaterias.consultarIDMaterias();
    } catch (SQLException ex) {
      Logger.getLogger(MateriasVistaController.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("2");
    Iterator<String> it = listaIDMaterias.iterator();
    //Vamos obteniendo lo necesario de cada materia y sus horarios.
    while (it.hasNext()) {
      int idmateria = Integer.parseInt(it.next());
      //Después consultamos los datos necesarios de la materia, que son nombre y NRC.
      List<String> listaMateria = null;
      try {
        listaMateria = sqlMaterias.consultarMateria(idmateria);
      } catch (SQLException ex) {
        Logger.getLogger(MateriasVistaController.class.getName()).log(Level.SEVERE, null, ex);
      }
      System.out.println("3");
      Iterator<String> it2 = listaMateria.iterator();
      //Luego consultamos los datos de los horarios.
      List<String> listaHorariosMaterias = null;
      try {
        listaHorariosMaterias = sqlHorariosMaterias.consultarHorariosMaterias(idmateria);
      } catch (SQLException ex) {
        Logger.getLogger(MateriasVistaController.class.getName()).log(Level.SEVERE, null, ex);
      }
      //System.out.println("nueva prueba");
      //System.out.println(it2.next());
      //System.out.println(it2.next());
      //System.out.println(it2.next());
      //System.out.println("4");
      Iterator<String> it3 = listaHorariosMaterias.iterator();
      System.out.println("4.1");
      //Empezamos a llenar los horarios.
      HorarioPersona horarioMateria = new HorarioPersona();
      System.out.println("4.2");
      horarioMateria.materia.set(it2.next());
      System.out.println("4.3");
      horarioMateria.nrc.set(it2.next());
      System.out.println("5");
      while (it3.hasNext()) {
        it3.next();
        it3.next();
        String dia =it3.next();
        if (dia.equals("1")){
          horarioMateria.lunes.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
        } else {
          if (dia.equals("2")){
            horarioMateria.martes.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
          } else {
            if (dia.equals("3")){
              horarioMateria.miercoles.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
            } else {
              if (dia.equals("4")){
                horarioMateria.jueves.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
              } else {
                if (dia.equals("5")){
                  horarioMateria.viernes.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
                } else {
                  if (dia.equals("6")){
                    horarioMateria.sabado.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
                  } else {
                    horarioMateria.domingo.set(it3.next()+"  |  "+it3.next()+" - "+it3.next());
                  }
                }
              }
            }
          }
        }
      }
      System.out.println("6");
      horarios.add(horarioMateria);
      System.out.println("7");
    }
  
    }//fin del metodo

    void recibeP(VistaController con1, String nombre) {
        alumnoTF.setText(nombre);
        alumnoTF.setEditable(false);
        System.out.println(alumnoTF.getText());
        String xd="456|759|725";
        String[] parts = xd.split("|");
        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321
        String part3 = parts[2]; // 654321
        System.out.println("las partes son: parte1: "+part1+" parte 2: "+part2+"parte 3"+part3);
    }
    
}//fin de la clase