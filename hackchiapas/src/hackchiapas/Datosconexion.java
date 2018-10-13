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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    
    public int datosEstudiante (String nombre, String materno, String paterno, String uni, int edad, String nacimiento) throws SQLException {
        int conexion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        
        st.executeUpdate("INSERT INTO DatosEstudiante (nombre,materno,paterno,uni,edad,nacimiento) VALUES ('" + nombre +"','"+ materno +"','"+ paterno + "','"+uni+"','"+edad+"','"+nacimiento+"')");
        JOptionPane.showMessageDialog(null, "Datos guardados sastifactoriamente.");
        
        return conexion;
    }
    
    public int CargaMateria (String materia) throws SQLException {
        int conexion = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement st = cn2.createStatement();
        
        st.executeUpdate("INSERT INTO materias (materia) VALUES ('" + materia +"')");
        JOptionPane.showMessageDialog(null, "Materia agregada sastifactoriamente.");
        
        return conexion;
    }
    
    public int mostrarMaterias (JTextArea pantalla) {
        int conexion = 0;
        int cont = 0;
        String print="";
        pantalla.setText("");
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = cn1.prepareStatement ("SELECT * FROM materias");
            rs = ps.executeQuery();
                while (rs.next()) {
                    pantalla.setText(pantalla.getText() + rs.getString("materia") + "   ");
                    print = (rs.getString("materia"));
                    //pantalla.setText(pantalla.getText() + "print");
                    //System.out.print (print);
                    if (cont==5) {
                        pantalla.setText(pantalla.getText() + "\n");
                        cont=0;
                    }
                    cont++;
                }
                cn1.close();
                
        } catch (SQLException e) {
            System.out.println (e.getMessage());
        }
        
        
        return conexion;
    }
    
}
