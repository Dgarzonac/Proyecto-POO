# Proyecto-POO: Sistema de Gestión para Restaurante

Este repositorio alberga un proyecto centrado en la aplicación avanzada de conceptos de programación orientada a objetos (POO) en Java. A continuación, se detallan las características clave implementadas en el sistema de gestión para un restaurante:

## Principales Características Implementadas:

### Herencia y Clase Abstracta:

La clase abstracta Persona.java sirve como base para las clases Cliente.java y Empleado.java, mientras que las clases Domiciliario.java, Cocinero.java y Mesero.java heredan de la clase Empleado.java.

### Sobrecarga de Métodos:

Se realiza sobrecarga de métodos en varias clases, como en Mesero.java, Domiciliario.java y Cocinero.java. Ejemplo:

```
java
public String puntuacion(){
  return "La puntacion del Mesero es: "+ this.getPuntuacion();
}

public String trabajo(){
  return "Mesero, es quien se encarga de atender y servir a la clientela.";
}
```
### Sobrecarga de Constructores:

La sobrecarga de constructores se implementa en varias clases, permitiendo diferentes formas de inicialización. Ejemplo en Restaurante.java:

```
public Restaurante () {
    this(new ArrayList<>());
}

public Restaurante(List<Mesa> listadoMesas) {
    this(listadoMesas, new ArrayList<>());
}

```
###  Encapsulamiento:

La mayoría de los atributos de las clases son privados, siguiendo los principios de encapsulamiento. Ejemplo en Mesa.java:

```
En Turno.java: public enum Tipo {SEMANA, SABADO, DOMINGO}
En Plato.java: public static final int TIEMPO_DOMICILIO_MINUTOS = 30;
En Material.java: public enum Tipo {TOMATES,CEBOLLAS,PAPAS,ACEITES,VINOS,QUESOS,CHAMPINONES,RES,PESCADOS,CERDOS,POLLOS,PANES,AJOS,ESPECIAS,HUEVOS,ATUN,CUCHARAS,TENEDORES,PLATOS,VASOS};
En Persona.java: protected String nombre; protected Long cedula;
En Empleado.java: protected ArrayList<Turno> turnos;
Y todos los métodos son public, por ejemplo:
En Mesa.java: 
public String resumenMesa () {
        return "Capacidad de la mesa: "+this.getCapacidad()+"\nNúmero de la mesa: "+this.getNumeroMesa();
}
A excepción de:
En Restaurante.java:
private Turno turnoActual() {
		for(Turno turno : this.turnos)
		{
			if(!turno.isCobrado()){
				return turno;}}
		return null;
		}

```
### Ligadura Dinámica:

Ejemplos de ligadura dinámica se observan en Administrador.java al invocar el método detallesEmpleado() de la clase Empleado.java.
```
En Administrador.java:
System.out.print(restaurante.getEmpleados().get(indice).detallesEmpleado()); (línea 363)
System.out.print(restaurante.getAspEmpleados().get(indice1).detallesEmpleado()); (línea 381)

Que invocan el método detallesEmpleado() de “Empleado.java”:
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
Que invocan los métodos puntuación() y trabajo() sobrecargados en “Mesero.java”, “Domiciliario.java” y “Cocinero.java”, por ejemplo:
  public String puntuacion(){
    return "La puntacion del Mesero es: "+ this.getPuntuacion();
  }
  public String trabajo(){
    return "Mesero, es quien se encarga de atender y servir a la clientela.";
  }

```
###  Sobrecarga de constructores:

Aqui se da unis breves ejemplos de sobrecarga de constructores que se implkemento en el proyecto:

