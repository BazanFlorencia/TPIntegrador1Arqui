package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import Entities.FacturaProducto;
import daoInterfaces.DaoFacturaProducto;
import factory.DAO_MYSQL_Factory;

public class DaoFacturaProductoMySQL implements DaoFacturaProducto<Exception> {

	public void crearTabla() throws SQLException, Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		
		// esto es necesario??
		// conn.prepareStatement("SET foreign_key_checks = 0;").execute();
		// conn.prepareStatement("DROP TABLE IF EXISTS BillProduct").execute();
		// conn.prepareStatement("SET foreign_key_checks = 1;").execute();
		// conn.commit();
		conn.prepareStatement("CREATE TABLE IF NOT EXISTS FacturaProducto (idFactura integer NOT NULL , "
				+ "idProducto integer NOT NULL," + " cantidad integer NOT NULL,"
				+ " PRIMARY KEY (idFactura, idProducto)," + " FOREIGN KEY (idFactura) REFERENCES Factura (idFactura),"
				+ " FOREIGN KEY (idProducto) REFERENCES Producto (idProducto)" + "ON DELETE RESTRICT)").execute();
		conn.commit();
		conn.close();
	}

	@Override
	public void insertarTodo(LinkedList <FacturaProducto> datos) throws Exception{
		
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		conn.prepareStatement("INSERT INTO FacturaProducto (idFactura, idProducto, cantidad) VALUES(?,?,?)");
	
		PreparedStatement preparedStatement = conn
				.prepareStatement("INSERT INTO FacturaProducto (idFactura, idProducto, cantidad) VALUES(?,?,?)");
		datos.forEach(FacturaProducto -> {
			try {
				preparedStatement.setInt(1, FacturaProducto.getIdFactura());
				preparedStatement.setInt(2, FacturaProducto.getIdProducto());
				preparedStatement.setInt(3, FacturaProducto.getCantidad());
				preparedStatement.addBatch();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			try {
				preparedStatement.executeBatch();
				conn.commit();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}





	

}
