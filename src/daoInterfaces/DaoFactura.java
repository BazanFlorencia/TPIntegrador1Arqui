package daoInterfaces;

import java.util.LinkedList;

import Entities.Factura;

public interface DaoFactura<T extends Throwable> {
	public void insertarTodo(LinkedList<Factura> facturas) throws T;

	public void crearTabla() throws T;

}
