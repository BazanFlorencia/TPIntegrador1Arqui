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

public class DaoFacturaProductoMySQL implements Dao{
	
	public void leerCSV(String csv, String uri) throws Exception { //si uri const borrarlo de aca
		//csv="producto.csv"
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csv));
			Connection conn = (DAO_MYSQL_Factory.getInstance(uri)).abrirConexion();
			this.insertarTodo(parser, conn);
			(DAO_MYSQL_Factory.getInstance(uri)).cerrarConexion(conn);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insertarTodo(CSVParser parser, Connection conn) throws SQLException {
		for(CSVRecord row: parser) {
			FacturaProducto f = new FacturaProducto();
		
			f.setIdFactura(Integer.parseInt(row.get("idFactura"))); 
			f.setIdProducto(Integer.parseInt(row.get("idProducto"))); 
			f.setCantidad(Integer.parseInt(row.get("cantidad")));
			
			System.out.println(f);
			//this.save(f, conn);
		}
	}
	/*CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
			FileReader("productos.csv"));
			for(CSVRecord row: parser) {
			System.out.println(row.get("idProducto"));
			System.out.println(row.get("nombre"));
			System.out.println(row.get("valor"));
			}*/
	public void crearTabla() throws SQLException, Exception  {
        Connection conn = DAO_MYSQL_Factory.abrirConexion();
        //esto es necesario??
        //conn.prepareStatement("SET foreign_key_checks = 0;").execute();
        //conn.prepareStatement("DROP TABLE IF EXISTS BillProduct").execute();
        //conn.prepareStatement("SET foreign_key_checks = 1;").execute();
       // conn.commit();
        conn.prepareStatement("CREATE TABLE FacturaProducto (idFactura integer NOT NULL , " +
                "idProducto integer NOT NULL," +
                " cantidad integer NOT NULL," +
                " PRIMARY KEY (idFactura, idProducto)," +
                " FOREIGN KEY (idFactura) REFERENCES Factura (idFactura)," +
                " FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)" +
                "ON DELETE RESTRICT)").execute();
        conn.commit();
        conn.close();
    }
	






	
}
