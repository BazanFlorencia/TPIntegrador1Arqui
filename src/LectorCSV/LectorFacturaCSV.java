package LectorCSV;
import Entities.Factura;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.util.LinkedList;

public class LectorFacturaCSV extends LectorCSV {
	
    public LectorFacturaCSV(String direccion) {
        super(direccion);
    }

    public LinkedList<Factura> getFacturas() throws IOException {
        Iterable<CSVRecord> registros =  this.leer();
        LinkedList<Factura> facturas = new LinkedList<>();
        for (CSVRecord registro : registros) {
            int idFactura = Integer.parseInt(registro.get(0));
            int idCliente = Integer.parseInt(registro.get(1));
            facturas.add(new Factura(idFactura,idCliente));
        }
        return facturas;
    }

}







