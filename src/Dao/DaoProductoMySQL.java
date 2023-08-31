package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVParser;

import Entities.Producto;
import daoInterfaces.Dao;
import factory.DAO_MYSQL_Factory;
import factory.DaoFactory;

public class DaoProductoMySQL implements Dao{
	



	@Override
	public void crearTabla() {
		// implementar
		
	}
	
	public Producto productoQueMasRecaudo() {
		//implementar
		return null;
	}

	@Override
	public void insertarTodo(CSVParser parser, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leerCSV(String csv, String uri) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
