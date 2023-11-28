package gestorAplicacion.Personas;
import java.io.Serializable;
public abstract class Persona implements Serializable {
	private static final long serialVersionUID=1L;
	protected String nombre;
	protected Long cedula;
	
	public Persona() {}
	
    public Persona(String nombre,Long cedula) {
        this.nombre = nombre;
        this.cedula=cedula;
    }
    // Metodos getters
	public String getNombre() {
		return nombre;
	}
	public Long getCedula() {
		return cedula;
	}
	// Metodos setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public abstract String puntuacion();
}
