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
public class ProveedorDao {
     Conexion cn= new Conexion();
     Connection con = null;
     PreparedStatement ps;
     ResultSet rs;
     
    public boolean registrarProvedor(Proveedor pr){
       
        String sql= "INSERT INTO public.\"Proveedor\"(nit, materia_prima,nombre,direccion,telefono)VALUES (?,?,?,?,?)";
        try{
            con= cn.iniciarconexion();
            ps= con.prepareStatement(sql);
            ps.setInt(1,pr.getNit());
            ps.setInt(5,pr.getTelefono());
            ps.setString(3,pr.getNombre());
            ps.setString(4,pr.getDireccion());
            ps.setString(2,pr.getMateriaPrima());
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
    
    public List listarProveedor()
    {
        List <Proveedor> Listapr = new ArrayList();
        String sql="SELECT * FROM public.\"Proveedor\" ";
        //String aux="";
        try
        {
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) 
            {               
               Proveedor pr = new Proveedor();
               pr.setNit(rs.getInt("nit"));
               pr.setMateriaPrima(rs.getString("materia_prima"));
               pr.setNombre(rs.getString("nombre"));
               pr.setTelefono(rs.getInt("telefono"));
               pr.setDireccion(rs.getString("direccion"));
               Listapr.add(pr);
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
        return Listapr;
    }

    
    public boolean eliminarProveedor(int id)
    {
        String sql= "DELETE FROM public.\"Proveedor\" WHERE nit=?";
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


      public boolean ModificarProveedor(Proveedor pr){
        String sql="UPDATE public.\"Proveedor\" SET  nombre=?,telefono=?,direccion=?,materia_prima=? WHERE nit=?";
        try{ 
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,pr.getNombre());
            ps.setInt(2, pr.getTelefono());
            ps.setString(3,pr.getDireccion());
            ps.setString(4, pr.getMateriaPrima());
            ps.setInt(5, pr.getNit());
            JOptionPane.showMessageDialog(null, pr.getNit());
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

   
