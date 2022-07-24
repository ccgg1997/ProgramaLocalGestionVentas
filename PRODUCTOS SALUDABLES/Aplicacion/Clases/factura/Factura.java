package Aplicacion.Clases.factura;
import java.util.*;

import Aplicacion.Clases.producto.Producto;
public class Factura {
  private String nombreEmpresa;
  private String direccion;
  private int nit;
  private String fecha;
  private String tipoFactura;
  private int idVendedor;
  private int idFactura;
  private int codEmpleado;
  public  ArrayList <Producto> productos = new ArrayList<>();
  /**
   * @param nombreEmpresa
   * @param direccion
   * @param nit
   * @param fecha
   * @param tipoFactura
   * @param idVendedor
   * @param idFactura
   * @param codEmpleado
   */
  public Factura(String nombreEmpresa, String direccion, int nit, String fecha, String tipoFactura, int idVendedor,
      int idFactura, int codEmpleado) {
    this.nombreEmpresa = nombreEmpresa;
    this.direccion = direccion;
    this.nit = nit;
    this.fecha = fecha;
    this.tipoFactura = tipoFactura;
    this.idVendedor = idVendedor;
    this.idFactura = idFactura;
    this.codEmpleado = codEmpleado;
  }

  public Factura() {
  this.nombreEmpresa = "";
  this.direccion = "";
  this.nit = 0;
  this.fecha = "";
  this.tipoFactura = "";
  this.idVendedor = 0;
  this.idFactura = 0;
  this.codEmpleado = 0;
  }

  /**
   * @return the nombreEmpresa
   */
  public String getNombreEmpresa() {
    return nombreEmpresa;
  }

  /**
   * @param nombreEmpresa the nombreEmpresa to set
   */
  public void setNombreEmpresa(String nombreEmpresa) {
    this.nombreEmpresa = nombreEmpresa;
  }

  /**
   * @return the direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * @param direccion the direccion to set
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * @return the nit
   */
  public int getNit() {
    return nit;
  }

  /**
   * @param nit the nit to set
   */
  public void setNit(int nit) {
    this.nit = nit;
  }

  /**
   * @return the fecha
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * @param fecha the fecha to set
   */
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  /**
   * @return the tipoFactura
   */
  public String getTipoFactura() {
    return tipoFactura;
  }

  /**
   * @param tipoFactura the tipoFactura to set
   */
  public void setTipoFactura(String tipoFactura) {
    this.tipoFactura = tipoFactura;
  }

  /**
   * @return the idVendedor
   */
  public int getIdVendedor() {
    return idVendedor;
  }

  /**
   * @param idVendedor the idVendedor to set
   */
  public void setIdVendedor(int idVendedor) {
    this.idVendedor = idVendedor;
  }

  /**
   * @return the idFactura
   */
  public int getIdFactura() {
    return idFactura;
  }

  /**
   * @param idFactura the idFactura to set
   */
  public void setIdFactura(int idFactura) {
    this.idFactura = idFactura;
  }

  /**
   * @return the codEmpleado
   */
  public int getCodEmpleado() {
    return codEmpleado;
  }

  /**
   * @param codEmpleado the codEmpleado to set
   */
  public void setCodEmpleado(int codEmpleado) {
    this.codEmpleado = codEmpleado;
  }

  
  
}
