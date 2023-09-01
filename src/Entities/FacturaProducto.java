package Entities;

public class FacturaProducto {
	private int idFactura;
	private int idProducto;
	private int cantidad;
	
	public FacturaProducto() {
		
	}
	
	public FacturaProducto(int idFactura, int idProd, int cantidad) {
		this.idFactura = idFactura;
		this.idProducto = idProd;
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdFactura(int nuevaFactura) {
		this.idFactura = nuevaFactura;
	}

	public void setIdProducto(int nuevoProducto) {
		this.idProducto = nuevoProducto;
	}
	
	
	
}
