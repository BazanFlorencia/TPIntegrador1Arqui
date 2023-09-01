package factory;

import java.util.List;
import java.util.Optional;

import Dao.DaoClienteMySQL;
import Dao.DaoFacturaMySQL;
import Dao.DaoFacturaProductoMySQL;
import Dao.DaoProductoMySQL;

public abstract class DaoFactory {
	//private DAO_MYSQL_Factory fabricaMysql; //esto esta bien???
	private static DaoFactory fabricaMySQL;

	public abstract DaoClienteMySQL getDaoCliente();

	public abstract DaoFacturaMySQL getDaoFactura();

	public abstract DaoFacturaProductoMySQL getDaoFacturaProducto();

	public abstract DaoProductoMySQL getDaoProducto();
	
	public  abstract DAO_MYSQL_Factory getInstance();

	public static DaoFactory getDaoFactory(String baseDeDatos) {

		switch (baseDeDatos) {
		case "MYSQL":
			return fabricaMySQL.getInstance();
		case "DERBY":
			return null;
		case "POSTGRESQL":
			return null;
		default:
			return null;
		}

		
	}

	

}
