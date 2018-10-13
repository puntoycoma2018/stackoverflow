/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackchiapas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author crash
 */
public class Datosconexion extends Conexion {
    Connection cn1 = cadena_conexion ();
    Connection cn2 = cadena_conexion ();
    public int provocarconexion (String user, String pass) {
        int conexion = 0;
        
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = cn1.prepareStatement ("SELECT * FROM usuario1 WHERE usuario='"+user+"' AND contrasenia=('"+pass+"')");
            rs = ps.executeQuery();
                while (rs.next()) {
                    conexion = 1;
                }
                cn1.close();
                
        } catch (SQLException e) {
            System.out.println (e.getMessage());
        }
        
        
        return conexion;
    }
    
    public int provocarconexion2 (String user, String contra, String correo) throws SQLException {
        int conexion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        st.executeUpdate("INSERT INTO usuario1 (usuario,contrasenia,correo) VALUES ('" + user +"','"+ contra +"','"+ correo + "')");
        JOptionPane.showMessageDialog(null, "Usuario creado sastifactoriamente.");
        
        return conexion;
    }
    
}
