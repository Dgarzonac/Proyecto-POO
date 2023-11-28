//Autor: Daniel Garzón. Usada para manejo ded pedidos, se relaciona con empelado, material, platos y turnos
//Componentes: importaciones, constructores, métodos funcionalidades

package gestorAplicacion.Cosas;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import gestorAplicacion.Personas.Empleado;
import uiMain.Menu;

public class Pedido implements Serializable,Menu{
	private static final long serialVersionUID=1L;
    private Mesa mesa;
    private Empleado cocinero;
    private Empleado mesero;
    private Empleado domiciliario;
    private Reserva reserva;
    private ArrayList<Plato> platos;
    private Restaurante restaurante;
    public static final int TIEMPO_DOMICILIO = 45;
    public static final int TIEMPO_MESERO = 30;
    private boolean verificado = false; // Segun este atributo se van a mostrar y se van a dividir en pedidos verificados y no verificados
	private String tipoPedido;
	
	public Pedido () {
	}
	
	// Estos constructores estan para que donde no se le asigne un array para platos se cree un por default vacio
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario, Restaurante restaurante) {
	    this(null, tipoPedido, cocinero, null, new ArrayList<Plato>(), restaurante);
	    this.domiciliario=domiciliario;
	}
	
	public Pedido (Mesa mesa,String tipoPedido, Empleado cocinero, Empleado mesero, Restaurante restaurante) {
	    this(mesa, tipoPedido, cocinero, mesero, new ArrayList<Plato>(), restaurante);
	}
	
	public Pedido (Mesa mesa,String tipoPedido, Empleado cocinero, Empleado mesero, ArrayList<Plato> platos, Restaurante restaurante, Reserva reserva) {
	    this(null, tipoPedido, cocinero, null, platos, restaurante);
	    this.reserva=reserva;
	}
	
	// Estos constructores estan para si se les da unos platos para inicializarlo
	public Pedido (String tipoPedido, Empleado cocinero, Empleado domiciliario, ArrayList<Plato> platos, Restaurante restaurante) {
	    this(null, tipoPedido, cocinero, null, platos, restaurante);
	    this.domiciliario=domiciliario;
	}
	
	// Constructor con todos los atributos
	public Pedido(Mesa mesa, String tipoPedido, Empleado cocinero, Empleado mesero, ArrayList<Plato> platos, Restaurante restaurante) {
	    this.mesa = mesa;
	    this.tipoPedido = tipoPedido;
	    this.cocinero = cocinero;
	    this.mesero = mesero;
	    this.platos = platos;
	    this.verificado = false;
	    this.restaurante = restaurante;
	    restaurante.agregarPedido(this);
	}

    
   // Metdos para Administrador

    
    // Metodo para realizar llamada multiple a metodos de actualizar inventario
    public void actualizarInventario(Restaurante restaurante,Pedido pedido) {
		restaurante.actualizarTiempoEmpleados(pedido);
		restaurante.actualizarInsumos(pedido);}
    
    //Metodo para verificar pedido
	public Mesa verificarPedido(Restaurante restaurante,Pedido pedido) {
		Mesa mesa = restaurante.buscarMesaDisponible();
		pedido.setMesa(mesa);
		pedido.setVerificado(true);
		actualizarInventario(restaurante,pedido);
		return mesa;}
	
     public void removerPlato(Plato plato) {
         this.platos.remove(plato);
     }
     


     
     // Metodos setters
     public void agregarPlato(Plato plato) {
         this.platos.add(plato);
     }
     
     public void setMesa(Mesa mesa){
    	 this.mesa = mesa;
     }
     
     public boolean isVerificado() {
         return verificado;
     }

     public void setVerificado(boolean verificado) {
         this.verificado = verificado;
     }
     //Metodos getters
     public  ArrayList<Plato> getPlatos(){
    	 return this.platos;
     }
     public Empleado getCocinero() {
    	 return this.cocinero;
     }
     public Empleado getMesero() {
    	 return this.mesero;
     }
     public Empleado getDomiciliario() {
    	 return this.domiciliario;
     }
     public double getPrecioTotal() {
         int precioTotal = 0;
         for (Plato plato : this.getPlatos()) {
             precioTotal += plato.getPrecio();
         }
         return precioTotal;
     }
     
     public double getTiempoTotal() {
         float tiempoTotal = 0;
         for (Plato plato : this.getPlatos()) {
        	 tiempoTotal += plato.getTiempoPreparacion();
         }
         return tiempoTotal;
     }
     
     // Metodos para imprimir strings de platos de pedido
     public String imprimirPlatos(){
    	 String stringPlatos = "";
    	 int i =0;
    	 for(Plato plato : this.getPlatos()){
    			 i+=1;
    			 stringPlatos+="\n   "+"Plato numero: "+i+plato.detallesPlato()+"\n";
         	}
		return stringPlatos;
     	}
     // Metodo toString
	@Override
    public String toString() {
   	 String mesaStr = (mesa != null) ? mesa.toString() : "N/A";
        String meseroStr = (mesero != null) ? mesero.getNombre() : "N/A";
        String domiciliarioStr = (domiciliario != null) ? domiciliario.getNombre() : "N/A";
        String resumen = (reserva != null) ? reserva.resumenReservaPedido() : "no tiene reserva asociada";
        

        return "mesa: " + mesa +
                "\n   cocinero: " + cocinero.toString() +
                "\n   mesero: " + meseroStr +
                "\n   domiciliario: " + domiciliarioStr +
                "\n   numero de platos: " + this.getPlatos().size()+ 
                "\n   platos: " + imprimirPlatos() +
                "\n   Este pedido tiene esta reserva: " + resumen+
                "\n   tipoPedido: " + tipoPedido ;
    }


}
