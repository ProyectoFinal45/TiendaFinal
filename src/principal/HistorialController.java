/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package principal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static principal.CarritoController.productos;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HistorialController implements Initializable {
    
    @FXML
    private TableView<producto> tabla;
    
    @FXML
    private TableColumn<producto, String> modelo;
    
    @FXML
    private TableColumn<producto, String> descripcion;
    
    @FXML
    private TableColumn<producto, String> precio;
    
    public static ObservableList<producto> productos = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelo.setCellValueFactory(new PropertyValueFactory<producto, String>("modelo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<producto, String>("descripcion"));
        precio.setCellValueFactory(new PropertyValueFactory<producto, String>("precio"));
        tabla.setItems(productos);
        // TODO
    }    
    
}
