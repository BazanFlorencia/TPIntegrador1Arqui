package LectorCSV;
import Entities.Cliente;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.util.LinkedList;

public class LectorClienteCSV extends LectorCSV{
	public LectorClienteCSV(String direccionCSV){
        super(direccionCSV);
    }
    public LinkedList<Cliente> getClientes() throws IOException {
        Iterable<CSVRecord> registros =  this.leer();
        LinkedList<Cliente> clientes = new LinkedList<>();
        for (CSVRecord registro : registros) {
            Integer idCliente = Integer.valueOf(registro.get(0)); 
            String nombre = registro.get(1);
            String email = registro.get(2);
            clientes.add(new Cliente(idCliente,nombre,email));
        }
        return clientes;
    }

}



