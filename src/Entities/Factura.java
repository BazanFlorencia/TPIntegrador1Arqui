package Entities;

public class Factura {
	private int idFactura;
	private int idCliente;

	public Factura(int idFactura, int idCliente) {
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}

	public String toString() {
		return "id de la factura: " + this.idFactura + " " + "id del Cliente: " + this.idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}
