package LectorCSV;
import Entities.FacturaProducto;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.util.LinkedList;

public class LectorFacturaProductoCSV  extends LectorCSV{
	 public LectorFacturaProductoCSV(String direccionCSV){
	        super(direccionCSV);
	    }
	  public LinkedList<FacturaProducto> getFacturasProductos() throws IOException {
	        Iterable<CSVRecord> registros =  this.leer();
	        LinkedList<FacturaProducto> FacturasProductos = new LinkedList<>();
	        for (CSVRecord registro : registros) {
	            int idFactura = Integer.parseInt(registro.get(0));
	            int idProducto = Integer.parseInt(registro.get(1));
	            int cantidad = Integer.parseInt(registro.get(2));
	            FacturasProductos.add(new FacturaProducto(idFactura,idProducto,cantidad));
	        }
	        return FacturasProductos;
	    }


}







   

  



