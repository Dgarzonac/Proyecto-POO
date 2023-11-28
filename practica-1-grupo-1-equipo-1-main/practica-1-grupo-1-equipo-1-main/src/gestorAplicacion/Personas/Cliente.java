//Componentes: Importaciones, constructores, getters y setters

package gestorAplicacion.Personas;
import java.io.Serializable;
import gestorAplicacion.Cosas.*;

public class Cliente extends Persona implements Serializable{
	private static final long serialVersionUID=1L;
	private Reserva reserva;
    private Pedido pedido;

	public Cliente() {
	}
    public Cliente(String nombre, Long cedula) {
		super(nombre, cedula);
	}
	public Reserva getReserva() {
		return this.reserva;
	}
	public void setReserva (Reserva reserva) {
		this.reserva = reserva;
	}
	public Pedido getPedido() {
		return this.pedido;
	}
	public void PedirComida(Pedido pedido) {
		this.pedido = pedido;
	}
	public String puntuacion() {
		return "El cliente "+this.getNombre() +" no tiene puntuacion";
	}
	
}
