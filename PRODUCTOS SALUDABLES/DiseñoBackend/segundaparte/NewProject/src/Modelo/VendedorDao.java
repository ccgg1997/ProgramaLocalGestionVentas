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
public class VendedorDao {
    
    Conexion cn= new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarVendedor(Vendedor pr){
       
        String sql= "INSERT INTO public.\"Vendedor\" (id,nombre,telefono,jornada,direccion)VALUES (?,?,?,?,?)";
        try{
            con= cn.iniciarconexion();
            ps= con.prepareStatement(sql);
            ps.setInt(1,pr.getCedula());
            ps.setInt(3,pr.getTelefono());
            ps.setString(2,pr.getNombre());
            ps.setString(5,pr.getDireccion());
            ps.setString(4,pr.getJornada());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
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
    
    public List listarVendedor()
    {
        List <Vendedor> Listavr = new ArrayList();
        String sql="SELECT * FROM public.\"Vendedor\" ";
        //String aux="";
        try
        {
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) 
            {               
               Vendedor vr = new Vendedor();
               vr.setCedula(rs.getInt("id"));
               vr.setNombre(rs.getString("nombre"));
               vr.setJornada(rs.getString("jornada"));
               vr.setTelefono(rs.getInt("telefono"));
               vr.setDireccion(rs.getString("direccion"));
               Listavr.add(vr);
               //aux= rs.getString("direccion");
           }  
            //PRUEBA PARA VERIFICAR LA CONEXION CON LA BASE DE DATOS
            //JOptionPane.showMessageDialog(null,"Proveedor Dao");
            //JOptionPane.showMessageDialog(null,aux);
        }
        
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
        }
        return Listavr;
    }
    
    public boolean eliminarVendedor(int id)
    {
        String sql= "DELETE FROM public.\"Vendedor\" WHERE id=?";
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

     

      public boolean ModificarVendedor(Vendedor pr){
        String sql="UPDATE public.\"Vendedor\" SET  nombre=?,telefono=?,direccion=?,jornada=? WHERE id=?";
        try{ 
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,pr.getNombre());
            ps.setInt(2, pr.getTelefono());
            ps.setString(3,pr.getDireccion());
            ps.setString(4, pr.getJornada());
            ps.setInt(5, pr.getCedula());
            JOptionPane.showMessageDialog(null, pr.getCedula());
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
