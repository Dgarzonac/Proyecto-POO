//Clase encargada de la interacción con el usuario, uso de switch para escoger funcionalidad, cada una con un switch interno
package uiMain;
import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.sql.rowset.spi.SyncResolver;

import baseDatos.Serializador;
import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.*;

public class Administrador implements Menu {

	static Scanner scan = new Scanner(System.in);
	
	static long readLong() {
		return scan.nextLong();
	}
	static String readln() {
		scan.nextLine();
		return scan.nextLine();
	}
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	//se crea el objeto de gestor que se encarga de asignarle los objetos deserializados al restaurante
    	Gestor gestor=new Gestor();
    	Restaurante restaurante=gestor.getRestaurante();
    	restaurante.setClientes(gestor.getClientes());
    	restaurante.setEmpleados(gestor.getEmpleados());
    	restaurante.setMesas(gestor.getMesas());
    	restaurante.setEmpleadoDelMes(gestor.getEmpleadoDelMes());
    	restaurante.setInventario(gestor.getInventario());
    	restaurante.setPedidos(gestor.getPedidos());
    	//Crear un objeto Financia 
    	
    	Financia financia = new Financia(restaurante);  	
    	
    	ArrayList<Plato> menu=Menu.crearMenu();
    	Material res = new Material(Material.Tipo.RES, 100, 100);
    	Material especias = new Material(Material.Tipo.ESPECIAS, 100, 50);
    	Material aceites = new Material(Material.Tipo.ACEITES, 100, 100);
    	Material pollos = new Material(Material.Tipo.POLLOS, 100, 200);
    	Material vinos = new Material(Material.Tipo.VINOS, 100, 300);
    	Material cebollas = new Material(Material.Tipo.CEBOLLAS, 100, 50);
    	Material champinones = new Material(Material.Tipo.CHAMPINONES, 500, 100);
    	Material ajos = new Material(Material.Tipo.AJOS, 100, 30);
    	Material tomates = new Material(Material.Tipo.TOMATES, 400, 200);
    	Material quesos = new Material(Material.Tipo.QUESOS, 300, 150);
    	Material cerdos = new Material(Material.Tipo.CERDOS, 100, 200);
    	Material atun = new Material(Material.Tipo.ATUN, 100, 250);
    	Material panes = new Material(Material.Tipo.PANES, 200, 50);
    	Material pescados = new Material(Material.Tipo.PESCADOS ,200 ,300 );
    	Material papas = new Material(Material.Tipo.PAPAS ,200 ,100 );
    	Material huevos = new Material(Material.Tipo.PAPAS ,200 ,100 );
    	    	// Crear turnos
    	Turno turno1 = new Turno(Turno.Tipo.SEMANA, 2.0, 50000);
    	Turno turno2 = new Turno(Turno.Tipo.SEMANA, 8.0, 60000);
    	Turno turno3 = new Turno(Turno.Tipo.SEMANA, 2.0, 70000);
    	Turno turno4 = new Turno(Turno.Tipo.DOMINGO, 8.0, 55000);
    	Turno turno5 = new Turno(Turno.Tipo.SEMANA, 2.0, 65000);
    	Turno turno6 = new Turno(Turno.Tipo.SEMANA, 8.0, 75000);
    	Turno turno7 = new Turno(Turno.Tipo.SEMANA, 2.0, 60000);
    	Turno turno8 = new Turno(Turno.Tipo.SEMANA, 8.0, 70000);
    	Turno turno9 = new Turno(Turno.Tipo.SEMANA, 2.0, 80000);
    	Turno turno10 = new Turno(Turno.Tipo.SEMANA, 8.0, 65000);
    	Turno turno11 = new Turno(Turno.Tipo.SEMANA, 3.0, 80000);
    	Turno turno12 = new Turno(Turno.Tipo.SABADO, 7.0, 50000);
    	Turno turno13 = new Turno(Turno.Tipo.SABADO, 3.0, 60000);
    	Turno turno14 = new Turno(Turno.Tipo.SEMANA, 7.0, 70000);
    	Turno turno15 = new Turno(Turno.Tipo.SEMANA, 2.0, 55000);
    	Turno turno16 = new Turno(Turno.Tipo.DOMINGO, 3.0, 55000);
    	Turno turno17 = new Turno(Turno.Tipo.SABADO, 2.0, 55000);
	    
