package daoInterfaces;

import java.util.ArrayList;
import java.util.LinkedList;

import Entities.Cliente;

public interface DaoCliente <T extends Throwable> {
	    void crearTabla() throws T ;
	    public ArrayList<Cliente>  clientesOrdenadosSegunFacturacion() throws T;
		void insertarTodo(LinkedList<Cliente> clientes) throws Exception;
		

}
