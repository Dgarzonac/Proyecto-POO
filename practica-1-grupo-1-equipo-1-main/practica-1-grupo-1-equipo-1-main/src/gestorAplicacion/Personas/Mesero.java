package gestorAplicacion.Personas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import gestorAplicacion.Cosas.Restaurante;
import gestorAplicacion.Cosas.Turno;

public class Mesero extends Empleado implements Serializable{
  private static final long serialVersionUID = 1L;

  public Mesero() { }
  public Mesero(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
      super(nombre, cedula, puesto, restaurante, turno);
   // Inicializa la lista de turnos
      this.turnos = new ArrayList<>();
   // Añade el turno a la lista
      this.turnos.add(turno); 
      this.setFechaContratacion(new Date()); 
  }

  //Metodo para mostrar la puntuacion del Empleado
  public String puntuacion(){
    return "La puntacion del Mesero es: "+ this.getPuntuacion();
  }

  //Metodo para mostrar la descripcion del trabajo del Empleado
  public String trabajo(){
    return "Mesero, es quien se encarga de atender y servir a la clientela.";
  }
}
