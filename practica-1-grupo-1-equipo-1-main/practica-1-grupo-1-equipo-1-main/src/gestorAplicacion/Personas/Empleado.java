//Componentes: Importaciones, constructores, getters y setters, y métodos de las funcionalidades

package gestorAplicacion.Personas;
import java.util.Date;
import java.util.List;

import gestorAplicacion.Cosas.Material;
import gestorAplicacion.Cosas.Mesa;
import gestorAplicacion.Cosas.Pedido;
import gestorAplicacion.Cosas.Plato;
import gestorAplicacion.Cosas.Restaurante;
import gestorAplicacion.Cosas.Turno;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID=1L;
    protected ArrayList<Turno> turnos;
    private Turno turno;
    private String puesto;
    private double salario;
    private Date fechaContratacion;
    private Restaurante restaurante;
    private int puntuacion;
    
    public Empleado() {
    	
    }
    public Empleado(String nombre, Long cedula, String puesto, Restaurante restaurante, Turno turno){
        super(nombre, cedula);
        this.puesto = puesto;
        this.restaurante = restaurante;
     // Inicializa la lista de turnos
        this.turnos = new ArrayList<>();
     // Añade el turno a la lista
        this.turnos.add(turno); 
        this.setFechaContratacion(new Date()); 
    }
    
    // Metodos getter
	public Turno getTurno() {
		return turno;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	
	// Métodos setter
	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}
	
	public void setTurno(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Restaurante getRestaurante() {
		return this.restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante=restaurante;
	}
	public int getPuntuacion() {
	    return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
	    this.puntuacion = puntuacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
    // Metodos de funcionalidades
    // Verificar Tiempo
	public  String clasificarDia(LocalDate fecha) {
        DayOfWeek diaDeLaSemana = fecha.getDayOfWeek();
        switch (diaDeLaSemana) {
            case SATURDAY:
                return "SABADO";
            case SUNDAY:
                return "DOMINGO";
            default:
                return "SEMANA";
        }
    }

	// Para verificar tiempo de el cocinero
	public boolean verificarTiempo(Empleado empleado,double tiempoPreparacion){
	    LocalDate fechaActual = LocalDate.now();
	    String dia = clasificarDia(fechaActual);
	    for (Turno turno : empleado.getTurnos()) {
	        if (turno.getTipo().toString().equals(dia)){
	            if(!turno.isCobrado()){
	                double tiempoDisponible = turno.getHoras() * 60;
	                double tiempoPreparacionFloat = tiempoPreparacion;
	                if(tiempoDisponible > tiempoPreparacionFloat){
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}

    // Metodo apra verificar tiempo de domiciliario y mesero
    public boolean verificarTiempo(Empleado empleado){
    	LocalDate fechaActual = LocalDate.now();
    	String dia = clasificarDia(fechaActual);
    	if(empleado.getPuesto().equals("domiciliario")){
    	for (Turno turno : empleado.getTurnos()) {
    		if (turno.getTipo().toString().equals(dia)){
    		if(!turno.isCobrado()){
    			double tiempoDisponible = turno.getHoras()* 60; 
    			if( tiempoDisponible > Pedido.TIEMPO_DOMICILIO ){
    				return true;}
    			}}
    	}
    	}
    	if(empleado.getPuesto().equals("mesero")){
    		for (Turno turno : empleado.getTurnos()) {
    			if (turno.getTipo().toString().equals(dia)){
        		if(!turno.isCobrado()){
        			double tiempoDisponible = turno.getHoras()* 60; 
        			if( tiempoDisponible > Pedido.TIEMPO_MESERO )
        			{
        				return true;
        				}
        			}
        		}
    		}
    	}
    	
		return false;
    	}
	
	//metodo que permite reportar daños a un material no organico
	public void reportarDano(Material.Tipo material,int cantidad) {
		this.restaurante.botarMaterial(material, cantidad);
	}

	// Este metodo verifica si un turno esta completado y no cobrado 
	// Para que se le agregué al salario total
    public void turnosCompletados(Empleado empleado){
		for(Turno turno : empleado.getTurnos()){
			if (turno.isCompletado()==true & turno.isCobrado()==false){
					turno.setCobrado(true);
					empleado.setSalario(turno.getSalario());
					}
			}
		}
    //Retornar turno no cobrado
	private Turno turnoActual() {
		for(Turno turno : this.turnos)
		{
			if(!turno.isCobrado()){
				return turno;}}
		return null;
		}
	// toString de la clase
	public String toString(){
		return "Nombre: " + this.getNombre()+ " Puesto: "+ this.getPuesto()  ;
	}
	
	// Alterar turno
    public void agregarTurno(Turno turno){
		this.turnos.add(turno);
	}
	//Metodo para mostrar la puntuacion del Empleado
	public String puntuacion(){
	  return "La puntacion del Empleado es: "+ this.getPuntuacion();
	}

	//Metodo para mostrar la descripcion del trabajo del Empleado
	public String trabajo(){
	  return "Empleado del restaurante";
	}
	//Metodo para mostrar detalles de los empleados
	public String detallesEmpleado(){
		return 
		  "Nombre: " + this.getNombre()+
		  "\nCedula: " + this.getCedula()+
		  "\nPuesto: " + this.getPuesto()+
		  "\nTurno: " + this.getTurnos().get(0).getTipo()+
		  "\nSalario: " + this.getTurnos().get(0).getSalario()+		  
		  "\n"+this.puntuacion()+

		  "\n"+this.trabajo()+"\n";
	  }
	
}
