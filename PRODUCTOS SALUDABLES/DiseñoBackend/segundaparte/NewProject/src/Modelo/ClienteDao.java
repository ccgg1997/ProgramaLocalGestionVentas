/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author crisc
 */ 
public class ClienteDao {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    
    public boolean RegistrarCliente(Cliente cl){
        try
        {
            con=   cn.iniciarconexion();
            String sql="INSERT INTO public.\"Clientes\" (cedula,nombre,telefono,direccion,id) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,cl.getCedula());
            ps.setString(2,cl.getNombre());
            ps.setInt(3,cl.getTelefono());
            ps.setString(4,cl.getDireccion());
            ps.setInt(5,cl.getId());
            ps.execute();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        
        }finally{
            try{
                con.close();
                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                        + "\n " + ex.getMessage());
            }
            
        }
        return true;
        
    }
    
    
}
