package Aplicacion.Clases.factura;

import java.util.*;

import Aplicacion.Clases.producto.Producto;
import Aplicacion.Clases.movimiento.Movimiento;

public class FacturaCliente extends Factura {
  private String nombreCliente;
  private int idCliente;
  private int cedula;

  public ArrayList<Producto> productos = new ArrayList<>();

  /**
   * @param nombreEmpresa
   * @param direccion
   * @param nit
   * @param fecha
   * @param tipoFactura
   * @param idVendedor
   * @param idFactura
   * @param codEmpleado
   * @param nombreCliente
   * @param idCliente
   * @param cedula
   * @param productos
   */
  public FacturaCliente(String nombreEmpresa, String direccion, int nit, String fecha, String tipoFactura,
      int idVendedor, int idFactura, int codEmpleado, String nombreCliente, int idCliente, int cedula) {
    super(nombreEmpresa, direccion, nit, fecha, tipoFactura, idVendedor, idFactura, codEmpleado);
    this.nombreCliente = nombreCliente;
    this.idCliente = idCliente;
    this.cedula = cedula;
    
  }

  /**
   * @param nombreCliente
   * @param idCliente
   * @param cedula
   * @param productos
   */
  public FacturaCliente() {
    this.nombreCliente = "";
    this.idCliente = 0;
    this.cedula = 0;
    this.productos = productos;
  }

  /**
   * @return the nombreCliente
   */
  public String getNombreCliente() {
    return nombreCliente;
  }

  /**
   * @param nombreCliente the nombreCliente to set
   */
  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  /**
   * @return the idCliente
   */
  public int getIdCliente() {
    return idCliente;
  }

  /**
   * @param idCliente the idCliente to set
   */
  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  /**
   * @return the cedula
   */
  public int getCedula() {
    return cedula;
  }

  /**
   * @param cedula the cedula to set
   */
  public void setCedula(int cedula) {
    this.cedula = cedula;
  }

 
}
