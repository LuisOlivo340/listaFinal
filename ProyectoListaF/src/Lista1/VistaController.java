package Lista1;

import Persona.Alumno;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Luis Angel Olivo Martinez
 */
public class VistaController implements Initializable {
    
    VistaController con1;
    // Declaramos los botones
    @FXML private Button aniadirBT;
    @FXML private Button modificarBT;
    @FXML private Button eliminarBT;
    @FXML private Button nuevoBT;
    
    // Declaramos los textfileds
    @FXML private TextField nombreTF;
    @FXML private TextField apellidoTF;
    @FXML private TextField edadTF;
    @FXML private TextField telefonoTF;
    
    // Declaramos la tabla y las columnas
    @FXML private TableView<Alumno> tablaPersonas;
    @FXML private TableColumn nombreCL;
    @FXML private TableColumn apellidoCL;
    @FXML private TableColumn edadCL;
    @FXML private TableColumn telefonoCL;
    ObservableList<Alumno> personas;
    
    private int posicionPersonaEnTabla;
    @FXML
    private Font x1;
    @FXML
    private Button cargarB;
    @FXML
    private Font x2;
    @FXML
    private Button guardarB;
    @FXML
    private Button salirB;
    @FXML
    private MenuBar menuMB;
    @FXML
    private Menu listasM;
    @FXML
    private MenuItem materiasMI;
    @FXML
    private Button agregarBT;

    /**
     * Método que realiza las acciones tras pulsar el boton "Nuevo"
     *
     * @param event
     */
    @FXML private void nuevo(ActionEvent event) {
        nombreTF.setText("");
        apellidoTF.setText("");
        edadTF.setText("");
        telefonoTF.setText("");
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        aniadirBT.setDisable(false);
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Añadir"
     *
     * @param event
     */
    @FXML private void aniadir(ActionEvent event) {
        Alumno persona = new Alumno();
        persona.nombre.set(nombreTF.getText());
        persona.apellidoP.set(apellidoTF.getText());
        persona.apellidoM.set(edadTF.getText());
        persona.matricula.set(telefonoTF.getText());
        personas.add(persona);
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Modificar"
     *
     * @param event
     */
    @FXML private void modificar(ActionEvent event) {
        Alumno persona = new Alumno();
        persona.nombre.set(nombreTF.getText());
        persona.apellidoP.set(apellidoTF.getText());
        persona.apellidoM.set(edadTF.getText());
        persona.matricula.set(telefonoTF.getText());
        personas.set(posicionPersonaEnTabla, persona);
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Eliminar"
     *
     * @param event
     */
    @FXML private void eliminar(ActionEvent event) {
        personas.remove(posicionPersonaEnTabla);
    }
    /**
     * Listener de la tabla personas
     */
    private final ListChangeListener<Alumno> selectorTablaPersonas =
            new ListChangeListener<Alumno>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Alumno> c) {
                    ponerPersonaSeleccionada();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Alumno getTablaPersonasSeleccionada() {
        if (tablaPersonas != null) {
            List<Alumno> tabla = tablaPersonas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Alumno competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerPersonaSeleccionada() {
        final Alumno persona = getTablaPersonasSeleccionada();
        posicionPersonaEnTabla = personas.indexOf(persona);

        if (persona != null) {

            // Pongo los textFields con los datos correspondientes
            nombreTF.setText(persona.getNombre());
            apellidoTF.setText(persona.getApellidoP());
            edadTF.setText(persona.getApellidoM());
            telefonoTF.setText(persona.getMatricula());

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }

    /**
     * Método para inicializar la tabla
     */
    private void inicializarTablaPersonas() {
        nombreCL.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
        apellidoCL.setCellValueFactory(new PropertyValueFactory<Alumno, String>("apellidoP"));
        edadCL.setCellValueFactory(new PropertyValueFactory<Alumno, Integer>("apellidoM"));
        telefonoCL.setCellValueFactory(new PropertyValueFactory<Alumno, String>("matricula"));

        personas = FXCollections.observableArrayList();
        tablaPersonas.setItems(personas);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Inicializamos la tabla
        this.inicializarTablaPersonas();

        // Ponemos estos dos botones para que no se puedan seleccionar
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Alumno> tablaPersonaSel = tablaPersonas.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);
        con1=this;

    }

    @FXML
    private void cargarA(MouseEvent event) {
        Sql sql=new Sql();
        personas.clear();
        List<String> listaDatos=null;
        try {
            listaDatos = sql.getDatos();//(3) metodo que manda a traer una lista de la consulta de las rentas de noviembre
        } catch (SQLException ex) {
            Logger.getLogger(VistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ObservableList<Alumno> tablaPersonaSel = tablaPersonas.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);
        Iterator<String> it = listaDatos.iterator();
        while(it.hasNext()){
            Alumno p1 = new Alumno();
            p1.matricula.set(it.next());
            p1.nombre.set(it.next());
            p1.apellidoP.set(it.next());
            p1.apellidoM.set(it.next());
            personas.add(p1);
        }
    }

    @FXML
    private void guardarA(MouseEvent event) throws SQLException {
        Sql sql=new Sql();
        sql.borrarDatos();
        //System.out.println(" dsc ");
        final ObservableList<Alumno> tablaPersonaSel = tablaPersonas.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);
        //TableView tbView=new TableView(tablaPersonaSel);
        List<String> datos=null;
        
        for (int i = 0; i < tablaPersonas.getItems().size(); i++){
            String matricula=(String) tablaPersonas.getItems().get(i).getMatricula();
            String nombre=(String) tablaPersonas.getItems().get(i).getNombre();
            String apellido1=(String) tablaPersonas.getItems().get(i).getApellidoP();
            String apellido2=(String) tablaPersonas.getItems().get(i).getApellidoM();
            int q=sql.agregarDatos(matricula,nombre,apellido1,apellido2);
            //Sql sql=new Sql();
        }
        
    }

    @FXML
    private void salirA(MouseEvent event) {
    }

    @FXML
    private void listadoMaterias(ActionEvent event) throws IOException {
        /*final Alumno persona = getTablaPersonasSeleccionada();
        posicionPersonaEnTabla = personas.indexOf(persona);*/
        Stage stage2=new Stage();
        FXMLLoader loader=new FXMLLoader();
        AnchorPane root=(AnchorPane)loader.load(getClass().getResource("MateriasVista.fxml").openStream());
        MateriasVistaController st2C=(MateriasVistaController)loader.getController();
        //st2C.recibeP(con1,persona.getNombre());
        Scene scene=new Scene(root);
        stage2.setScene(scene);
        stage2.alwaysOnTopProperty();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.show();
    }
    
    @FXML
    private void agregar(ActionEvent event) throws IOException {
        final Alumno persona = getTablaPersonasSeleccionada();
        posicionPersonaEnTabla = personas.indexOf(persona);
        Stage stage2=new Stage();
        FXMLLoader loader=new FXMLLoader();
        AnchorPane root=(AnchorPane)loader.load(getClass().getResource("HorarioAlumnoVista.fxml").openStream());
        HorarioAlumnoVistaController st2C=(HorarioAlumnoVistaController)loader.getController();//aqui esta el error
        st2C.recibeP(con1,persona.getNombre());
        Scene scene=new Scene(root);
        stage2.setScene(scene);
        stage2.alwaysOnTopProperty();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.show();
    }
}
//responsable ss administra proyecto unidad receptora con proyecto y solicitud
//inscripcion con reporte y documento qeu salen de la relacion de alumno con servicio social alumno con datos contacto