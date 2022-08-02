package Aplicacion.Clases.movimiento;


public class Movimiento{
  private int codFactura;
  private int codArticulos;
  private int cantidad;
  private int iva;
  private int precioVenta;
  private int descuento;
  /**
   * @param codFactura
   * @param codArticulos
   * @param cantidad
   * @param iva
   * @param precioVenta
   * @param descuento
   */
  public Movimiento(int codFactura, int codArticulos, int cantidad, int iva, int precioVenta, int descuento) {
    this.codFactura = codFactura;
    this.codArticulos = codArticulos;
    this.cantidad = cantidad;
    this.iva = iva;
    this.precioVenta = precioVenta;
    this.descuento = descuento;
  }

  public Movimiento() {
    this.codFactura =0;
    this.codArticulos = 0;
    this.cantidad = 0;
    this.iva = 0;
    this.precioVenta = 0;
    this.descuento = 0;
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

  public void calcularTotal(){


  }

  public void ingresarDatos(){


  }

  public void mostrarDetalleFactura(){

  }
  
}
