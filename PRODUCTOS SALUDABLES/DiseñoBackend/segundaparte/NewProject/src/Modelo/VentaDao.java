/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author Valeria
 */
public class VentaDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(numero_factura) FROM public.\"Venta\" ";
        try {

            con = cn.iniciarconexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {

                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return id;
    }
    
    public int RegistrarVenta(Venta v) {
        
        LocalDate fechaActual = LocalDate.now();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaActual);
        System.out.println(fecha);
        String sql = "INSERT INTO public.\"Venta\" (nombre_vendedor,nombre_cliente,precio_total,fecha) VALUES (?,?,?,?)";
        try {

            con = cn.iniciarconexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getNombre_vendedor());
            ps.setString(2, v.getNombre_cliente());
            ps.setDouble(3, v.getPrecio_total());
            ps.setDate(4,fecha);
            ps.execute();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }
        return r;

    }

    public int DetalleVenta(Detalle Dv) {
        String sql = "INSERT INTO public.\"Detalle\" (cod_pro,cantidad,precio,id_venta) VALUES (?,?,?,?)";

        try {
            con = cn.iniciarconexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dv.getCod_pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setInt(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId());
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return r;
    }
    
    public boolean ActualizarStock (int cantidad, int id){
        String sql="UPDATE public.\"Producto\" SET cantidad=? WHERE id=?";
        try{ 
            con= cn.iniciarconexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2,id);
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
