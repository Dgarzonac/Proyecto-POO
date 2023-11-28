//Componentes: Importaciones, constructor, getters y setters, y métodos de las funcionalidades 

package gestorAplicacion.Cosas;
import java.io.Serializable;

public class Turno implements Serializable{
	private static final long serialVersionUID=1L;
	public enum Tipo {SEMANA, SABADO, DOMINGO}
    private double salario;
    private boolean completado;
    private boolean cobrado;
    private double horas;
	private Tipo tipo;

    // Constructor
    public Turno(Tipo tipo, double d, double salario){
    	this.tipo = tipo;
        this.setHoras(d);
        this.salario = salario;
        this.completado = false;
        this.cobrado = false;
    }
    
    // Métodos getter
    public Tipo getTipo () {
        return this.tipo;
    }
	public double getHoras() {
		return horas;
	}
 
    public double getSalario() {
        return salario;
    }

    public boolean isCompletado() {
        return completado;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    // Métodos setter
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }
    public boolean getEstado() {
		return this.completado;
	}

	public void setHoras(double d) {
		this.horas = d;
	}
	
    public void restarTiempo(Turno turno,double tiempo_total){
    	if((this.horas*60)-tiempo_total>=-20) {
    		turno.setHoras(((this.horas*60)-tiempo_total)/60);  		
    		// Rango de 10 minutos para contratiempos
    		if(turno.getHoras()*60.0 <= 10.0){
    			turno.setCompletado(true);
    		}
    	}
	}
    
    // Metodo que calcula las horas extra
	public double HorasExtras() {
        double horasRegulares = 8;  //suponer que es 8
        if (this.horas > horasRegulares) {
            return this.horas - horasRegulares;
        } else {
            return 0;
        }
	}
	// toString de la clase
	public String toString(){
		return "Tipo: " + this.getTipo() +" Salario: " +this.getEstado() +" Estado completado: " + this.isCompletado() +" Estado cobrado" + this.isCobrado();
	}

	
}