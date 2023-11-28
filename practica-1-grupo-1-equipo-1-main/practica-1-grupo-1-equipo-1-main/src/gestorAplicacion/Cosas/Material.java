//Autor: Daniel Garzón.
//Componentes: importaciones, constructores, getters y metodos de funcionalidades

package gestorAplicacion.Cosas;
import java.time.LocalDate;
import java.io.Serializable;

public class Material implements Serializable{
	private static final long serialVersionUID=1L;
	
    public enum Tipo {TOMATES,CEBOLLAS,PAPAS,ACEITES,VINOS,QUESOS,CHAMPINONES,RES,
    PESCADOS,CERDOS,POLLOS,PANES,AJOS,ESPECIAS,HUEVOS,ATUN,CUCHARAS,TENEDORES,PLATOS,VASOS};
    
    private Tipo tipo;
    private int cantidad;
    private double precioUnitario;
    private LocalDate fechaVencimiento;
    
    public Material (Tipo tipo) {
        this(tipo, 0, 0);
    }
    public Material (Tipo tipo, int cantidad, double precioUnitario) {
        this(tipo, cantidad, precioUnitario, null);
    }
    public Material (Tipo tipo, int cantidad, double precioUnitario, LocalDate fechaVencimiento) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVencimiento = fechaVencimiento;
    }
    // Metodos getters
    public Tipo getTipo () {
        return this.tipo;
    }
    public int getCantidad () {
        return this.cantidad;
    }
    public double getPrecioUnitario () {
        return this.precioUnitario;
    }
    public LocalDate getFechaVencimiento() {
        return this.fechaVencimiento;
    }
    // Metodos setters
    public Tipo setTipo (Tipo tipo) {
        return this.tipo=tipo;
    }
    public int setCantidad (int cantidad) {
        return this.cantidad=cantidad;
    }
    public double setPrecioUnitario (double precioUnitario) {
        return this.precioUnitario=precioUnitario;
    }
    public LocalDate setFechaVencimiento(LocalDate fechaVencimiento) {
        return this.fechaVencimiento=fechaVencimiento;
    }
    // Metodos para modificar cantidades
    public void comprarMaterial(int cantidad) {
        this.cantidad += cantidad;
    }
    public void botarMaterial(int cantidad) {
    	this.cantidad -= cantidad;
    }
    public void cambiarPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public void cambiarFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public String fechaMaterial() {
    	return "Este material no tiene fecha de vencimiento";
    }
    public void restarCantidad(int cantidad){
    	this.cantidad-=cantidad;
    }
}
