package factory;

import java.util.List;
import java.util.Optional;

import Dao.DaoClienteMySQL;
import Dao.DaoFacturaMySQL;
import Dao.DaoFacturaProductoMySQL;
import Dao.DaoProductoMySQL;

public abstract class DaoFactory {
	

	public abstract DaoClienteMySQL getDaoCliente();

	public abstract DaoFacturaMySQL getDaoFactura();

	public abstract DaoFacturaProductoMySQL getDaoFacturaProducto();

	public abstract DaoProductoMySQL getDaoProducto();
	
	
	public static DaoFactory getDaoFactory(String baseDeDatos) {

		switch (baseDeDatos) {
		case "MYSQL":
			return DAO_MYSQL_Factory.getInstance();
		case "DERBY":
			return null;
		case "POSTGRESQL":
			return null;
		default:
			return null;
		}

		
	}


		


	

}
