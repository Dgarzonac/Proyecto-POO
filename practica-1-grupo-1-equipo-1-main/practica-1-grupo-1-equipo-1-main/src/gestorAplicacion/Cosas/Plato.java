//Componentes: importaciones, constructores, getters y setters, métodos funcionalidades

package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import gestorAplicacion.Cosas.Material.Tipo;
import gestorAplicacion.Personas.Empleado;


public class Plato implements Serializable{
	private static final long serialVersionUID=1L;
    private String nombre;
    private int precio;
    private String descripcion;
    private int tiempoPreparacion;
    private Map<Material, Integer> ingredientes;
    private boolean verificadoInsumos;

    public Plato(String nombre, int precio, String desc, int tiempoPreparacion, Map<Material, Integer> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = ingredientes;
        this.descripcion = desc;
        this.verificadoInsumos=false;
       }
    public Plato(String nombre, int precio, int tiempoPreparacion, Map<Material, Integer> ingredientes) {
    	this(nombre, precio, "Platillo simple", tiempoPreparacion,ingredientes);
    }
    public Plato() {
	}

     // Métodos getter 
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
    	return descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public Map<Material, Integer> getIngredientes() {
        return ingredientes;
    }
    public int getTiempoTotal(ArrayList<Plato> platos){
   	 int tiempoTotal=0;
   	 for(Plato plato : platos){
   		 tiempoTotal+=plato.getTiempoPreparacion();
   	 }
   	 return tiempoTotal;
    }
    // Métodos setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String desc) {
    	this.descripcion=desc;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setIngredientes(Map<Material, Integer> ingredientes) {
        this.ingredientes = ingredientes;
    }

    //Métodos funcionalidades
	public boolean verificarInsumos(Plato plato){
		for(Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()){
			Material ingrediente = entrada.getKey();
			Integer cantidadPlato = entrada.getValue();
			if(ingrediente.getCantidad() < cantidadPlato){
				//se lo deja en false
			}
			if(ingrediente.getCantidad() >= cantidadPlato){
				setVerificadoInsumos(true);
			}
		}
		return verificadoInsumos;
    }
    
    public List<Tipo> mostrarIngredientes(){
    	List<Tipo> tipos= new ArrayList<>();
    	for(Map.Entry<Material, Integer> entry : ingredientes.entrySet()){
    		tipos.add(entry.getKey().getTipo());
    	}
		return tipos;
    }
    
    // Método para obtener el número total de ingredientes
    public int getNumeroDeIngredientes() {
        return ingredientes.size();
    }

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}
	public boolean isVerificadoInsumos() {
		return verificadoInsumos;
	}
	public void setVerificadoInsumos(boolean verificadoInsumos) {
		this.verificadoInsumos = verificadoInsumos;
	}
	
	// Detalles de plato
    public String detallesPlato() {
        return 
        	"\n   Nombre: " + nombre  +
            "\n   Precio: " + precio +
            "\n   Descripcion: " + descripcion  +
            "\n   Tiempo de preparacion: " + tiempoPreparacion +
            "\n   Ingredientes: " + mostrarIngredientes().toString();
    }

}

