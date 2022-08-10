/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author crisc
 */
public class Insumo {
    
    private int codigo;
    private int nit_proveedor;
    private String nombre_insumo;
    private int cantidad_insumo;
    private int precio;


    public Insumo() {
    }

    public Insumo(int codigo, int nit_proveedor, String nombre_insumo, int cantidad_insumo, int precio) {
        this.codigo = codigo;
        this.nit_proveedor = nit_proveedor;
        this.nombre_insumo = nombre_insumo;
        this.cantidad_insumo = cantidad_insumo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(int nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    public String getNombre_insumo() {
        return nombre_insumo;
    }

    public void setNombre_insumo(String nombre_insumo) {
        this.nombre_insumo = nombre_insumo;
    }

    public int getCantidad_insumo() {
        return cantidad_insumo;
    }

    public void setCantidad_insumo(int cantidad_insumo) {
        this.cantidad_insumo = cantidad_insumo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    
}
