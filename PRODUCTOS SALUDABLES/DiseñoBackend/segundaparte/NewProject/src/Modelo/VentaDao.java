/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    int r;

    public int RegistrarVenta(Venta v) {
        try {
            Date fecha = new Date();
            System.out.println(fecha);
            con = cn.iniciarconexion();
            String sql = "INSERT INTO public.\"Venta\" (id_vendedor,nombre_vendedor,id_cliente,nombre_cliente,id_producto,cantidad,precio_unit,precio_total,fecha) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, v.getId_vendedor());
            ps.setString(2, v.getNombre_vendedor());
            ps.setInt(3, v.getId_cliente());
            ps.setString(4, v.getNombre_cliente());
            ps.setInt(5, v.getId_producto());
            ps.setInt(6, v.getCantidad());
            ps.setInt(7, v.getPrecio_unit());
            ps.setDouble(8, v.getPrecio_total());
            ps.setString(9,"2022/08/10");
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        return r;

    }
}

