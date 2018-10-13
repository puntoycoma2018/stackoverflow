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
    public int conexionInstitucion (String user, String pass) {
        int conexion = 0;
        
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = cn1.prepareStatement ("SELECT * FROM institucion WHERE usuario='"+user+"' AND contrasenia=('"+pass+"')");
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
    
    public int conexionTutor (String user, String pass) {
        int conexion = 0;
        
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = cn1.prepareStatement ("SELECT * FROM tutor WHERE usuario='"+user+"' AND contrasenia=('"+pass+"')");
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
    
    public int conexionEstudiante (String user, String pass) {
        int conexion = 0;
        
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = cn1.prepareStatement ("SELECT * FROM estudiante WHERE usuario='"+user+"' AND contrasenia=('"+pass+"')");
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
    
    public int institucion (String user, String contra, String correo) throws SQLException {
        int conexion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        
        st.executeUpdate("INSERT INTO institucion (usuario,contrasenia,correo) VALUES ('" + user +"','"+ contra +"','"+ correo + "')");
        JOptionPane.showMessageDialog(null, "Usuario creado sastifactoriamente.");
        
        return conexion;
    }
    
    public int tutor (String user, String contra, String correo) throws SQLException {
        int conexion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        
        st.executeUpdate("INSERT INTO tutor (usuario,contrasenia,correo) VALUES ('" + user +"','"+ contra +"','"+ correo + "')");
        JOptionPane.showMessageDialog(null, "Usuario creado sastifactoriamente.");
        
        return conexion;
    }
    
    public int estudiante (String user, String contra, String correo) throws SQLException {
        int conexion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        
        st.executeUpdate("INSERT INTO estudiante (usuario,contrasenia,correo) VALUES ('" + user +"','"+ contra +"','"+ correo + "')");
        JOptionPane.showMessageDialog(null, "Usuario creado sastifactoriamente.");
        
        return conexion;
    }
    
}
