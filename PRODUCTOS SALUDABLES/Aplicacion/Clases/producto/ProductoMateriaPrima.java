package Aplicacion.Clases.producto;

public class ProductoMateriaPrima extends Producto{

  /**
   * @param codigo
   * @param existencia
   * @param precioVenta
   * @param precioCompra
   */
  public ProductoMateriaPrima(int codigo, int existencia, int precioVenta, int precioCompra,int cantidad) {
    super(codigo, existencia, precioVenta, precioCompra,cantidad);
  }

  /**
   * 
   */
  public ProductoMateriaPrima() {
    
  }
  
}
