/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class carrito {
    public static producto cab;
    
    public carrito() { cab = null; }
    
    public producto CrearNodo(String modelo, String comprador, String descripcion, String precio){
        producto p;
        p = new producto(modelo, comprador, descripcion, precio);
        return p;
    }
    
    public void crearLista(String modelo, String comprador, String descripcion, String precio){
        producto p = CrearNodo(modelo, comprador, descripcion, precio);
        if (cab == null) {
            cab = p;
            JOptionPane.showMessageDialog(null, p.modelo);
        } else {
            p.sig = cab;
            cab = p;
        }
    }
    public void getCarrito(){
        producto p = cab;
        do {
            if(p.comprador.equals(InicioController.user)){
                CarritoController.productos.add(p);
            }
            p = p.sig;
        }while(p != null);
    }
    
    public int valortotal(){
        producto p = cab;
        int valor = 0;
        do {
            if(p.comprador.equals(InicioController.user)){
                valor = Integer.parseInt(p.precio) + valor;
            }
            p = p.sig;
        } while(p != null);
        return valor;
    }
}
