/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Admin
 */
public class historial {
    public static producto cab;
    
    public historial() { cab = null; }
    
    public producto CrearNodo(String modelo, String comprador, String descripcion, String precio){
        producto p;
        p = new producto(modelo, comprador, descripcion, precio);
        return p;
    }
    
    public void crearLista(String modelo, String comprador, String descripcion, String precio){
        producto p = CrearNodo(modelo, comprador, descripcion, precio);
        if (cab == null) {
            cab = p;
        } else {
            p.sig = cab;
            cab = p;
        }
    }
    public void getHistorial(){
        producto p = cab;
        do {
            if(p.comprador.equals(InicioController.user)){
                HistorialController.productos.add(p);
            }
            p = p.sig;
        }while(p != null);
    }
}
