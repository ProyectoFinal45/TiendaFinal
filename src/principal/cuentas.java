/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class cuentas {
    public static User cab;
    
    public cuentas () { cab = null; }
    
    public User BuscarNom(String user){
        User p = cab;
        if (cab == null)
            return null;
        else{
            while (p != null){
                if ((p.nombre).equals(user))
                    return p;
                else
                    p=p.sig;
            }
            return null;
        }
    }
    public User BuscarCuenta(String user, String contraseña){
        User p = cab;
        if (cab == null)
            return null;
        else{
            while (p != null){
                if ((p.nombre).equals(user) && (p.contraseña).equals(contraseña))
                    return p;
                else
                    p=p.sig;
            }
            return null;
        }
    }
    
    public User CrearNodo (String nombre, String contraseña){
        User info, p;
        String nom;
        if (nombre.equals("") || contraseña.equals("")){
            JOptionPane.showMessageDialog(null, "Ambos campos son obligatorios, por favor ingrese su usuario y contraseña");
            return null;
        } else {
            do {
                nom = nombre;
                p = BuscarNom(nom);
                if(p != null){
                    JOptionPane.showMessageDialog(null, "Este nombre de usuario ya se encuentra registrado\n"
                        + "Ingrese uno diferente");
                    return null;
                }
            }while (p != null);
            if (p == null){
                info = new User(nom, contraseña);
                JOptionPane.showMessageDialog(null, "Registro exitoso, inicie sesion en login");
                return info;
            }else{
                return null;
            }
        }
    }
    public void crearCuenta(String nombre, String contraseña){
        User info = CrearNodo(nombre, contraseña);
        if(info != null) {
            if (cab == null) {
                cab = info;
            } else {
                info.sig = cab;
                cab = info;
            }
        }
    }
}
