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
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class InicioController implements Initializable {
    public static String user;
    public static User usuario;
    public static carrito carro = new carrito();
    
    @FXML
    private Button salir, historial, btncarrito, iphone12, iphone13, iphone14, iphone15, cIPhone12, cIPhone13, cIPhone14, cIPhone15;
    
    public void actionEvent (ActionEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(salir)){
            user = "";
            loadStage("/principal/base.fxml", e);
        }
        if(evt.equals(historial)){
            CarritoController.hist.getHistorial();
            loadStage("/principal/historial.fxml", e);
        }
        if(evt.equals(btncarrito)){
            carro.getCarrito();
            loadStage("/principal/carrito.fxml", e);
        }
        if(evt.equals(iphone12)){
            String modelo = "IPhone 12";
            String comprador = InicioController.user;
            String descripcion = "256GB de almacenamiento";
            String precio = "2500000";
            carro.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Añadido al carrito con exito!");
        }
        if(evt.equals(iphone13)){
            String modelo = "IPhone 13";
            String comprador = InicioController.user;
            String descripcion = "512GB de almacenamiento";
            String precio = "2900000";
            carro.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Añadido al carrito con exito!");
        }
        if(evt.equals(iphone14)){
            String modelo = "IPhone 14";
            String comprador = InicioController.user;
            String descripcion = "512GB de almacenamiento";
            String precio = "3600000";
            carro.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Añadido al carrito con exito!");
        }
        if(evt.equals(iphone15)){
            String modelo = "IPhone 15";
            String comprador = InicioController.user;
            String descripcion = "1TB de almacenamiento";
            String precio = "4000000";
            carro.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Añadido al carrito con exito!");
        }
        if(evt.equals(cIPhone12)){
            String modelo = "IPhone 12";
            String comprador = InicioController.user;
            String descripcion = "256GB de almacenamiento";
            String precio = "2500000";
            CarritoController.hist.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Comprado con exito!");
        }
        if(evt.equals(cIPhone13)){
            String modelo = "IPhone 13";
            String comprador = InicioController.user;
            String descripcion = "512GB de almacenamiento";
            String precio = "2900000";
            CarritoController.hist.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Comprado con exito!");
        }
        if(evt.equals(cIPhone14)){
            String modelo = "IPhone 14";
            String comprador = InicioController.user;
            String descripcion = "512GB de almacenamiento";
            String precio = "3600000";
            CarritoController.hist.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Comprado con exito!");
        }
        if(evt.equals(cIPhone15)){
            String modelo = "IPhone 15";
            String comprador = InicioController.user;
            String descripcion = "1TB de almacenamiento";
            String precio = "4000000";
            CarritoController.hist.crearLista(modelo, comprador, descripcion, precio);
            JOptionPane.showMessageDialog(null, "Comprado con exito!");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
