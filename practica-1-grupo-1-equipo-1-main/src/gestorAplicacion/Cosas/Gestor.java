//Autor: Sebastián Hoyos. Se encarga de la serialización.

package gestorAplicacion.Cosas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import baseDatos.Deserializador;
import gestorAplicacion.Cosas.Material.Tipo;
import gestorAplicacion.Personas.Cliente;
import gestorAplicacion.Personas.Empleado;


public class Gestor implements Serializable{
	private static final long serialVersionUID=1L;
	//Se crean listas vacias que se encargaran de soportar los objetos serializados/deserializados
	private Restaurante restaurante=new Restaurante();
	private List<Cliente> clientes=new ArrayList<>();
	private List<Empleado> empleados=new ArrayList<>();
	private List<Mesa> mesas=new ArrayList<>();
	private Empleado empMes;
	private Map<Tipo,Material> inventario=new HashMap<>();
	private ArrayList<Pedido> pedidos=new ArrayList<>();
	
	//getters y setters
	public Empleado getEmpleadoDelMes() {
		return this.empMes;
	}

	public void setEmpleadoDelMes(Empleado empMes) {
		this.empMes = empMes;
	}

	public Gestor() {
		Deserializador.deserializar(this);
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Mesa> getMesas() {
		return this.mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	public  Restaurante getRestaurante() {
		return this.restaurante;
	}

	public Map<Tipo,Material> getInventario() {
		return this.inventario;
	}
	public void setInventario(Map<Tipo,Material> inv) {
		this.inventario=inv;
	}
	public ArrayList<Pedido> getPedidos(){
		return this.pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos=pedidos;
	}
	
	//metodos para simular constructores para los objetos
	public Cliente nuevoCliente(String nombre,long cedula) {
		Cliente nuevoCliente=new Cliente(nombre,cedula);
		clientes.add(nuevoCliente);
		return nuevoCliente;
	}
	public Empleado nuevoEmpleado(String nombre,Long cedula,String puesto,Restaurante restaurante,Turno turno) {
		Empleado nuevoEmpleado = new Empleado(nombre,cedula,puesto,restaurante,turno);
		empleados.add(nuevoEmpleado);
		return nuevoEmpleado;
	}
	
	public Mesa nuevaMesa(int capacidad,int numeromesa) {
		Mesa nuevaMesa= new Mesa(capacidad,numeromesa);
		mesas.add(nuevaMesa);
		return nuevaMesa;
	}
	
	
}
