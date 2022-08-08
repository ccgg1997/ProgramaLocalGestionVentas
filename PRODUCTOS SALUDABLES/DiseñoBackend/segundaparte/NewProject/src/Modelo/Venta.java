/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Valeria
 */
public class Venta {

    private int numero_factura;
    private int id_vendedor;
    private int id_cliente;
    private String nombre_vendedor;
    private String nombre_cliente;
    private int id_producto;
    private int cantidad;
    private int precio_unit;
    private double precio_total;

    public Venta() {
    }

    public Venta(int numero_factura, int id_vendedor, int id_cliente, String nombre_vendedor, 
            String nombre_cliente, int id_producto, int cantidad, int precio_unit, double precio_total) {
        this.numero_factura = numero_factura;
        this.id_vendedor = id_vendedor;
        this.id_cliente = id_cliente;
        this.nombre_vendedor = nombre_vendedor;
        this.nombre_cliente = nombre_cliente;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unit = precio_unit;
        this.precio_total = precio_total;
    }

    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_unit() {
        return precio_unit;
    }

    public void setPrecio_unit(int precio_unit) {
        this.precio_unit = precio_unit;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    
}