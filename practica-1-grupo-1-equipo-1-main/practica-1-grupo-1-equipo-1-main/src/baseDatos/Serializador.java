package baseDatos;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import uiMain.Administrador;
import gestorAplicacion.Cosas.Financia;
import gestorAplicacion.Cosas.Material;
import gestorAplicacion.Cosas.Mesa;
import gestorAplicacion.Cosas.Pedido;
import gestorAplicacion.Cosas.Plato;
import gestorAplicacion.Cosas.Reserva;
import gestorAplicacion.Cosas.Restaurante;
import gestorAplicacion.Cosas.Turno;
import gestorAplicacion.Personas.Persona;
import gestorAplicacion.Personas.Cliente;
import gestorAplicacion.Personas.Empleado;
import gestorAplicacion.Cosas.Gestor;

public class Serializador {
	public static void serializar(Gestor gestor) {
		serializarClientes(gestor, new File("src\\baseDatos\\temp\\Clientes.txt"));
		serializarEmpleados(gestor, new File("src\\baseDatos\\temp\\Empleados.txt"));
		serializarMesas(gestor, new File("src\\baseDatos\\temp\\Mesas.txt"));
		serializarEmpleadoDelMes(gestor, new File("src\\baseDatos\\temp\\EmpleadoDelMes.txt"));
		serializarInventario(gestor,  new File("src\\baseDatos\\temp\\Inventario.txt"));
		serializarPedidos(gestor,new File("src\\baseDatos\\temp\\Pedidos.txt"));
	}
	public static void serializarPedidos(Gestor gestor,File ruta) {
		try {
			PrintWriter pw=new PrintWriter(ruta);
			FileOutputStream fos=new FileOutputStream(ruta);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(gestor.getPedidos());
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Error en la serialización "+ e);
		}
	}
	public static void serializarClientes(Gestor gestor,File ruta) {
		try {
			PrintWriter pw=new PrintWriter(ruta);
			FileOutputStream fos=new FileOutputStream(ruta);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(gestor.getClientes());
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Error en la serialización "+ e);
		}
	}
	public static void serializarEmpleados(Gestor gestor,File ruta) {
		try {
			PrintWriter pw=new PrintWriter(ruta);
			FileOutputStream fos=new FileOutputStream(ruta);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(gestor.getEmpleados());
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Error en la serialización "+ e);
		}
	}
	public static void serializarMesas(Gestor gestor,File ruta) {
		try {
			PrintWriter pw=new PrintWriter(ruta);
			FileOutputStream fos=new FileOutputStream(ruta);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(gestor.getMesas());
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Error en la serialización "+ e);
		}
	}
	public static void serializarEmpleadoDelMes(Gestor gestor,File ruta) {
		try {
			PrintWriter pw=new PrintWriter(ruta);
			FileOutputStream fos=new FileOutputStream(ruta);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(gestor.getEmpleadoDelMes());
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Error en la serialización "+ e);
		}
	}
	public static void serializarInventario(Gestor gestor,File ruta) {
		try {
			PrintWriter pw=new PrintWriter(ruta);
			FileOutputStream fos=new FileOutputStream(ruta);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(gestor.getInventario());
			oos.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Error en la serialización "+ e);
		}
	}
	
}

