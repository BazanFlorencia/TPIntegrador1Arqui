package LectorCSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LectorCSV {
    private String direccion;

    public LectorCSV(String direccion){
        this.direccion = direccion;
    }
  
    public Iterable<CSVRecord> leer() throws IOException {
        Reader datos = new FileReader(this.direccion);
        Iterable<CSVRecord> registros = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(datos);
        return registros;
    }
}
