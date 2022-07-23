package Aplicacion.Clases.controladorEmpresa;

import Aplicacion.Clases.empresa.Empresa;

/* 
public ArrayList<Producto> productos = new ArrayList<>();
public ArrayList<Factura> ventas = new ArrayList<>();
public ArrayList<Factura> compras = new ArrayList<>();
public ArrayList<Cliente> clientes = new ArrayList<>();
public ArrayList<Proveedor> proveedores = new ArrayList<>();*/
public class ControladorEmpresa {
  private Empresa empresa;

  public ControladorEmpresa(String nombreEmpresa, int nit) {
    this.empresa = new Empresa(nombreEmpresa, nit);
  }

  public ControladorEmpresa() {

  }
}
