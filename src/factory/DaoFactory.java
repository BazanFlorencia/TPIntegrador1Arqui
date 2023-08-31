package factory;

import java.util.List;
import java.util.Optional;

import Dao.DaoClienteMySQL;
import Dao.DaoFacturaMySQL;
import Dao.DaoFacturaProductoMySQL;
import Dao.DaoProductoMySQL;

public abstract class DaoFactory {
	private DAO_MYSQL_Factory fabricaMysql; //esto esta bien???

	public abstract DaoClienteMySQL getDaoCliente();

	public abstract DaoFacturaMySQL getDaoFactura();

	public abstract DaoFacturaProductoMySQL getDaoFacturaProducto();

	public abstract DaoProductoMySQL getDaoProducto();

	public DaoFactory getDaoFactory(String baseDeDatos, String uri) {

		switch (baseDeDatos) {
		case "MYSQL":
			return fabricaMysql.getInstance(uri);
		case "DERBY":
			return null;
		case "POSTGRESQL":
			return null;
		default:
			return null;
		}

		
	}

}
