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
    private String nombre_vendedor;
    private String nombre_cliente;
    private double precio_total;

    public Venta() {
    }

    public Venta(int numero_factura, String nombre_vendedor, String nombre_cliente, double precio_total) {
        this.numero_factura = numero_factura;
        this.nombre_vendedor = nombre_vendedor;
        this.nombre_cliente = nombre_cliente;
        this.precio_total = precio_total;
    }

    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
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

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    
}