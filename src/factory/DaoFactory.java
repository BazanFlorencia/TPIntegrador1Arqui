package factory;

import java.util.List;
import java.util.Optional;

import Dao.DaoCliente;
import Dao.DaoFactura;
import Dao.DaoFacturaProducto;
import Dao.DaoProducto;

public abstract class DaoFactory {
	public abstract DaoCliente getDaoCliente();
	public abstract DaoFactura getDaoFactura();
	public abstract DaoFacturaProducto getDaoFacturaProducto();
	public abstract DaoProducto getDaoProducto();
	
	/*public DaoFactory getDaoFactory(String baseDeDatos, String uri) {
		  
		        switch (baseDeDatos) {
		            case MYSQL : return new DAO_MySQL_Factory(uri);
		            case DERBY: return null;
		            case POSTGRESQL: return null;
		            default: return null;
		        }
		    
		return null;
	}*/
    
   
}
