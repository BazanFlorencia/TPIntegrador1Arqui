package Objetos;

public class FacturaProducto {
	private int idFactura;
	private int idProducto;
	private int cantidad;
	
	
	
	public FacturaProducto(Factura factura, Producto producto, int cantidad) {
		this.idFactura = factura.getIdFactura();
		this.idProducto = producto.getIdProducto();
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
	
	
	
}
