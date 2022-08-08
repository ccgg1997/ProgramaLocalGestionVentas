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

