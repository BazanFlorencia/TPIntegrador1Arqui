import Entities.Factura;
import Entities.FacturaProducto;
import Entities.Cliente;
import Entities.Producto;
import daoInterfaces.DaoFactura;
import daoInterfaces.DaoFacturaProducto;
import daoInterfaces.DaoProducto;
import LectorCSV.LectorFacturaProductoCSV;
import LectorCSV.LectorFacturaCSV;
import LectorCSV.LectorClienteCSV;
import daoInterfaces.DaoCliente;
import LectorCSV.LectorProductoCSV;
import factory.DaoFactory;

//import factory.DAO_MYSQL_Factory;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;


public class Principal {
	public static void crearBaseDeDatos(String nombreDb) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
		conn.setAutoCommit(false);
		String sql = "CREATE DATABASE IF NOT EXISTS "+ nombreDb;
		conn.prepareStatement(sql).execute();
		conn.commit();
		conn.close();

	}

	public static void main(String[] args) throws Throwable {

		crearBaseDeDatos("db_tp_jdbc_arqui_grupo_18");
		//System.out.println("Base de datos creada");

		
		// Creamos base de datos para mySQL (SOLO PARA TESTEO)
		//DAO_MYSQL_Factory.crearBaseDeDatos("arqui"); // hacerlo en el main

		// Obtenemos el DAO de mySQL
		DaoFactory daoMySQL = DaoFactory.getDaoFactory("MYSQL");

		// Obtenemos los DAO de cada entidad
		DaoCliente daoCliente = daoMySQL.getDaoCliente();
		DaoFactura daoFactura = daoMySQL.getDaoFactura();
		DaoProducto daoProducto = daoMySQL.getDaoProducto();
		DaoFacturaProducto daoFacturaProducto = daoMySQL.getDaoFacturaProducto();

		// lectura de CSV's
		String direccionArchivo = new File("").getAbsolutePath();
		LinkedList<Cliente> clientes = new LectorClienteCSV(direccionArchivo + "/src/csv/clientes.csv").getClientes();
		LinkedList<Factura> facturas = new LectorFacturaCSV(direccionArchivo + "/src/csv/facturas.csv").getFacturas();
		LinkedList<Producto> productos = new LectorProductoCSV(direccionArchivo + "/src/csv/productos.csv")
				.getProductos();
		LinkedList<FacturaProducto> facturasProductos = new LectorFacturaProductoCSV(
				direccionArchivo + "/src/csv/facturas-productos.csv").getFacturasProductos();

		// Creamos las tablas
		daoCliente.crearTabla();
		daoFactura.crearTabla();
		daoProducto.crearTabla();
		daoFacturaProducto.crearTabla();

		// insertamos los datos en las tablas
		/*daoCliente.insertarTodo(clientes);
		daoFactura.insertarTodo(facturas);
		daoProducto.insertarTodo(productos);
		daoFacturaProducto.insertarTodo(facturasProductos);*/

		// Obtenemos el producto con mayor recaudacion
		// punto 3
		System.out.println("PRODUCTO CON MAYOR FACTURACION");
		Producto p = daoProducto.productoQueMasRecaudo();
		System.out.println(p);

		// Obtenemos las lista de clientes ordenada con mayor facturacion
		System.out.println("LISTA DE CLIENTES ORDENADAS CON MAYOR FACTURACION");
		ArrayList<Cliente> clientesFacturacion = daoCliente.clientesOrdenadosSegunFacturacion();
		clientesFacturacion.forEach(cliente -> System.out.println(cliente));
		

	}
}
