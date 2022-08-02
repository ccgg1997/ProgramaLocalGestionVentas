package Aplicacion.Clases.factura;

//import java.util.ArrayList;

import Aplicacion.Clases.movimiento.Movimiento;

public class Factura extends Movimiento{
        private String nombreEmpresa;
        private String direccion;
        private int nit;
        private String fecha;
        private int idVendedor;
        private int idFactura;
        private int codEmpleado;  
        private String tipoFactura;
        //private ArrayList <Movimiento> detalleFactura = new ArrayList<>(); 
        
       public Factura(){
           super();
        }
       
         public Factura(String tipoFactura, String fecha, String nombreEmpresa,
         String direccion, int nit, int codEmpleado){
           super();
           this.idFactura = 0;
           this.tipoFactura = tipoFactura;
           this.fecha = fecha;
           this.nombreEmpresa = nombreEmpresa;
           this.direccion = direccion;
           this.nit = nit;
           this.codEmpleado = codEmpleado;
           
        }

        public String getNombreEmpresa() {
            return nombreEmpresa;
        }

        public void setNombreEmpresa(String nombreEmpresa) {
            this.nombreEmpresa = nombreEmpresa;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public int getNit() {
            return nit;
        }

        public void setNit(int nit) {
            this.nit = nit;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public int getIdVendedor() {
            return idVendedor;
        }

        public void setIdVendedor(int idVendedor) {
            this.idVendedor = idVendedor;
        }

        public int getIdFactura() {
            return idFactura;
        }

        public void setIdFactura(int idFactura) {
            this.idFactura = idFactura;
        }

        public int getCodEmpleado() {
            return codEmpleado;
        }

        public void setCodEmpleado(int codEmpleado) {
            this.codEmpleado = codEmpleado;
        }

        public String getTipoFactura() {
            return tipoFactura;
        }

        public void setTipoFactura(String tipoFactura) {
            this.tipoFactura = tipoFactura;
        }

        // public ArrayList<Movimiento> getDetalleFactura() {
        //     return detalleFactura;
        // }

        // public void setDetalleFactura(ArrayList<Movimiento> detalleFactura) {
        //     this.detalleFactura = detalleFactura;
        // }
        
    }
