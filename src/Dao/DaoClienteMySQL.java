package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import Entities.Cliente;
import daoInterfaces.DaoCliente;
import factory.DAO_MYSQL_Factory;

public class DaoClienteMySQL implements DaoCliente<Exception> {

	@Override
	public void crearTabla() throws SQLException, Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();

		conn.prepareStatement(
				"CREATE TABLE IF NOT EXISTS Cliente (idCliente INT PRIMARY KEY , nombre VARCHAR(50) NOT NULL, email VARCHAR(150) NOT NULL)")
				.execute();
		conn.commit();
		conn.close();

	}

	@Override
	public ArrayList<Cliente> clientesOrdenadosSegunFacturacion() throws Exception {

		ArrayList<Cliente> clientes = new ArrayList<>();
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		try {
			PreparedStatement ps = conn
					.prepareStatement("SELECT c.idCliente, c.nombre, c.email, SUM(fp.cantidad*p.valor) as Facturacion "
							+ "FROM Cliente c JOIN Factura f ON c.idCliente = f.idCliente JOIN FacturaProducto fp ON f.idFactura = fp.idFactura "
							+ "JOIN Producto p ON p.idProducto = fp.idProducto "
							+ "GROUP BY c.idCliente, c.nombre, c.email " + "ORDER BY Facturacion DESC;\n");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3));
				clientes.add(c);
			}
			conn.commit();
			conn.close();
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public void insertarTodo(LinkedList<Cliente> clientes) throws Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		conn.prepareStatement("INSERT INTO Cliente (idCliente,nombre,email) VALUES(?,?,?)");
		
		PreparedStatement preparedStatement = conn
				.prepareStatement("INSERT INTO Cliente (idCliente,nombre,email) VALUES(?,?,?)");
		clientes.forEach(cliente -> {
			try {
				preparedStatement.setInt(1, cliente.getIdCliente());
				preparedStatement.setString(2, cliente.getNombre());
				preparedStatement.setString(3, cliente.getEmail());
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





	
	
	



