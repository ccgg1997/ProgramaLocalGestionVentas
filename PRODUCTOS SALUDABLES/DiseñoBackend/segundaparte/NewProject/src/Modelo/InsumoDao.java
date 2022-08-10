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
    
    public boolean RegistrarInsumo(Insumo cl){
        try
        {
            con=   cn.iniciarconexion();
            String sql="INSERT INTO public.\"InventarioInsumos\" (codigo,nit_proveedor,nombre_insumo,precio,cantidad_insumo) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,cl.getCodigo());
            ps.setString(3,cl.getNombre());
            ps.setInt(4,cl.getPrecio());
            ps.setInt(2,cl.getId_proveedor());
            ps.setInt(5,cl.getCantidad());
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
            rs= ps.executeQuery();
            
            while(rs.next()) 
            {               
               Insumo in = new Insumo();
               in.setCodigo(rs.getInt("codigo"));
               in.setCantidad(rs.getInt("cantidad_insumo"));
               in.setNombre(rs.getString("nombre_insumo"));
               in.setPrecio(rs.getInt("precio"));
               in.setId_proveedor(rs.getInt("nit_proveedor"));
               ListaC.add(in);
               //aux= rs.getString("nombre");
           }  
            //PRUEBA PARA VERIFICAR LA CONEXION CON LA BASE DE DATOS
            //JOptionPane.showMessageDialog(null,aux);
        }
        
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
        }
        return ListaC;
    }
}
