package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import Entities.Factura;
import daoInterfaces.DaoFactura;
import factory.DAO_MYSQL_Factory;


public class DaoFacturaMySQL  implements DaoFactura<Exception>{

	@Override
	public void insertarTodo(LinkedList <Factura> facturas) throws Exception {
		 Connection conn = DAO_MYSQL_Factory.abrirConexion();
	      
	        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Factura(idFactura, idCliente) VALUES(?,?)");
	        facturas.forEach(factura -> {
	            try {
	                preparedStatement.setInt(1,factura.getIdFactura());
	                preparedStatement.setInt(2,factura.getIdCliente());
	                preparedStatement.addBatch();
	            } catch (SQLException e) {
	                throw new RuntimeException(e);
	            }
	            try {
	                preparedStatement.executeBatch();
	                conn.commit();
	            } catch (SQLException e) {
	                throw new RuntimeException(e);
	            }
	        });
		
	}

	@Override
	public void crearTabla()  throws SQLException, Exception {
		Connection conn = DAO_MYSQL_Factory.abrirConexion();
		
        conn.prepareStatement("CREATE TABLE IF NOT EXISTS Factura (idFactura INT PRIMARY KEY , idCliente INT NOT NULL, FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)" +
                "ON DELETE RESTRICT)").execute();
        conn.commit();
        conn.close();
		
	}
	










}
