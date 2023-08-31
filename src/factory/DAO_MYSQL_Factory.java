package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Dao.DaoCliente;
import Dao.DaoFactura;
import Dao.DaoFacturaProducto;
import Dao.DaoProducto;

public class DAO_MYSQL_Factory extends DaoFactory{
	protected static Connection conexion;
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URI = "jdbc:mysql://localhost:3306/exampledb";
	
	private final String USER = "root";
	private final String PASSWORD = "";
	
	private static DAO_MYSQL_Factory instance = new DAO_MYSQL_Factory(conexion);// preguntar si esta bien iniciar acá la instancia
	
	
	
	private DAO_MYSQL_Factory(Connection conexion) {
		this.conexion = conexion;
	}

	public Connection openDBConnection() throws Exception {
		try {
			conexion = DriverManager.getConnection(URI, USER, PASSWORD);
			Class.forName(JDBC_DRIVER);
			return conexion;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void closeConnection(Connection conexion) throws SQLException {
		if(conexion !=null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}

	public static DAO_MYSQL_Factory getInstance() {
		if(instance == null) {
			instance = new DAO_MYSQL_Factory(conexion);
		}
		return instance;
	}
	
	public void crearBaseDeDatos() {
		//implementar
	}
	public DaoCliente getDaoCliente() {
		//implementar
		return null;
	}
	public DaoFactura getDaoFactura() {
		//implementar
		return null;
	}
	public DaoFacturaProducto getDaoFacturaProducto() {
		//implementar
		return null;
	}
	public DaoProducto getDaoProducto() {
		//implementar
		return null;
	}
	
}

