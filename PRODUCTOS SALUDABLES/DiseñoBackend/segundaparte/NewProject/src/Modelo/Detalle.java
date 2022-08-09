/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Valeria
 */
public class Detalle {

    private int id;
    private int cod_pro;
    private int cantidad;
    private int precio;
    private int id_venta;

    public Detalle() {
    }

    public Detalle(int id, int cod_pro, int cantidad, int precio, int id_venta) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_venta = id_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(int cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

}
