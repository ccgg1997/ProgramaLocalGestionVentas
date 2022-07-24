package Aplicacion.Clases.movimiento;

import java.util.ArrayList;

public class Movimiento {
  private int codFactura;
  private int codArticulos;
  private int cantidad;
  private int iva;
  private int precioVenta;
  private int descuento;
  private int subTotal;
  private double totalProductos;
  /**
   * @param codFactura
   * @param codArticulos
   * @param cantidad
   * @param iva
   * @param precioVenta
   * @param descuento
   */
  public Movimiento(int codFactura, int codArticulos, int cantidad, int iva, int precioVenta, int descuento,int subTotal) {
    this.codFactura = codFactura;
    this.codArticulos = codArticulos;
    this.cantidad = cantidad;
    this.iva = iva;
    this.precioVenta = precioVenta;
    this.descuento = descuento;
    this.subTotal = subTotal;
  }

  public Movimiento() {
    this.codFactura =0;
    this.codArticulos = 0;
    this.cantidad = 0;
    this.iva = 0;
    this.precioVenta = 0;
    this.descuento = 0;
    this.subTotal = 0;
    this.totalProductos = 0;
  }

 

  /**
   * @return the codFactura
   */
  public int getCodFactura() {
    return codFactura;
  }

  /**
   * @param codFactura the codFactura to set
   */
  public void setCodFactura(int codFactura) {
    this.codFactura = codFactura;
  }

  /**
   * @return the codArticulos
   */
  public int getCodArticulos() {
    return codArticulos;
  }

  /**
   * @param codArticulos the codArticulos to set
   */
  public void setCodArticulos(int codArticulos) {
    this.codArticulos = codArticulos;
  }

  /**
   * @return the cantidad
   */
  public int getCantidad() {
    return cantidad;
  }

  /**
   * @param cantidad the cantidad to set
   */
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  /**
   * @return the iva
   */
  public int getIva() {
    return iva;
  }

  /**
   * @param iva the iva to set
   */
  public void setIva(int iva) {
    this.iva = iva;
  }

  /**
   * @return the precioVenta
   */
  public int getPrecioVenta() {
    return precioVenta;
  }

  /**
   * @param precioVenta the precioVenta to set
   */
  public void setPrecioVenta(int precioVenta) {
    this.precioVenta = precioVenta;
  }

  /**
   * @return the descuento
   */
  public int getDescuento() {
    return descuento;
  }

  /**
   * @param descuento the descuento to set
   */
  public void setDescuento(int descuento) {
    this.descuento = descuento;
  }

  /**
   * @return the subTotal
   */
  public int getSubTotal() {
    return subTotal;
  }

  /**
   * @param subTotal the subTotal to set
   */
  public void setSubTotal(int subTotal) {
    this.subTotal = subTotal;
  }
/**
   * @return the totalProductos
   */
  public double getTotalProductos() {
    return totalProductos;
  }

  /**
   * @param subt the totalProductos to set
   */
  public void setTotalProductos(double totalProductos) {
    this.totalProductos = totalProductos;
  }
  
  public double subtotalItem(Movimiento item) {

    double subtotalItem = item.getPrecioVenta() * item.getCantidad();

    return subtotalItem;
  }

  

  
  public void calcularTotal(ArrayList <Movimiento> items){
    
      //this.setProductos(items);
      double total=0;
      for(int i = 0;i < items.size();i++){
         total += items.get(i).getSubTotal();
         
         }
         
       this.setTotalProductos(total);
   

  }

  public void ingresarDatos(){


  }

  public void mostrarDetalleFactura(){

  }

  
  
}
