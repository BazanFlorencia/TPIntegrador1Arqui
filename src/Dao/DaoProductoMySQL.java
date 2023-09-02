package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Entities.Producto;
import daoInterfaces.DaoProducto;
import factory.DAO_MYSQL_Factory;

public class DaoProductoMySQL implements DaoProducto<Exception> {

	@Override
	public void insertarTodo(LinkedList<Producto> productos) throws Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		conn.prepareStatement("INSERT INTO Producto (idProducto, nombre, valor) VALUES(?,?,?)");
		
		PreparedStatement preparedStatement = conn
				.prepareStatement("INSERT INTO Producto (idProducto, nombre, valor) VALUES(?,?,?)");
		productos.forEach(producto -> {
			try {
				preparedStatement.setInt(1, producto.getIdProducto());
				preparedStatement.setString(2, producto.getNombre());
				preparedStatement.setFloat(3, producto.getValor());
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

	@Override
	public void crearTabla() throws SQLException, Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		
		// conn.prepareStatement("SET foreign_key_checks = 0;").execute();
		// conn.prepareStatement("DROP TABLE IF EXISTS Product").execute();
		// conn.prepareStatement("SET foreign_key_checks = 1;");
		// conn.commit();
		conn.prepareStatement("CREATE TABLE IF NOT EXISTS Producto (idProducto int PRIMARY KEY , " + " nombre varchar(45) NOT NULL,"
				+ " valor float NOT NULL)").execute();
		conn.commit();
		conn.close();

	}

	@Override
	public Producto productoQueMasRecaudo() throws Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		Producto p = null;
		try {
			
			PreparedStatement ps = conn
					.prepareStatement("SELECT p.idProducto, p.nombre, p.valor, SUM(p.valor*fp.cantidad) as Recaudacion"
							+ " FROM Producto p JOIN FacturaProducto fp ON p.idProducto=fp.idProducto"
							+ " GROUP BY idProducto, nombre, valor" + " ORDER BY Recaudacion DESC" + " LIMIT 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
			conn.commit();
			conn.close();
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}


	





	
	
	
	

}
