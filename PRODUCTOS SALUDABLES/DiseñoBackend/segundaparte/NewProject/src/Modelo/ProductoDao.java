/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
/**
 *
 * @author Valeria
 */
public class ProductoDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Producto p) {
        
        String sql = "INSERT INTO public.\"Producto\" (id,nombre,cantidad,proveedor,precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.iniciarconexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getCantidad());
            ps.setString(4,p.getProveedor());
            ps.setInt(5,p.getPrecio());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor) {
        String sql = "SELECT nombre FROM public.\"Proveedor\" ";
        try {
            con = cn.iniciarconexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public List listarProductos()
    {
        List <Producto> ListaPro= new ArrayList();
        String sql="SELECT * FROM public.\"Producto\" ";
        String aux="";
        try
        {
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) 
            {               
               Producto pro = new Producto();
               pro.setId(rs.getInt("id"));
               pro.setNombre(rs.getString("nombre"));
               pro.setProveedor(rs.getString("proveedor"));
               pro.setCantidad(rs.getInt("cantidad"));
               pro.setPrecio(rs.getInt("precio"));
               ListaPro.add(pro);
               //aux= rs.getString("nombre");
           }  
            //PRUEBA PARA VERIFICAR LA CONEXION CON LA BASE DE DATOS
            //JOptionPane.showMessageDialog(null,aux);
        }
        
        catch(SQLException e)
        {
            System.out.println(e.toString());
            
        }
        return ListaPro;
    }
    
        public boolean eliminarProducto(int id)
    {
        String sql= "DELETE FROM public.\"Producto\" WHERE id=?";
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
        
        public boolean ModificarProducto(Producto p){
        String sql="UPDATE public.\"Producto\" SET nombre=?,precio=?,cantidad=?,proveedor=? WHERE id=?";
        try{ 
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3,p.getCantidad());
            ps.setString(4, p.getProveedor());
            ps.setInt(5, p.getId());
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

    public Producto BuscarProducto(int id) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM public.\"Producto\" WHERE id = ?";
        try {
            con = cn.iniciarconexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setCantidad(rs.getInt("cantidad"));

            }

        } catch (SQLException e) {
            System.out.println(e.toString());

        }
        return producto;
    }
}

