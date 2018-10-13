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
            //ps = cn1.prepareStatement("SELECT * FROM usuario1");
            ps = cn1.prepareStatement ("SELECT * FROM usuario1 WHERE usuario='"+user+"' AND contrasenia=('"+pass+"')");
            rs = ps.executeQuery();
//            System.out.print ("\n" + rs);
//            if (rs!=null) {
//                System.out.print ("\nSesión iniciada");
//            } else {
//                System.out.print ("\nError al iniciar sesión");
//            }
            
//            System.out.print ("\nConexión SQL Server\n");
                while (rs.next()) {
//                    System.out.print (rs.getString("id") + ", " + rs.getString("usuario") + ", " + rs.getString("contrasenia") + ", " + rs.getString("correo") + "\n");
                    conexion = 1;
                }
                cn1.close();
                //conexion = 1;
                
                
        } catch (SQLException e) {
            System.out.println (e.getMessage());
        }
        
        
        return conexion;
    }
    
    public int provocarconexion2 (String user, String contra, String correo) throws SQLException {
        int conexion = 0;
//        String query = "INSERT INTO usuario1 (usuario,contrasenia,correo) VALUES (" + user +","+ contra +","+ correo + ")";
        PreparedStatement ps = null;
//        ps.setString(1, user);
//        ps.setString(2, contra);
//        ps.setString(3, correo);
//        ps.execute();
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        st.executeUpdate("INSERT INTO usuario1 (usuario,contrasenia,correo) VALUES ('" + user +"','"+ contra +"','"+ correo + "')");
       // rs = ps.executeUpdate();
        
        return conexion;
    }
    
}
