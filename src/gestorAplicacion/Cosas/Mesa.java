//Autor: Samuel Ortiz, almacena las reservas en base a su capacidad
//Componentes: importaciones, constructor, getters y setters, métodos funcionalidades

package gestorAplicacion.Cosas;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Mesa implements Serializable{
	private static final long serialVersionUID=1L;
    private static List<Integer> numeroMesas = new ArrayList<>();
    private int capacidad;
    private List<Reserva> reservas = new ArrayList<>();
    private boolean ocupada;
    private int numeroMesa;

    //Constructor
    public Mesa (int capacidad, int numeroMesa) {
        this.capacidad = capacidad;
        if (Mesa.verificarNumero(numeroMesa)) {
            this.numeroMesa = Mesa.generarNumeroMesa();
        }
        else {
            this.numeroMesa = numeroMesa;
        }
        this.ocupada = false;
        Mesa.numeroMesas.add(this.numeroMesa);
    }
    
    //Metodos getter
    public static List<Integer> getNumeroMesas() {
        return numeroMesas;
    }
    public int getCapacidad () {
        return this.capacidad;
    }
    public List<Reserva> getReservas () {
        return this.reservas;
    }
    public boolean isOcupada () {
        return this.ocupada;
    }
    public int getNumeroMesa () {
        return this.numeroMesa;
    }

    //Metodos setter
    public void setCapacidad (int nuevaCapacidad) {
        this.capacidad = nuevaCapacidad;
    }
    public void setReservas(List<Reserva> reservas) {
    	this.reservas=reservas;
    }
    public void setOcupada (boolean ocupacion) {
        this.ocupada = ocupacion;
    }
    public void setNumeroMesa (int numeroMesa) {
        if (!Mesa.verificarNumero(numeroMesa)) {
            this.numeroMesa = numeroMesa;
        }
    }
    public void anadirNumero(int a) {
        Mesa.getNumeroMesas().add(a);
    }

    //Metodos funcionalidades

    //Indica si la mesa tiene sillas suficientes para la reserva
    public boolean suficienteCapacidad(Reserva reserva) {
        if (this.capacidad >= reserva.getNumeroAsistentes()) {
            return true;
        }
        else {
            return false;
        }
    }

    //a la mesa se le asigna una reserva
    public void reservarMesa (Reserva reserva) {
            this.reservas.add(reserva);
            reserva.setMesa(this);
    }

    //revisa si la mesa ya tiene una reserva para el día de la reserva pasado por parámetro
    public boolean mesaCompatible(Reserva reserva) {
        for (Reserva reserva1 : reservas) {
            if (reserva1.getDiaReserva().isEqual(reserva.getDiaReserva())) {
                return false;
            }
        }
        return true;
    }

    //Borra las reservas confirmadas que tengan una fecha anterior a hoy
    public void borrarReservasViejas() {
        LocalDate fechaActual = LocalDate.now();
        Iterator<Reserva> iterador = reservas.iterator();
        while (iterador.hasNext()) {
            Reserva reserva = iterador.next();
            if (reserva.getDiaReserva().isBefore(fechaActual)) {
                iterador.remove(); // Elimina el elemento de la lista de reservas
            }
        }
    }

    //Da la informacion de la mesa, para escoger cual mesa reservar
    public String resumenMesa () {
        return "Capacidad de la mesa: "+this.getCapacidad()+"\nNúmero de la mesa: "+this.getNumeroMesa();
    }
    
    public String toString(){
    	return "mesa numero: " + numeroMesa + " con capacidad: " + capacidad; 
    }

    //Metodos de clase
    //de ser necesario, asigna numeros aleatorios a las mesas para que no hayan numeros repetidos de mesas
    public static int generarNumeroMesa() {
        int numeroAleatorio;
        do {
            Random rand = new Random();
            numeroAleatorio = rand.nextInt(1000) + 1;
        } while (Mesa.verificarNumero(numeroAleatorio));
        return numeroAleatorio;
    }

    //revisa si existe una mesa con el numero pasado por parametro
    public static boolean verificarNumero(int numero) {
        if (Mesa.numeroMesas.contains(numero)) {
            return true;
        }
        else {
            return false;
        }
    }
}