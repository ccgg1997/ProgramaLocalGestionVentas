/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author crisc
 */ 
public class ClienteDao {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
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
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
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
    
    public List listarCliente()
    {
        List <Cliente> ListaC1= new ArrayList();
        String sql="SELECT * FROM public.\"Clientes\" ";
        String aux="";
        try
        {
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) 
            {               
               Cliente cl = new Cliente();
               cl.setId(rs.getInt("id"));
               cl.setCedula(rs.getInt("cedula"));
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getInt("telefono"));
               cl.setDireccion(rs.getString("direccion"));
               ListaC1.add(cl);
               //aux= rs.getString("nombre");
           }  
            //PRUEBA PARA VERIFICAR LA CONEXION CON LA BASE DE DATOS
            //JOptionPane.showMessageDialog(null,aux);
        }
        
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
        }
        return ListaC1;
    }
    
    public boolean eliminarCliente(int id)
    {
        String sql= "DELETE FROM public.\"Clientes\" WHERE id=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.out.println(e.toString());
            return true;
        }
        finally{
            try
            {
              con.close();  
            }
            catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
    }
    
    public boolean ModificarCliente(Cliente cl){
        String sql="UPDATE public.\"Clientes\" SET cedula=?, nombre=?,telefono=?,direccion=? WHERE id=?";
        try{ 
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, cl.getCedula());
            ps.setString(2,cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4,cl.getDireccion());
            ps.setInt(5, cl.getId());
            ps.execute();
            return true;
            
            
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
        
    }
    
    
    
    
    
    
    
    
}
