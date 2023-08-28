package Entities;

public class Factura {
	private int idFactura;
	private int idCliente;
	
	
	public Factura(int idFactura, Cliente cliente) {
		this.idFactura = idFactura;
		this.idCliente = this.getIdCliente(cliente);
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public int getIdCliente(Cliente cliente) {
		return  cliente.getId();
	}
	
	
}