```
En Restaurante.java: 
public Restaurante () {
    	this(new ArrayList<>());
    }
public Restaurante(List<Mesa> listadoMesas) {
        this(listadoMesas, new ArrayList<>());
    }
public Restaurante (List<Mesa> listadoMesas, List<Empleado> listadoEmpleados) {
        this(listadoMesas, listadoEmpleados, new ArrayList<>());
    }
public Restaurante (List<Mesa> listadoMesas, List<Empleado> listadoEmpleados, List<Cliente> listadoClientes) {
        this(listadoMesas, listadoEmpleados, listadoClientes, new HashMap<>());
    }
public Restaurante (List<Mesa> listadoMesas, List<Empleado> listadoEmpleados, List<Cliente> listadoClientes, Map<Tipo, Material> inventario) {
        this.listadoMesas = listadoMesas;
        this.listadoEmpleados = listadoEmpleados;
        this.listadoClientes = listadoClientes;
        this.inventario = inventario;
        this.numMesas += contadorListado(listadoMesas);
        this.numEmpleados += contadorListado(listadoEmpleados);
        this.numClientes += contadorListado(listadoEmpleados);
    }


```

# Funcionalidades

## 1. Gestión de Reservas
**Descripción:** Como gerente, puedes crear reservas asignándolas a un cliente (dueño). El sistema maneja dos listas: reservas sin confirmar (sin mesa asignada) y confirmadas (con mesa asignada). Puedes consultar ambas listas, cancelar reservas no confirmadas y confirmar reservas asignándoles una mesa. El programa evita excepciones y realiza validaciones, como afiliar al restaurante al cliente al realizar su primera reserva, gestionar la disponibilidad de mesas, y garantizar que la fecha de reserva sea posterior al día actual.

**Interacciones:**
- Objetos: Restaurante, Mesas, Clientes, Reservas.
- Clases: Mesa, Cliente, Reserva.

## 2. Gestión de Pedidos
**Descripción:** Como administrador, la funcionalidad de gestión de pedidos permite agregar pedidos a través de un menú inteligente. El sistema verifica la disponibilidad de insumos, asigna empleados a los pedidos, y gestiona automáticamente pedidos asociados a reservas. Se clasifican y verifican platos para asignar empleados según su disponibilidad. Los pedidos se dividen en consumo en el restaurante y a domicilio, facilitando la organización y búsqueda.

**Interacciones:**
- Objetos: Restaurante, Empleados, Pedidos.
- Métodos: verificarInsumos, asignarEmpleado, verificarPedido, buscarMesaDisponible.

## 3. Gestión de Empleados
**Descripción:** Como administrador, puedes visualizar listados de empleados contratados y aspirantes disponibles. Detalles como nombre, puesto y turno se proporcionan. La funcionalidad permite contratar empleados de la lista de aspirantes y despedir empleados. Además, puedes agregar y eliminar fichas de aspirantes, incorporándolas a la lista para evaluación antes de la contratación final.

**Interacciones:**
- Objetos: Restaurante, Empleados.
- Métodos: contratarEmpleado, despedirEmpleado, agregarFicha, eliminarFicha.

## 4. Gestión de Recursos
**Descripción:** Esta funcionalidad permite gestionar los recursos del restaurante, como ingredientes, materiales y mesas. Se pueden visualizar los disponibles con sus fechas de caducidad. El usuario puede comprar o desechar materiales e ingredientes, y comprar mesas. El sistema evalúa la disponibilidad de mesas y genera una aleatoriamente si es necesario.

**Métodos:** mostrarIngredientes, mostrarMesas, comprarMaterial, botarMaterial, comprarMesa.

## 5. Gestión Contable
**Descripción:** Esta función ayuda a calcular la parte contable del restaurante. Permite verificar el presupuesto total, calcular los costos de empleados e inventario, y determinar las ganancias brutas y netas. También, se puede calcular el costo promedio de los ingredientes por plato, proporcionando información esencial para la toma de decisiones financieras.

**Métodos:** calcularPresupuesto, calcularCostoEmpleado, calcularCostoMaterial, calcularGananciaBruta, calcularGananciaNeta, calcularCostoPromedio.
