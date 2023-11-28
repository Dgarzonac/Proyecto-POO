//Componenetes: importaciones, constructor, getters y setters, métodos de funcionalidades (de instancia y de clase)

package gestorAplicacion.Cosas;

import java.time.LocalDate;
import java.io.Serializable;
import gestorAplicacion.Personas.Cliente;
import java.time.format.DateTimeFormatter;

public class Reserva implements Serializable{
	private static final long serialVersionUID=1L;
    private Cliente duenoReserva;
    private Mesa mesa;
    private int numAsistentes;
    private LocalDate diaReserva;

    //Constructor
    public Reserva (Cliente duenoReserva, int numAsistentes,LocalDate diaReserva) {
        this.duenoReserva = duenoReserva;
        this.numAsistentes = numAsistentes;
        this.diaReserva = diaReserva;
    }

    //Metodos getter
    public Cliente getDuenoReserva () {
        return this.duenoReserva;
    }
    public Mesa getMesa () {
        return this.mesa;
    }
    public LocalDate getDiaReserva () {
        return this.diaReserva;
    }
    public int getNumeroAsistentes () {
        return this.numAsistentes;
    }

    //Metodos setter
    public void setDuenoReserva (Cliente duenoReserva) {
        this.duenoReserva = duenoReserva;
    }
    public void setMesa (Mesa mesa) {
        this.mesa = mesa;
    }
    public void setDiaReserva (LocalDate diaReserva) {
        this.diaReserva = diaReserva;
    }

    //Metodos funcionalidad 1 (reservas)
    //Metodo para imprimir la info de las reservas, dependiendo si son o no confirmadas
    public String resumenReserva () {
        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (this.mesa == null) {
            return "Dueño de la reserva: "+this.getDuenoReserva().getNombre()+"\nCédula del reservista: "
            +this.getDuenoReserva().getCedula()+"\nNumero de asistentes: "+this.getNumeroAsistentes()+"\nMesa número: "
            +"Sin mesa asignada"+"\nFecha reservada: "+this.getDiaReserva().format(formatoPersonalizado);
        }
        else {
            return "Dueño de la reserva: "+this.getDuenoReserva().getNombre()+"\nCédula del reservista: "
            +this.getDuenoReserva().getCedula()+"\nNumero de asistentes: "+this.getNumeroAsistentes()+"\nMesa número: "
            +this.mesa.getNumeroMesa()+"\nFecha reservada: "+this.getDiaReserva().format(formatoPersonalizado);
        }
    }
    
    public String resumenReservaPedido(){
    	return " Dueño de la reserva: "+this.getDuenoReserva().getNombre()+" Mesa número: "+this.mesa.getNumeroMesa();
    }

    //Metodos de clase
    //Convierte un String a una fecha
    public static LocalDate deStringaFecha(String fechaString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);
        return fecha;
    }

    //revisa si la fecha es posterior a hoy para que las reservas tengan sentido
    public static boolean revisarFecha(String fecha) {
        LocalDate f1 = deStringaFecha(fecha);
        LocalDate fechaActual = LocalDate.now();
        if (f1.isAfter(fechaActual)) {
            return true;
        } else {
            return false;
        }
    }
}