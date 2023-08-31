package daoInterfaces;

import java.util.LinkedList;

public interface Dao  <T extends Throwable> {
	public void insertarTodo(LinkedList<T> datos);
	public void crearTabla();

	

}
