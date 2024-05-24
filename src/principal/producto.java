/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author Admin
 */
public class producto {
    String modelo, comprador, descripcion, precio;
    producto sig;
    
    public producto(){
        modelo = "";
        comprador = "";
        descripcion = "";
        precio = "";
    }
    
    public producto(String modelo, String comprador, String descripcion, String precio) {
        this.modelo = modelo;
        this.comprador = comprador;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public producto getSig() {
        return sig;
    }

    public void setSig(producto sig) {
        this.sig = sig;
    }
    
    
}
