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

/**
 *
 * @author crisc
 */
public class VendedorDao {
    
    Conexion cn= new Conexion();
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
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
    
}
