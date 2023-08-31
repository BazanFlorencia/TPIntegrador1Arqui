package daoInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.commons.csv.CSVParser;

public interface Dao  <T extends Throwable> {
	public void insertarTodo(CSVParser parser, Connection conn) throws SQLException;
	public void crearTabla() throws SQLException, Exception ;
	public void leerCSV(String csv, String uri) throws Exception;

	

}
