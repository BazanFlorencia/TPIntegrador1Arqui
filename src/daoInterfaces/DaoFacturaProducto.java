package daoInterfaces;


import java.sql.SQLException;
import java.util.LinkedList;

import Entities.FacturaProducto;



public interface DaoFacturaProducto  <T extends Throwable> {
	public void crearTabla() throws SQLException, Exception ;
	void insertarTodo(LinkedList<FacturaProducto> datos) throws T;
	

}
