package Aplicacion.Clases.empresa;
import java.util.*;

import Aplicacion.Clases.factura.Factura;
import Aplicacion.Clases.persona.Cliente;
import Aplicacion.Clases.persona.Proveedor;
import Aplicacion.Clases.producto.Producto;
public class Empresa {
public ArrayList<Producto> productos = new ArrayList<>();
public ArrayList<Factura> ventas = new ArrayList<>();
public ArrayList<Factura> compras = new ArrayList<>();
public ArrayList<Cliente> clientes = new ArrayList<>();
public ArrayList<Proveedor> proveedores = new ArrayList<>();
  private String nombreEmpresa;
	private int nit;
  
  public Empresa(String nombreEmpresa, int nit){
    this.nombreEmpresa= nombreEmpresa;
    this.nit= nit;
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

  

  public void agregarVentas(){

  }

  public void agregarCompras(){


  }

  

  public void eliminarVentas(){


  }

  public void eliminarCompras(){

  }
}
