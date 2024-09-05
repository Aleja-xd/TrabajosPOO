package uniandes.dpoo.aerolinea.modelo;

public class Avion {
  private int capacidad;
  /**
   * La capacidad del avión
   */
  private java.lang.String nombre;
  /**
   * El nombre con el que se identifica al avión
 * @return 
   */
  public Avion(java.lang.String nombre,int capacidad){
	        this.nombre = nombre;
	        this.capacidad = capacidad;
	    }

  /**
   * Obtiene el nombre del avión.
   *
   * @return El nombre del avión.
   */
  public String getNombre() {
      return nombre;
  }

  /**
   * Obtiene la capacidad del avión.
   *
   * @return La capacidad del avión.
   */
  public int getCapacidad() {
      return capacidad;
  }
}

