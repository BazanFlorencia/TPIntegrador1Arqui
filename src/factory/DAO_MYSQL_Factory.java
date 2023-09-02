package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.reflect.InvocationTargetException;

import Dao.DaoClienteMySQL;
import Dao.DaoFacturaMySQL;
import Dao.DaoFacturaProductoMySQL;
import Dao.DaoProductoMySQL;

public class DAO_MYSQL_Factory extends DaoFactory{
	protected static Connection conexion;
	private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URI = "jdbc:mysql://localhost:3306/db_tp_jdbc_arqui_grupo_18";  //hacerlo constante y declararlo aca?
	private final static String USER = "root";
	private final static String PASSWORD = "";
	
	private static DAO_MYSQL_Factory instance;
	
	
	private DAO_MYSQL_Factory() {
		
		//setURI(uri); //esto borrarlo?
	    registrarDriver();
	 	
	}

	public static DaoFactory getInstance() {
		if(instance == null) {
			instance = new DAO_MYSQL_Factory();
		}
		return instance;
	}
	//este met borrarlo?
   /* public static void setURI(String urid){
        uri=urid;
    }*/

   
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
			conexion = DriverManager.getConnection(URI, USER, PASSWORD);
			conexion.setAutoCommit(false);
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


	//ESTO ES NECESARIO???
	/*public void crearBaseDeDatos(String nombreDb) throws SQLException {
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

