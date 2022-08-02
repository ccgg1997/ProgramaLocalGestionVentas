package Aplicacion.Clases.factura;

public class FacturaProveedor extends Factura{
        private int idProveedor;
        private String nombreProveedor;
        
        public FacturaProveedor(){    
            super();
            this.idProveedor = 0;
            this.nombreProveedor = null;
        }

        public int getIdProveedor() {
            return idProveedor;
        }

        public void setIdProveedor(int idProveedor) {
            this.idProveedor = idProveedor;
        }

        public String getNombreProveedor() {
            return nombreProveedor;
        }

        public void setNombreProveedor(String nombreProveedor) {
            this.nombreProveedor = nombreProveedor;
        }

        
}
