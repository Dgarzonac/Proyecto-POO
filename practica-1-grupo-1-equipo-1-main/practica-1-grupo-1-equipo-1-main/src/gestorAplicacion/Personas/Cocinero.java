package gestorAplicacion.Personas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import gestorAplicacion.Cosas.Restaurante;
import gestorAplicacion.Cosas.Turno;

public class Cocinero extends Empleado implements Serializable{
  private static final long serialVersionUID = 1L;

  public Cocinero() { }
  public Cocinero(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
      super(nombre, cedula, puesto, restaurante, turno);
   // Inicializa la lista de turnos
      this.turnos = new ArrayList<>();
   // Añade el turno a la lista
      this.turnos.add(turno); 
      this.setFechaContratacion(new Date()); 
  }

  //Metodo para mostrar la puntuacion del Empleado
  public String puntuacion(){
    return "La puntacion del Cocinero es: "+ this.getPuntuacion();
  }

  //Metodo para mostrar la descripcion del trabajo del Empleado
  public String trabajo(){
    return "Cocinero, es quien cocina y prepara alimentos en el restaurante.";
  }
}
