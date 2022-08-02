package Aplicacion.formaDePago;

public class FormaDePago {
        private int codigo;
        private int valor;
        /**
         * @param codigo
         * @param codigo
         */
        public FormaDePago(int codigo, int valor) {
          this.codigo = codigo;
          this.valor = valor;
        }
      
        public FormaDePago() {
          this.codigo =0;
          this.valor = 0;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        
}
