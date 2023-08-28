package Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Entities.Factura;
import factory.DAO_MYSQL_Factory;
import factory.DaoFactory;

public class DaoFactura  implements DaoFactory{

	@Override
	public Optional<Factura> get(long id) {
		
		return null;
	}

	@Override
	public List<Factura> getAll() {
		List<Factura> facturas = new ArrayList<>();
		for {
			
		}
		return facturas;
	}

	@Override
	public void insert(Object t) {
		
		
	}

	@Override
	public void update(Object t, String[] params) {
		
		
	}

	@Override
	public void delete(Object t) {
		
		
	}

	@Override
	public void createTable() {
		
		
	}

}
