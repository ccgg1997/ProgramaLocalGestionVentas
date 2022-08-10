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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crisc
 */ 
public class InsumoDao {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarInsumo(Insumo in){
        try
        {
            con=   cn.iniciarconexion();
            String sql="INSERT INTO public.\"InventarioInsumos\" (codigo,nit_proveedor,nombre_insumo,cantidad_insumo,precio) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,in.getCodigo());
             ps.setInt(2,in.getNit_proveedor());
            ps.setString(3, in.getNombre_insumo());
            ps.setInt(4,in.getCantidad_insumo());
            ps.setInt(5, in.getPrecio());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Insumo Registrado");
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
    
    public List listarInsumo()
    {
        List <Insumo> ListaC= new ArrayList();
        String sql=" SELECT * FROM public.\"InventarioInsumos\" ";
        String aux="";
       
        try
        {
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Insumo in = new Insumo();
                in.setCodigo(rs.getInt("codigo"));
                in.setNit_proveedor(rs.getInt("nit_proveedor"));
                in.setNombre_insumo(rs.getString("nombre_insumo"));
                in.setCantidad_insumo(rs.getInt("cantidad_insumo"));
                in.setPrecio(rs.getInt("precio"));
                ListaC.add(in);
                //aux= rs.getString("nombre");
            }
            //PRUEBA PARA VERIFICAR LA CONEXION CON LA BASE DE DATOS
            //JOptionPane.showMessageDialog(null,aux);
        } catch (SQLException e) {
            System.out.println(e.toString());

        }
        return ListaC;
    }
    
     public boolean eliminarInsumo(int codigo)
    {
        String sql= "DELETE FROM public.\"InventarioInsumos\" WHERE codigo=?";
        try{
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,codigo);
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


      public boolean ModificarInsumo(Insumo in){
        String sql="UPDATE public.\"InventarioInsumos\" SET  nit_proveedor=?,nombre_insumo=?,cantidad_insumo=?,precio=? WHERE codigo=?";
        try{ 
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,in.getNit_proveedor());
            ps.setString(2, in.getNombre_insumo());
            ps.setInt(3,in.getCantidad_insumo());
            ps.setInt(4, in.getPrecio());
            ps.setInt(5,in.getCodigo());
            JOptionPane.showMessageDialog(null, "Insumo modificado");
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
