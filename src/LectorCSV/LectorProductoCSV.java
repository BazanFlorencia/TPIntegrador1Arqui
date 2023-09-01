package LectorCSV;
import Entities.Producto;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.LinkedList;

public class LectorProductoCSV extends LectorCSV {
	 public LectorProductoCSV(String direccionCSV){
	        super(direccionCSV);
	    }
	 public LinkedList<Producto> getProduct() throws IOException {
	        Iterable<CSVRecord> registros =  this.leer();
	        LinkedList<Producto> productos = new LinkedList<>();
	        for (CSVRecord registro : registros) {
	            int idProducto = Integer.parseInt(registro.get(0));
	            String nombre = registro.get(1);
	            float valor = Float.parseFloat(registro.get(2));
	            productos.add(new Producto(idProducto,nombre,valor));
	        }
	        return productos;
	    }

}

