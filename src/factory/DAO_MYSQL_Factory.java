package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Dao.DaoClienteMySQL;
import Dao.DaoFacturaMySQL;
import Dao.DaoFacturaProductoMySQL;
import Dao.DaoProductoMySQL;

public class DAO_MYSQL_Factory extends DaoFactory{
	protected static Connection conexion;
	private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String uri; /*= "jdbc:mysql://localhost:3306/exampledb"; */ //hacerlo constante y declararlo aca?
	private final String USER = "root";
	private final String PASSWORD = "";
	
	private static DAO_MYSQL_Factory instance;
	
	
	private DAO_MYSQL_Factory(String uri) {
		setURI(uri); //esto borrarlo?
	    registrarDriver();
		
	}
	//este met borrarlo?
    public static void setURI(String urid){
        uri=urid;
    }

   
    public static void registrarDriver(){
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
        } 
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

	public static Connection abrirConexion() throws Exception {
		try {
			conexion = DriverManager.getConnection(uri, USER, PASSWORD);
			Class.forName(JDBC_DRIVER);
			return conexion;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void cerrarConexion(Connection conexion) throws SQLException {
		if(conexion !=null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}

	public static DAO_MYSQL_Factory getInstance(String uri) {
		if(instance == null) {
			instance = new DAO_MYSQL_Factory(uri);
		}
		return instance;
	}
	//ESTO ES NECESARIO???
/*	public void crearBaseDeDatos(String nombreDb) throws SQLException {
		Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306",USER,PASSWORD);
        conn.setAutoCommit(false);
        String sql = "CREATE DATABASE IF NOT EXISTS" + " " +  nombreDb;
        conn.prepareStatement(sql).execute();
        conn.close();
	}*/

	public DaoClienteMySQL getDaoCliente() {
		
		return new DaoClienteMySQL();
	}
	public DaoFacturaMySQL getDaoFactura() {
		
		return new DaoFacturaMySQL();
	}
	public DaoFacturaProductoMySQL getDaoFacturaProducto() {
		
		return new DaoFacturaProductoMySQL();
	}
	public DaoProductoMySQL getDaoProducto() {
		
		return new DaoProductoMySQL();
	}
	
}

