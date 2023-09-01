package daoInterfaces;

import java.util.LinkedList;

import Entities.Producto;

public interface DaoProducto <T extends Throwable> {
	  public void insertarTodo(LinkedList<Producto> productos) throws T;
	    public void crearTabla() throws T;
	    public Producto productoQueMasRecaudo() throws T;
}
