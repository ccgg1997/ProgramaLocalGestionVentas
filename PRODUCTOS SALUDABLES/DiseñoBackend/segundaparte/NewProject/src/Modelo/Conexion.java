/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author crisc
 */
public class Conexion {
    
    Connection con;
    
    public Connection iniciarconexion(){
        
        String dbUrl = "jdbc:postgresql://ec2-54-87-179-4.compute-1.amazonaws.com:5432/d7dn5f0eokivoh?sslmode=require&user=ddfthtnrlykawt&password=4748283b48b041eb54bd706bacc656243be496cf0ca3753784409fe0e6a71ebf";
        String user = "ddfthtnrlykawt";
        String driver = "org.postgresql.Driver";
        String pass = "4748283b48b041eb54bd706bacc656243be496cf0ca3753784409fe0e6a71ebf";
   
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }// Fin de try

        try {
            // 1. Establecer el canal de comunción
            con = DriverManager.getConnection(dbUrl, user, pass);
            return con;
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                    + "\n " + ex.getMessage());
        }

        
        return null;

    }

  
    
}
