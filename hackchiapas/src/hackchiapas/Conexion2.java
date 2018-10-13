/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackchiapas;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author crash
 */
public class Conexion2 {
    
    public Connection cadena_conexion2 () {
        Connection cn = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=registro","sa","slmca");
        } catch (Exception e) {
            System.out.println (e);
        }
        
        return cn;
    }  
        
}                                                