    	/*Empleado empleado1 = new Mesero("Juan", 123456789L, "mesero", restaurante, turno1);
    	empleado1.agregarTurno(turno2);
    	Empleado empleado2 = new Cocinero("Fernando", 234567891L, "cocinero", restaurante, turno2);
    	empleado2.agregarTurno(turno3);
    	Empleado empleado3 = new Domiciliario("Santiago", 345678912L, "domiciliario", restaurante, turno4);
    	empleado1.agregarTurno(turno5);
    	Empleado empleado4 = new Mesero("Jhon", 123456789L, "mesero", restaurante, turno6);
    	empleado1.agregarTurno(turno7);
    	Empleado empleado5 = new Cocinero("Moises", 234567891L, "cocinero", restaurante, turno8);
    	empleado2.agregarTurno(turno9);
    	Empleado empleado6 = new Domiciliario("Rigo", 345678912L, "domiciliario", restaurante, turno10);
    	empleado1.agregarTurno(turno11);
    	Empleado empleado7 = new Mesero("Brayan", 123456789L, "mesero", restaurante, turno12);
    	empleado1.agregarTurno(turno13);
    	Empleado empleado8 = new Cocinero("Felipe", 234567891L, "cocinero", restaurante, turno14);
    	empleado2.agregarTurno(turno15);
    	Empleado empleado9 = new Domiciliario("Martin", 345678912L, "domiciliario", restaurante, turno16);
    	empleado1.agregarTurno(turno17);*/



    	// Crear empleados

    	Pedido pedido = new Pedido();
        Plato plato = new Plato();
    	//mostrarMenu(menu);
    	int opcion, opcion2,opcion3;
		for (Mesa mesa1 : restaurante.getMesas()) {
			mesa1.anadirNumero(mesa1.getNumeroMesa());
		}
		restaurante.borrarReservasViejas();
		
