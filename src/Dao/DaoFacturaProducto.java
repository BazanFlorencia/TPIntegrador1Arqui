package Dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Entities.FacturaProducto;
import daoInterfaces.Dao;
import factory.DAO_MYSQL_Factory;

public class DaoFacturaProducto implements Dao{
	
	public void readCSV(String csv) throws Exception {
		
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csv));
			Connection conn = (DAO_MYSQL_Factory.getInstance()).openDBConnection();
			this.create(parser, conn);
			(DAO_MYSQL_Factory.getInstance()).closeConnection(conn);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void create(CSVParser parser, Connection conn) throws SQLException {
		for(CSVRecord row: parser) {
			FacturaProducto f = new FacturaProducto();
		
			f.setIdFactura(Integer.parseInt(row.get("idFactura"))); 
			f.setIdProducto(Integer.parseInt(row.get("idProducto"))); 
			f.setCantidad(Integer.parseInt(row.get("cantidad")));
			
			System.out.println(f);
			//this.save(f, conn);
		}
	}

/*	private void save(FacturaProducto f, Connection conn) {
		
		
	}*/

	@Override
	public void insertarTodo(LinkedList datos) {
		// implementar
		
	}

	@Override
	public void crearTabla() {
		// implemantar
		
	}
	
}
