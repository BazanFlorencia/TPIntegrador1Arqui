package Entities;

public class ProductoConMasRecaudacion extends Producto {
	private float recaudacion;
	
	public ProductoConMasRecaudacion(int idProducto, String nombre, float valor, float recaudacion) {
		super(idProducto, nombre, valor);
		this.recaudacion=recaudacion;
		
	}

	public float getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(float recaudacion) {
		this.recaudacion = recaudacion;
	}

	@Override
	public String toString() {
		return "ProductoConMasRecaudacion   [idProducto=" + this.getIdProducto() + ", nombre=" + this.getNombre() + ", valor=" 
	+ this.getValor()  + ", recaudacion=" + recaudacion + "]";
	}

	
	
	
}
