package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO_MYSQL_Factory {
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
	
	
}

