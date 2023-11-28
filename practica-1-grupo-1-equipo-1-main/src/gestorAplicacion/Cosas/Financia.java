//Autor: Nicole Guaranguay
//Componentes: importaciones, constructores, getters y métodos funcionalidades

package gestorAplicacion.Cosas;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;
import java.time.LocalDate;

import gestorAplicacion.Cosas.*;
import gestorAplicacion.Personas.Empleado;

public class Financia implements Serializable{
	private static final long serialVersionUID=1L;
	
	private double presupuesto;
	private double gastosMateriales;
	private double gastoMaterialEspecifico;
	private double pagosEmpleados;
	private double gananciasBrutas;
	private double gananciasNetas;
	private double costoPromedioPorPlato;
	private Restaurante restaurante;
	public Financia() {
		this.presupuesto = 1000000;
		this.gastosMateriales = 0;
		this.gastoMaterialEspecifico = 0;
		this.pagosEmpleados = 0;
		this.gananciasBrutas = 0;
		this.gananciasNetas = 0 ;
		this.costoPromedioPorPlato = 0;
	}
	public Financia(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Financia(Restaurante restaurante, double presupuesto, double gastosMateriales,double gastoMaterialEspecifico, double pagosEmpleados, double gananciasBrutas, double gananciasNetas, double liquidacion, double costoPromedioPorPlato) {
	this.restaurante = restaurante;
	this.presupuesto = presupuesto;
	this.gastosMateriales = gastosMateriales;
	this.gastoMaterialEspecifico = gastoMaterialEspecifico;
	this.pagosEmpleados = pagosEmpleados;
	this.gananciasBrutas = gananciasBrutas;
	this.gananciasNetas = gananciasNetas;
	this.costoPromedioPorPlato =costoPromedioPorPlato ;
	
	}
	
	public double getPresupuesto() {
		return presupuesto;
	}
	public double getGastosMateriales() {
		return gastosMateriales;
	}
	public double getGastoMaterialEspecifico() {
		return gastoMaterialEspecifico;
	}
	public double getPagosEmpleados() {
		return pagosEmpleados;
	}
	public double getGananciasBrutas() {
		return gananciasBrutas;
	}
	public double getGananciasNetas() {
		return gananciasNetas;
	}
	public double getCostoPromedioPorPlato() {
		return costoPromedioPorPlato;
	}
	
	 
	//Calcula los Gastos de los Materiales
	
	public double gastosMateriales() {
	    double totalGastosMateriales = 0;
	    for (Pedido pedido : restaurante.getPedidos()) {
	        for (Plato plato : pedido.getPlatos()) {
	            for (Map.Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()) {
	                Material material = entrada.getKey();
	                int cantidadUtilizada = entrada.getValue();
	                totalGastosMateriales += material.getPrecioUnitario() * cantidadUtilizada;
	            }
	        }
	    }
	    this.gastosMateriales = totalGastosMateriales;
	    return this.gastosMateriales;
	}

	 // Calcula el valor de un tipo de material 
	 
	 public double gastoMaterialEspecifico(Material.Tipo tipoMaterial) {
	        double totalGastoMaterial = 0;
	        for (Pedido pedido : this.restaurante.getPedidos()) {
	            for (Plato plato : pedido.getPlatos()) {
	                for (Map.Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()) {
	                    Material material = entrada.getKey();
	                    if (material.getTipo() == tipoMaterial) {
	                        int cantidadUtilizada = entrada.getValue();
	                        totalGastoMaterial += material.getPrecioUnitario() * cantidadUtilizada;
	                    }
	                }
	            }
	        }
	        this.gastoMaterialEspecifico = totalGastoMaterial;  // Almacenar el resultado en la variable de instancia
	        return this.gastoMaterialEspecifico;
	 }


	// Calcula el pago de la liquidacion de un empleado del restaurante
	 
	 public double liquidacionEmpleado(String nombreEmpleado) {
		 Empleado empleado = null;
		    for (Empleado e : restaurante.getEmpleados()) {
		        if (e.getNombre().equals(nombreEmpleado)) {
		            empleado = e;
		            break;
		        }
		    }
		    if (empleado == null) {
		        return -1;
		    }
		    
		    double totalPago = 0;
		    int horasTrabajadas = 0;
		    
		    for (Turno turno : empleado.getTurnos()) {
		        
		        if (turno.isCompletado() && !turno.isCobrado()) {
		            totalPago += turno.getSalario();
		            horasTrabajadas += turno.getHoras();
		            turno.setCobrado(true);
		        }
		    }
		    
		    totalPago += empleado.getSalario();
		    
		    // Convertir las horas trabajadas en días trabajados
		    int diasTrabajados = horasTrabajadas / 8;  // Suponiendo que una jornada laboral es de 8 horas
		    
		    double cesantias = (empleado.getSalario() * diasTrabajados) / 360;
		    double interesesCesantias = (cesantias * diasTrabajados * 0.12) / 360;
		    
		    totalPago += cesantias + interesesCesantias;
		    
		    return totalPago;
		}
	 
	 //Calcula el pago de un solo empleado
	 
	 public double calcularPagoEmpleado(Empleado empleado) {
		    double totalPago = 0;
		    for (Turno turno : empleado.getTurnos()) {
		        double pago = turno.getSalario();
		        double horasExtras = turno.HorasExtras();
		        if (horasExtras > 0) {
		            double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
		            pago += horasExtras * (empleado.getSalario() / turno.getHoras()) * pagoHoraExtra;
		        }
		        totalPago += pago;
		    }
		    return totalPago;
		}
	
	//Calcula el Pago total de todos los Empleados
	 
	    public double pagosEmpleados(Restaurante restaurante) {
	        double totalPago = 0;
	        for (Empleado empleado : restaurante.getEmpleados()) {
	            totalPago += empleado.getSalario();
	            totalPago += liquidacionEmpleado(empleado.getNombre()); // Sumar la liquidación del empleado
	            for (Turno turno : empleado.getTurnos()) {
	                if (turno.isCompletado() && !turno.isCobrado()) {
	                    double horasExtras = turno.HorasExtras();
	                    if (horasExtras > 0) {
	                        double pagoHoraExtra = 1.5; // Supongamos que las horas extras se pagan a 1.5 veces el salario regular por hora
	                        totalPago += horasExtras * (empleado.getSalario() / turno.getHoras()) * pagoHoraExtra;
	                    }
	                }
	            }
	        }
	        this.pagosEmpleados = totalPago;
	        return this.pagosEmpleados;
	    }
	
	// Calcula el costo promedio de los ingredientes por plato.
	    
	    public double costoPromedioPorPlato() {
	        double totalCosto = 0;
	        int totalPlatos = 0;

	        for (Pedido pedido : this.restaurante.getPedidos()) {
	            for (Plato plato : pedido.getPlatos()) {
	                totalPlatos++;
	                for (Map.Entry<Material, Integer> entrada : plato.getIngredientes().entrySet()) {
	                    Material material = entrada.getKey();
	                    int cantidadUtilizada = entrada.getValue();
	                    totalCosto += material.getPrecioUnitario() * cantidadUtilizada;
	                }
	            }
	        }

	        return totalCosto / totalPlatos;
	    }
	    
	// Calcula las ganancias Brutas del restaurante
	    
	public double gananciasBrutas() {
        double totalGananciasBrutas = 0;
        for (Pedido pedido : restaurante.getPedidos()) {
        	totalGananciasBrutas += pedido.getPrecioTotal();
        }
        this.gananciasBrutas = totalGananciasBrutas;
        return this.gananciasBrutas;
    }

    // Calcula las ganancias netas del restaurante
	
    public double gananciasNetas() {
        double totalGastos = gastosMateriales() + pagosEmpleados(restaurante);
        double totalIngresos = gananciasBrutas();
        this.gananciasNetas = totalIngresos - totalGastos;
        return this.gananciasNetas;
    }

    // Calcula el presupuesto considerando las ganancias del restaurante
    
    public double presupuesto() {
        double totalGastos = gastosMateriales() + pagosEmpleados(restaurante);
        double gananciasNetas = gananciasNetas();
        this.presupuesto = this.presupuesto - totalGastos + gananciasNetas;
        return presupuesto;
    }

	
}
