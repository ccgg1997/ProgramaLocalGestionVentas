package Aplicacion.Clases.empresa;

public class Empresa {
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


}
