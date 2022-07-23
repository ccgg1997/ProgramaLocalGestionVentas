package Aplicacion.Clases.persona;

public class Persona {
  private String nombre;
  private String direccion;
  private int telefono;
  private int id;

  /**
   * @param nombre
   * @param direccion
   * @param telefono
   * @param id
   */
  public Persona(String nombre, String direccion, int telefono, int id) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.id = id;
  }

  public Persona() {
    this.nombre = "";
    this.direccion = "";
    this.telefono = 0;
    this.id = 0;

  }
}
