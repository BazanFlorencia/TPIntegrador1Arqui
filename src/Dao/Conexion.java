package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection conexion;
	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URI = "jdbc:mysql://localhost:3306/exampledb";
	
	private final String USER = "root";
	private final String PASSWORD = "";
	
	public void conectar() throws Exception {
		try {
			conexion = DriverManager.getConnection(URI, USER, PASSWORD);
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar() throws SQLException {
		if(conexion !=null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}
	
	
}

