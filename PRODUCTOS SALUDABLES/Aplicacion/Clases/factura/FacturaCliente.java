package Aplicacion.Clases.factura;

public class FacturaCliente extends Factura{
        private int idCliente;
        private int cedula;
        private String nombreCliente;
        
        public FacturaCliente(){    
            super();
            this.idCliente = 0;
            this.cedula = 0;
            this.nombreCliente = null;
        }

        public int getIdCliente() {
            return idCliente;
        }

        public void setIdCliente(int idCliente) {
            this.idCliente = idCliente;
        }

        public int getCedula() {
            return cedula;
        }

        public void setCedula(int cedula) {
            this.cedula = cedula;
        }

        public String getNombreCliente() {
            return nombreCliente;
        }

        public void setNombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
        }
        
}