    	do {
    		System.out.println("");
    		System.out.println("Bienvenido al Gestor del Restaurante " + restaurante.getNombre()); // agregar el método getNombre
    		System.out.println("");
    		System.out.println("¿Que función deseas usar?");
    		System.out.println("");
    		System.out.println("1. Gestión de Reserva");
    		System.out.println("2. Gestión de Pedidos");
    		System.out.println("3. Gestión de Empleados");
    		System.out.println("4. Gestión de Inventario");
    		System.out.println("5. Gestión Financiera");
			System.out.println("6. Terminar");
			System.out.println("");
    		System.out.print("Escribe el número de la opción que necesitas: ");
    		opcion = (int) readLong();
    		
    		switch(opcion) {
				case 1: do {
				System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Ver la lista de reservas por confirmar");
				System.out.println("2. Ver la lista de reservas ya confirmadas");
    			System.out.println("3. Crear reserva");
    			System.out.println("4. Cancelar reserva");
    			System.out.println("5. Asignar mesas a las reservas");
    			System.out.println("6. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
				opcion2=(int) readLong();
				switch(opcion2) {
					case 1:	System.out.println("\nListado de reservas");
							System.out.println(restaurante.imprimirReservas());
							break;
					case 2: System.out.println("\nListado de reservas");
							System.out.println(restaurante.imprimirReservas2());
							break;
					case 3: System.out.print("Ingrese la cedula del dueño de la reserva: ");
							Long cedulaDuenoReserva = readLong();
							String nombre = "";
							if (restaurante.verificarCliente(cedulaDuenoReserva)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante");
								System.out.print("Ingrese el nombre del cliente: ");
								nombre = readln();
							}
							else {
								nombre = restaurante.obtenerCliente(cedulaDuenoReserva).getNombre();
							}
							System.out.print("Ingrese el numero de Asistentes: ");
							int numAsistentes = (int) readLong();
							System.out.print("Ingrese el dia de la reserva en formato dia-mes-año: ");
							String diaReserva = readln();
							if (Reserva.revisarFecha(diaReserva)) {
								restaurante.asignarReservaCliente(cedulaDuenoReserva, nombre, numAsistentes, diaReserva);
								System.out.println("Reserva creada");
							}
							else {
								System.out.println("La fecha ingresada no es válida, por favor intente con una fecha posterior a hoy");
							}
							break;
					case 4: System.out.print("Ingrese la cedula del dueño de la reserva a cancelar: ");
							Long cedulaDuenoReserva2 = readLong();
							if (restaurante.verificarCliente(cedulaDuenoReserva2)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante");
							}
							else {
								restaurante.obtenerCliente(cedulaDuenoReserva2).setReserva(null);
								System.out.println("\nReserva cancelada\n");
							}
							break;
					case 5:	System.out.print("Ingrese la cédula del dueño de la reserva: ");
							Long cedulaDuenoReserva3 = readLong();
							if (restaurante.verificarCliente(cedulaDuenoReserva3)) {
								System.out.println("El cliente no se encuentra afiliado al restaurante, por lo que no tiene una reserva");
							}
							else {
								System.out.println("\nMesas válidas para la reserva de "+restaurante.obtenerCliente(cedulaDuenoReserva3).getNombre());
								System.out.println(restaurante.mesasQueCumplen(cedulaDuenoReserva3));
								if (!restaurante.mesasQueCumplen(cedulaDuenoReserva3).equals("\nNo hay mesas válidas para esa reserva\n")) {
								System.out.print("Ingrese el numero de la mesa a la cual desea asignar la reserva: ");
								int numeroMesa = (int) readLong();
								System.out.println(restaurante.confirmarReserva(numeroMesa, cedulaDuenoReserva3));
								}
							}
							break;
					case 6: break;
				} } while(opcion2 != 6);
			break;
			
				case 2: do{
	    			System.out.println("¿Que deseas hacer?");
	    			System.out.println("1. Ver lista de pedidos consumo(restaurante)");
	    			System.out.println("2. Ver lista de pedidos consumo(domicilio)");
	    			System.out.println("3. Añadir pedidos");
	    			System.out.println("4. Volver al menú de funcionalidades");
	    			System.out.print("Escribe el número de la opción que necesitas: ");
	    			opcion3=(int) readLong();
	    			
	    			switch(opcion3) {
	    			
	    			case 1:
	    				System.out.println("-------------------------------------------------------");
		    			System.out.println("\nListado de Pedidos consumo(restaurante)\n");
		    			if (restaurante.getPedidosRestaurante().size()==0)
		    			{System.out.println("\n-No hay pedidos consumo (restaurante)");}
		    			System.out.println(restaurante.imprimirPedidosRestaurante());
		    			break;
		    			
	    			case 2:
	    				System.out.println("\nListado de Pedidos consumo (domicilio)\n");
	    				if(restaurante.getPedidosDomicilio().size()==0)
		    			{System.out.println("\n-No hay pedidos de domicilio");}
		    			System.out.println(restaurante.imprimirPedidosDomicilios());
		    			System.out.println("-------------------------------------------------------");
		    			break;
		    			case 3:
		    				ArrayList<Plato> platosTemp = new ArrayList<Plato>();
		    				// Imprimir el menú
		    				int i1 =0;
		    				for(Plato platof : restaurante.veirificarMenu(menu))
		    				{System.out.println((i1+= 1) + ". "+platof.detallesPlato());}
		    				System.out.println("-------------------------------------------------------");
		    				System.out.print("Por favor, introduce los índices de los platos que deseas (separados por comas): ");
		    				String platos = readln();
		    				String[] indices = platos.split(",");
		    				for (String indice : indices) {
		    				    int i = Integer.parseInt(indice.trim()); // convertir el índice a int		
		    				    platosTemp.add(menu.get(i-1));
		    				}
		    				System.out.print("\nIngrese el tipo de pedido indicando consumo(domicilio o restaurante): ");
		    				String tipoPedido = scanner.nextLine();
		    				System.out.println("Estos son los cocineros disponibles para tu pedido\n");
		    				List<Empleado> cocineros = restaurante.verificarCocineros(restaurante.getEmpleados(),platosTemp);
		    				for(int i = 0; i < cocineros.size(); i++){
		    					System.out.println((i + 1) + ". " + cocineros.get(i));
		    				}
		    				System.out.print("\nIngrese el Nombre del Cocinero: ");
			    			String nombreCocinero = scanner.nextLine();
			    			Empleado cocinero = restaurante.buscarEmpleado(nombreCocinero, "cocinero");
			    			if (cocinero == null) {
			    			System.out.println("Cocinero no encontrado");
			    			System.out.println("-------------------------------------------------------");
		    			    break;
		    			    }
		    				if(tipoPedido.equals("domicilio")){
		    					List<Empleado> domiciliarios = restaurante.verificarDomiciliarios(restaurante.getEmpleados());
			    				System.out.println("Estos son los domiciliarios disponibles para tu pedido\n");
			    				for(int i = 0; i < domiciliarios.size(); i++){
			    					System.out.println((i + 1) + ". " + domiciliarios.get(i));
			    				}
			    			    System.out.print("\nIngrese el Nombre del Domiciliario: ");
			    			    String nombreDomiciliario = scanner.nextLine();
			    			    Empleado domiciliario = restaurante.buscarEmpleado(nombreDomiciliario, "domiciliario");
			    			    if (domiciliario == null) {
			    			        System.out.println("Domiciliario no encontrado");
			    			        break;		    			    }
			    			    else {
			    			    // Se guarda en pedidos ya que en el constructor de pedidos hay im
			    			    Pedido pedidoDomicilio = new Pedido(tipoPedido, cocinero, domiciliario, platosTemp, restaurante);		    			    
			    			    System.out.println("Pedido creado exitosamente");
			    			    pedido.actualizarInventario(restaurante, pedidoDomicilio);
			    			    }
			    			    System.out.println("-------------------------------------------------------");
			    			    
			    			} else if(tipoPedido.equals("restaurante")){
			    				System.out.println("-------------------------------------------------------");
			    				System.out.println("Estos son los meseros disponibles ");
			    				List<Empleado> meseros = restaurante.verificarMeseros(restaurante.getEmpleados());
			    				for(int i = 0; i < meseros.size(); i++){
			    					System.out.println((i + 1) + ". " + meseros.get(i));
			    				}
			    			    System.out.print("\nIngrese el Nombre del Mesero: ");
			    			    String nombreMesero = scanner.nextLine();
			    			    Empleado mesero = restaurante.buscarEmpleado(nombreMesero, "mesero");
			    			    if (mesero == null) {
			    			        System.out.println("Mesero no encontrado");
			    			        break;
			    			    }
			    			    System.out.println("-------------------------------------------------------");
			    			    System.out.print("\nIngrese numero de mesa: ");
			    			    int numMesa = (int)readLong();
			    			    System.out.print("\nIngrese nombre del dueño de reserva : ");
			    			    String nombre = readln();
			    			    Reserva reserva = restaurante.encontrarReserva(numMesa,nombre);
			    			    Mesa mesaTemporal =restaurante.encontrarMesa(numMesa);
			    			    
			    			    if (reserva==null) {
			    			    	System.out.println("\nReserva no encontrada");
			    			    	Pedido ped2 = new Pedido(mesaTemporal, tipoPedido, cocinero, mesero, platosTemp, restaurante);
			    			    	if(!pedido.verificarPedido(restaurante,ped2).equals(null)) {
			    			    		pedido.verificarPedido(restaurante,ped2);
			    			    		System.out.println("pedido creado exitosamente");
					    			    System.out.println("-------------------------------------------------------");
				    			    	
			    			    	}
			    			    	else{System.out.println("\nHay un problema al crear el pedido");
			    			    	System.out.println("-------------------------------------------------------");
			    			    	}
				    			    break;
			    			    	}
			    			    
			    			    else if(reserva!=null){
			    			    	String nombre1 = reserva.getDuenoReserva().getNombre();
			    			    	System.out.println("\nHola, esta reserva esta asociada a " + nombre1);
			    			    	Pedido ped = new Pedido(reserva.getMesa(), tipoPedido, cocinero, mesero, platosTemp, restaurante, reserva);
				    			    ped.setVerificado(true);
				    			    pedido.actualizarInventario(restaurante,ped);
				    			    System.out.println("pedido creado exitosamente");
				    			    System.out.println("\n-------------------------------------------------------");
				    			    break;
			    			    }
			    			    
			    			}
			    			else
			    			{System.out.println("\nTipo de pedido no encontrado");}
			    			//Para reinicializar la lista para mandar
			    			platosTemp = new ArrayList<Plato>();
						break;
		    		case 4: break;
	    			// Volver al menú principal
	    			}}while(opcion3!=4); break;
    		case 3:
		    int opcionEmp, opcionEmp1, opcionEmp2, opcionEmp3, opcionEmp4;
		    do {
		    System.out.println("-------------------------------------------------------");
		    System.out.println("¿Que deseas hacer?");
		    System.out.println("1. Consultar lista de Empleados");
		    System.out.println("2. Consultar lista de Aspirantes a Empleado");
		    System.out.println("3. Agregar ficha de Aspirante a Empleado");
		    System.out.println("4. Eliminar ficha de Aspirante a Empleado");
		    System.out.println("5. Contratar Empleado");
		    System.out.println("6. Despedir Empleado");
		    System.out.println("7. Volver al menú de funcionalidades");
		    System.out.print("Escribe el número de la opción que necesitas: ");
		    opcionEmp= (int) readLong();
		    switch(opcionEmp) {
			
		    case 1:	System.out.println("-------------------------------------------------------"); 
		      		System.out.println("Lista de Empleados: ");
		      		if (restaurante.getEmpleados().size()==0){
						System.out.println("No hay empleados contratados");
		    		} 
			  		else {
					mostrarEmpleados(restaurante.getEmpleados());
		      		System.out.println("Escribe el número del empleado para ver mas detalles");
		      		int num= (int) readLong();
		      		int indice=num-1;
		      		System.out.println("-------------------------------------------------------");
		      		if (indice>=0 && indice<restaurante.getEmpleados().size()) {
						System.out.print(restaurante.getEmpleados().get(indice).detallesEmpleado());
		      		} else {
						System.out.println("El número ingresado no es válido, por favor ingresa un número que corresponda a un empleado");
		      		}
					}
		      		break;
			
		    case 2:	System.out.println("-------------------------------------------------------"); 
		      		System.out.println("Lista de Aspirantes a Empleados: ");
		      		if (restaurante.getAspEmpleados().size()==0){
						System.out.println("No hay aspirantes a empleados");
		      		} else {
						mostrarEmpleados(restaurante.getAspEmpleados());
		      		System.out.println("Escribe el número del aspirante para ver mas detalles");
		      		int num1= (int) readLong();
		      		int indice1=num1-1;
		      		System.out.println("-------------------------------------------------------");
		      		if (indice1>=0 && indice1<restaurante.getAspEmpleados().size()) {
						System.out.print(restaurante.getAspEmpleados().get(indice1).detallesEmpleado());
		    		} else {
						System.out.println("El número ingresado no es válido, por favor ingresa un número que corresponda a un empleado");
		    		}
					}
		      		break;
		
		    case 3: do {
						String nombre, nombre1, nombre2; Long cedula, cedula1, cedula2; Turno turno = null; Turno turnoj = null; Turno turnok = null;
		    			System.out.println("-------------------------------------------------------");
		       			System.out.println("¿Que ficha deseas agregar?");
		       			System.out.println("1. Agregar ficha de Cocinero");
		       			System.out.println("2. Agregar ficha de Mesero"); 
		       			System.out.println("3. Agregar ficha de Domiciliario");
						System.out.println("4. volver a gestión de Empleados");
		       			System.out.print("Escribe el número de la opción que necesitas: ");
		       			opcionEmp1= (int) readLong();
		       			switch(opcionEmp1) {
			 			case 1:	
							System.out.println("-------------------------------------------------------");  
							System.out.println("Ingresa el nombre");
							nombre= readln();
							System.out.println("Ingresa la cedula");
							cedula= readLong();
							System.out.println("Selecciona el turno: ");
							System.out.println("1. Semana");
				       		System.out.println("2. Sabado"); 
				       		System.out.println("3. Domingo");
							opcionEmp2 = (int) readLong();
							switch(opcionEmp2) {
							case 1: 
								turno = turno1;
								break;
							case 2:
								turno = turno12;
								break;
							case 3:
								turno = turno16;
								break;
							case 4:
									break;
							}
							Empleado empleado = new Cocinero(nombre, cedula, "cocinero", restaurante, turno);
							restaurante.getAspEmpleados().add(empleado);
							break;
			 			case 2:	
							System.out.println("-------------------------------------------------------");  
							System.out.println("Ingresa el nombre");
							nombre1 = readln();
							System.out.println("Ingresa la cedula");
							cedula1 = readLong();
							System.out.println("Selecciona el turno: ");
							System.out.println("1. Semana");
				       		System.out.println("2. Sabado"); 
				       		System.out.println("3. Domingo");
			    			opcionEmp3 = (int) readLong();
							switch(opcionEmp3) {
							case 1: 
								turnoj = turno1;
								break;
							case 2:
								turnoj = turno12;
								break;
							case 3:
								turnoj = turno16;
								break;
							case 4:
									break;
							}
			  				Empleado empleado1 = new Mesero(nombre1, cedula1, "mesero", restaurante, turnoj);
			  				restaurante.getAspEmpleados().add(empleado1);
			  				break;
			 			case 3:	
								System.out.println("-------------------------------------------------------");  
			    				System.out.println("Ingresa el nombre");
			    				nombre2= readln();
			    				System.out.println("Ingresa la cedula");
			    				cedula2= readLong();
								System.out.println("Selecciona el turno: ");
								System.out.println("1. Semana");
				       			System.out.println("2. Sabado"); 
				       			System.out.println("3. Domingo");
								turnok = null;
			      				opcionEmp4 = (int) readLong();
							switch(opcionEmp4) {
							case 1: 
								turnok = turno1;
								break;
							case 2:
								turnok = turno12;
								break;
							case 3:
								turnok = turno16;
								break;
							case 4:
									break;
							}
			    			Empleado empleado2 = new Domiciliario(nombre2, cedula2, "domiciliario", restaurante, turnok);
			    			restaurante.getAspEmpleados().add(empleado2);
			    			break;
			 			case 4:
			   					break;
		    		}}while(opcionEmp1!=4);
				break;
		    case 4: System.out.println("-------------------------------------------------------");
			    	System.out.println("Lista de Aspirantes a Empleados: ");
			    	if (restaurante.getAspEmpleados().size()==0){
			        	System.out.println("No hay empleados");
			    	} else {
			        	mostrarEmpleados(restaurante.getAspEmpleados());
			    		System.out.println("Escribe el número de la ficha que desea eliminar");
			    		int num= (int) readLong();
			    		int indice=num-1;
			    		System.out.println("-------------------------------------------------------");
			    		if (indice>=0 && indice<restaurante.getAspEmpleados().size()) {
			        		restaurante.getAspEmpleados().remove(indice);
			    		} else {
			        		System.out.println("El número ingresado no es válido, por favor ingresa un número que corresponda a una ficha");
			    		}
			    	}
			    	break;
				    
		    case 5:	System.out.println("-------------------------------------------------------"); 
		      		System.out.println("Lista de Aspirantes a Empleados: ");
		      		if (restaurante.getAspEmpleados().size()==0){
						System.out.println("No hay aspirantes a empleados");
		      		} else {
						mostrarEmpleados(restaurante.getAspEmpleados());
		      			System.out.println("Escribe el número del aspirante que deseas contratar");
		      			int num2 = (int) readLong();
		      			int indice2 = num2-1;
		      			System.out.println("-------------------------------------------------------");
		      			if (indice2>=0 && indice2<restaurante.getAspEmpleados().size()) {
							restaurante.contratarEmpleado(restaurante.getAspEmpleados().get(indice2));
							restaurante.getAspEmpleados().remove(indice2);
		      			} else {
							System.out.println("El número ingresado no es válido, por favor ingresa un número que corresponda a un empleado");
		      			}
					}
		      		break;
		
		    case 6:	System.out.println("-------------------------------------------------------");
		      		System.out.println("Lista de Empleados: ");
					if (restaurante.getEmpleados().size()==0){
			  			System.out.println("No hay empleados");
					} else {
			  			mostrarEmpleados(restaurante.getEmpleados());
						System.out.println("Escribe el número del empleado que desea despedir");
						int num3= (int) readLong();
						int indice3=num3-1;
						System.out.println("-------------------------------------------------------");
						if (indice3>=0 && indice3<restaurante.getEmpleados().size()) {
			  				restaurante.getEmpleados().remove(indice3);
						} else {
			  				System.out.println("El número ingresado no es válido, por favor ingresa un número que corresponda a un empleado");
						}
					}
					break;
		    case 7:
		      		break;
		    }
		  	}while(opcionEmp!=7); break; 
				
			//funcionalidad gestion inventario (sebastian hoyos)
    		case 4: 
    			int opcionInv = 0;
    			int opcionInv1;
    			int opcionInv2;
    			do {
    			System.out.println("-------------------------------------------------------");
    			System.out.println("¿Que deseas hacer?");
    			System.out.println("1. Consultar Inventario");
    			System.out.println("2. Comprar Materiales");
    			System.out.println("3. Desechar Materiales");
    			System.out.println("4. Volver al menú de funcionalidades");
    			System.out.print("Escribe el número de la opción que necesitas: ");
    			opcionInv=(int) readLong();
    			switch(opcionInv) {
    			//muestra las mesas y materiales que tiene el restaurante
    			case 1:
    				
    				System.out.println("-------------------------------------------------------"); 
    				mostrarIngredientes(restaurante);
    				System.out.println("-------------------------------------------------------");
					mostrarMesas(restaurante);
    				break;
    			//muestra los materiales que tiene el restaurante y permite comprarlos
    			//en caso de comprar una mesa crea una instancia de mesa nueva
    			case 2:
    				
    				do {
    					System.out.println("-------------------------------------------------------");
    					System.out.println("1. ¿Que ingrediente desea comprar?");
    					System.out.println("2. ¿Que material desea comprar?");
    					System.out.println("3. ¿Que mesa deseas comprar?");
    					System.out.println("4. Volver al menú de gestión de inventario");
    					opcionInv1=(int)readLong();
    					switch(opcionInv1) {
    					case 1: 
    						
    						System.out.println("-------------------------------------------------------");
    						mostrarIngredientes(restaurante);
    						System.out.print("Ingrese el ingrediente a comprar: ");
    						System.out.println("\n-------------------------------------------------------");
    						String ingrediente=scan.next().toUpperCase();
    						Material.Tipo ingredienteEnum=Material.Tipo.valueOf(ingrediente);
    						System.out.print("Ingrese la cantidad a comprar: ");
    						System.out.println("\n-------------------------------------------------------");	
    						int cantidad=(int) readLong();
    						System.out.print("Ingrese el precio unitario de dicho ingrediente: ");
    						System.out.println("\n------------------------------------------------------");
    						int precio=(int) readLong();
    						System.out.print("Ingrese la fecha de vencimiento del ingrediente en formato dia-mes-año: ");
    						System.out.println("\n-------------------------------------------------------");
    						String vence = readln();
							if (Reserva.revisarFecha(vence)) {
								restaurante.comprarMaterial(ingredienteEnum,cantidad,precio,vence);
								System.out.println("Se han comprado "+cantidad+" "+ingredienteEnum+" al precio de "+precio+"$ que vencen el "+vence);
							}
							else {
								System.out.println("La fecha ingresada no es válida, por favor intente con una fecha posterior a hoy");
							}
							break;
    				
    				
    					case 2: 
    						System.out.println("-------------------------------------------------------");
    						mostrarIngredientes(restaurante);
    						System.out.println("-------------------------------------------------------");
    						System.out.print("Ingrese el material a comprar: ");
    						System.out.println("\n-------------------------------------------------------");
    						String material=scan.next().toUpperCase();
    						Material.Tipo materialEnum=Material.Tipo.valueOf(material);
    						System.out.print("Ingrese la cantidad a comprar: ");
    						System.out.println("\n-------------------------------------------------------");
    						int cantidad2=(int) readLong();
    						System.out.print("Ingrese el precio de dicho material: ");
    						System.out.println("\n-------------------------------------------------------");
    						int precio2=(int) readLong();
    						restaurante.comprarMaterial(materialEnum,cantidad2,precio2);
    						System.out.println("Se han comprado "+cantidad2+" "+materialEnum+" al precio de "+precio2);
    						break;
    					case 3:
    						mostrarMesas(restaurante);
    						System.out.print("Escriba el numero de la nueva mesa: ");
    						System.out.println("\n-------------------------------------------------------");
    						int numMesa=(int) readLong();
    						System.out.print("Escriba la capacidad de la nueva mesa: ");
    						System.out.println("\n-------------------------------------------------------");
    						int capacidad=(int) readLong();
							if (capacidad > 0) {
								restaurante.comprarMesa(new Mesa(capacidad,numMesa));
							}
    						else {
								System.out.println("Capacidad de la mesa inválida, debe ser mayor a 0");
							}
    						System.out.println("La mesa numero "+numMesa+" con capadidad de "+capacidad+" personas ha sido registrada con éxito");
    						break;
    					case 4:
    						break;
    					}
    				}while(opcionInv1!=4); break;
    				//muestra los materiales que tiene el restaurante y permite eliminarlos
        			//en caso de comprar una mesa, se elimina la instancia de esta mesa
    			case 3:
    				
					do {
    					System.out.println("-------------------------------------------------------");
    					System.out.println("1. ¿Que material vas a desechar?");
    					System.out.println("2. ¿Que mesa vas a desechar?");
    					System.out.println("3. Volver al menú de gestión de inventario");
    					opcionInv2=(int)readLong();
    					switch(opcionInv2) {
    					case 1:  mostrarIngredientes(restaurante);
    						System.out.print("Ingrese el material a desechar: ");
    						String material= scan.next().toUpperCase();
    						System.out.print("Ingrese la cantidad a desechar: ");
    						Material.Tipo materialEnum=Material.Tipo.valueOf(material);
    						int cantidad2=(int) readLong();
    						restaurante.botarMaterial(materialEnum,cantidad2);
    						System.out.println("Se han eliminado "+cantidad2+" "+materialEnum);
    						break;
    					case 2: mostrarMesas(restaurante);
    						System.out.print("Escriba el numero de mesa a desechar: ");
    						System.out.println("\n-------------------------------------------------------");
    						int numMesa=(int) readLong();
    						restaurante.eliminarMesa(numMesa);
    						System.out.println("La mesa numero "+numMesa+" ha sido eliminada con éxito");
    						break;
    					case 3:
    						break;
    					}
    				} while(opcionInv2!=3); break;
    			case 4:
    				break;
    			}
    		}while(opcionInv!=4);break;
    			
    			
  //funcionalidad financiera
    	
    		
    		case 5:
    			int opcionF;
    			int opcionF1;
    			int opcionF2;
    			
    			do {
        			System.out.println("-------------------------------------------------------");
        			System.out.println("¿Que deseas hacer?");
        			System.out.println("1. Consultar el Presupuesto del Restaurante");
        			System.out.println("2. Consultar los Gastos del restaurante");
        			System.out.println("3. Consultar las Ganancias del restaurante");
        			System.out.println("4. Consultar el valor de liquidación de un empleado");
        			System.out.println("5. Consultar cuanto cuesta en promedio preparar cada plato en el Menú");
        			System.out.println("6. Volver al menú de funcionalidades");
        			System.out.print("Escribe el número de la opción que necesitas: ");
        			
        			opcionF = (int) readLong();
					switch(opcionF) {
					
        			case 1:System.out.println("-------------------------------------------------------");
        				
        			// Consultar el presupuesto total del restaurante
        		    	double presupuesto = financia.presupuesto();
        		    	double gastos = financia.gastosMateriales() + financia.pagosEmpleados(restaurante);
        		 
        		    	System.out.println("Presupuesto total del restaurante: " + presupuesto);
        		    	if (presupuesto < gastos) {
        		            System.out.println("¡El presupuesto es inferior a los gastos del restaurante!");
        		        } else {
        		            System.out.println("El presupuesto es mayor que los gastos del restaurante.");
        		        }

        				break;
        			
        			case 2:
        				
        				do {
        					System.out.println("-------------------------------------------------------");
        					System.out.println("1. Costo total de abastecer el Inventario");
        					System.out.println("2. Valor de abastecer un Material del Inventario");
        					System.out.println("3. Pago total de los Empleados");
        					System.out.println("4. Pago de un Empleado");
        					System.out.println("5. Volver al menú de gestión Financiera");
        					System.out.print("Escribe el número de la opción que necesitas: ");
        					
        		
        					opcionF1=(int)readLong();
        					switch(opcionF1) {
        					case 1: 
        						System.out.println("-------------------------------------------------------");
        						double total = financia.gastosMateriales();
        						System.out.println("Costo total de abastecer el Inventario del Restaurante: " + total );
        						
    							break;
        				
        				
        					case 2: 
        						System.out.println("-------------------------------------------------------");
        						System.out.print("Ingrese el nombre del Material : ");
        						String tipoMaterial = scanner.nextLine();
        						Material.Tipo tipo = Material.Tipo.valueOf(tipoMaterial.toUpperCase());

        						double gasto = financia.gastoMaterialEspecifico(tipo);

        						System.out.println("El valor de abastecer el tipo de material " + tipoMaterial + " es " + gasto);
        						
        						break;
        						
        					case 3:
        						System.out.println("-------------------------------------------------------");
        						double pago3 = financia.pagosEmpleados(restaurante);
        						System.out.println("Pago total de los Empleados del Restaurante: " + pago3);
        						
        						break;
        						
        					case 4:
        						System.out.print("Ingrese el nombre del Empleado : ");
        				        String nombreEmpleado = scanner.nextLine();

        				        Empleado empleado = null;
        				        for (Empleado e : restaurante.getEmpleados()) {
        				            if (e.getNombre().equals(nombreEmpleado)) {
        				                empleado = e;
        				                break;
        				            }
        				        }
        				        if (empleado != null) {
        				            double pago = financia.calcularPagoEmpleado(empleado);

        				            System.out.println("El pago para el empleado " + nombreEmpleado + " es " + pago);
        				        } else {
        				            System.out.println("No se encontró al empleado " + nombreEmpleado);
        				        }

        					    break;
        					case 5:
        						break;
        					}
        				} while(opcionF1!=5); break;
        					
        			case 3:
        				
    					do {
        					System.out.println("-------------------------------------------------------");
        					System.out.println("1. Ganancia Bruta");
        					System.out.println("2. Ganancia Neta");
        					System.out.println("3. Volver al menú de gestión Financiera");
        					System.out.print("Escribe el número de la opción que necesitas: ");
        					
        					opcionF2=(int)readLong();
        					switch(opcionF2) {
        					
        					case 1:  
        						System.out.println("-------------------------------------------------------");
        						double pago1 = financia.gananciasBrutas();
        						System.out.println("La Ganancia Bruta del Restaurante : " + pago1);
        						
        						break;
        						
        					case 2: 
        						System.out.println("-------------------------------------------------------");
        						double pago2 = financia.gananciasNetas();
        						System.out.println("La Ganancia Neta del Restaurante : " + pago2 );
        						
        						break;
        					case 3:break;
        					}
        				} while(opcionF2!=3); break;
        			case 4:
        				System.out.println("-------------------------------------------------------");
						System.out.print("Ingrese el nombre del Empleado : ");
						String nombreEmpleado =scanner.nextLine();
						double liquidacion = financia.liquidacionEmpleado(nombreEmpleado);

					    if (liquidacion != -1) {
					        System.out.println("La liquidación del empleado " + nombreEmpleado + " es " + liquidacion);
					    } else {
					        System.out.println("No se encontró al empleado " + nombreEmpleado);
					    }

					    break;
        				
        			case 5:
        				double costoPlato = financia.costoPromedioPorPlato();
        				System.out.println("Cuesta en promedio preparar cada plato en el Menú: " + costoPlato);
        				break; 
        			case 6: break;
        				
				}	
    		} while (opcionF!=6); break;
    		case 6: 
    			//ejecuta el metodo para cerrar el programa y serializar los objetos
    			salirDelSistema(gestor);
			break;
    	} 
    
    		} while(opcion!=6);}


