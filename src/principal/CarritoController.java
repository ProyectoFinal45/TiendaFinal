/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package principal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CarritoController implements Initializable {
    
    public static historial hist = new historial();
    
    @FXML
    private TableView<producto> tabla;
    
    @FXML
    private TableColumn<producto, String> modelo;
    
    @FXML
    private TableColumn<producto, String> descripcion;
    
    @FXML
    private TableColumn<producto, String> precio;
    
    public static ObservableList<producto> productos = FXCollections.observableArrayList();
    
    @FXML
    private Button detalles, inicio, compra, historial;
    
    @FXML
    private Label vtotal;
    
    public void actionEvent (ActionEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(detalles)){
            String produ = tabla.getSelectionModel().getSelectedItem().getModelo();
            producto ver = InicioController.carro.cab;
            while(ver != null){
                if(ver.modelo.equals(produ)){
                    DetallesController.mostrar = ver;
                    if(ver.modelo.equals("IPhone 12")){
                        URL imageUrl = getClass().getResource("/image/1-front-back-green-thumbnail.png");
                        DetallesController.image = new Image(imageUrl.toExternalForm());
                    }else if(ver.modelo.equals("IPhone 13")){
                        URL imageUrl = getClass().getResource("/image/01-iphone-13-pro-max-128gb-plateado-front.png");
                        DetallesController.image = new Image(imageUrl.toExternalForm());
                    }else if(ver.modelo.equals("IPhone 14")){
                        URL imageUrl = getClass().getResource("/image/iphone-14-starlight-1__55760.png");
                        DetallesController.image = new Image(imageUrl.toExternalForm());
                    }else if(ver.modelo.equals("IPhone 15")){
                        URL imageUrl = getClass().getResource("/image/iPhone_15_Pro_Max_Titanio_Natural_256GB16948086964.png");
                        DetallesController.image = new Image(imageUrl.toExternalForm());
                    }
                    loadStage("/principal/detalles.fxml", e);
                    ver = null;
                    productos.removeAll(productos);
                }
                ver = ver.sig;
            }
            
        }
        if(evt.equals(inicio)){
            productos.removeAll(productos);
            loadStage("/principal/inicio.fxml", e);
        }
        
        if(evt.equals(compra)){
            String produ = tabla.getSelectionModel().getSelectedItem().getModelo();
            producto comprar = InicioController.carro.cab;
            while(comprar != null){
                if(comprar.modelo.equals(produ) && comprar.comprador.equals(InicioController.user)){
                    hist.crearLista(comprar.modelo, comprar.comprador, comprar.descripcion, comprar.precio);
                    InicioController.carro.eliminarProducto(comprar.modelo, comprar.comprador);
                    JOptionPane.showMessageDialog(null, "Producto comprado con exito!");
                    comprar = null;
                    productos.removeAll(productos);
                    hist.getHistorial();
                    loadStage("/principal/historial.fxml", e);
                }
                comprar = comprar.sig;
            }
        }
        if(evt.equals(historial)){
            hist.getHistorial();
            productos.removeAll(productos);
            loadStage("/principal/historial.fxml", e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modelo.setCellValueFactory(new PropertyValueFactory<producto, String>("modelo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<producto, String>("descripcion"));
        precio.setCellValueFactory(new PropertyValueFactory<producto, String>("precio"));
        tabla.setItems(productos);
        vtotal.setText(Integer.toString(InicioController.carro.valortotal()));
        // TODO
    }    
    
    private void loadStage(String url, Event event){
        
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            
            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });
        }catch ( IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    
    
}
