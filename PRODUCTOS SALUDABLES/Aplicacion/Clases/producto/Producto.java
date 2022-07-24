package Aplicacion.Clases.producto;

public class Producto {
  private int codigo;
  private int existencia;
  private int precioVenta;
  private int precioCompra;
  /**
   * @param codigo
   * @param existencia
   * @param precioVenta
   * @param precioCompra
   */
  public Producto(int codigo, int existencia, int precioVenta, int precioCompra) {
    this.codigo = codigo;
    this.existencia = existencia;
    this.precioVenta = precioVenta;
    this.precioCompra = precioCompra;
  }

  public Producto() {
    this.codigo = 0;
    this.existencia = 0;
    this.precioVenta = 0;
    this.precioCompra = 0;
  }

  /**
   * @return the codigo
   */
  public int getCodigo() {
    return codigo;
  }

  /**
   * @param codigo the codigo to set
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * @return the existencia
   */
  public int getExistencia() {
    return existencia;
  }

  /**
   * @param existencia the existencia to set
   */
  public void setExistencia(int existencia) {
    this.existencia = existencia;
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
   * @return the precioCompra
   */
  public int getPrecioCompra() {
    return precioCompra;
  }

  /**
   * @param precioCompra the precioCompra to set
   */
  public void setPrecioCompra(int precioCompra) {
    this.precioCompra = precioCompra;
  }
  

  public void agregarProducto(){


  }

  public void eliminarProducto(){


  }

  
}