    //metodo utilizado para mostrar todas las mesas del restaurante
    public static void mostrarMesas(Restaurante restaurante) {
    	System.out.println("Mesas del restaurante: ");
    	for (Mesa mesa:restaurante.getMesas()) {
    		System.out.println("Mesa: " + mesa.getNumeroMesa()+" con Capacidad de: "+mesa.getCapacidad()+" personas");
    		System.out.println("-------------------------------------------------------");
    	}
    }
    //metodo utilizado para mostrar todos los materiales del inventario
    public static void mostrarIngredientes(Restaurante restaurante) {   	
    	if (restaurante.getInventario().size()==0) {
    		System.out.println("No hay materiales en el inventario");
    	}
    	for (Material material: restaurante.getInventario().values()) {
    		if(material.getFechaVencimiento()!=null) {
    			System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nFecha de Vencimiento: "+material.getFechaVencimiento()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    			System.out.println("-------------------------------------------------------");
    		}else {
    			System.out.println("Tipo: "+material.getTipo() + "\nCantidad: "+material.getCantidad()+"\nFecha de Vencimiento: "+material.fechaMaterial()+"\nPrecio por unidad: "+material.getPrecioUnitario());
    			System.out.println("-------------------------------------------------------");
    		}
    	}
    }
    //metodo utilizado para mostrar los platos del menu
    public static void mostrarMenu(ArrayList<Plato> menu) {
    	short cont=1;
    	for (Plato plato:menu) {
    		System.out.println(cont+". "+plato.detallesPlato());
    		cont++;
    	}
    }
    //metodo especializado para serializar los objetos del programa cuando se cierra el programa
    private static void salirDelSistema(Gestor gestor) {
    	System.out.println("Vuelva pronto");
    	Serializador.serializar(gestor);
    	System.exit(0);
    
    }
	//Metodo para mostrar algunos datos de los empleados
	private static void mostrarEmpleados(List<Empleado> empleados) {
	  short cont=1;
	  for (Empleado e : empleados) {
	    System.out.println(cont + ". Nombre: " + e.getNombre() + " - Puesto: " + e.getPuesto() + " - Turno: " + e.getTurnos().get(0).getTipo());
	    cont++;
	  }
	}
}
