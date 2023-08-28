import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class aplicacion {
	
	public static void main(String[] args) {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new
					FileReader("C:/Users/flore/OneDrive/Documents/Facultad-20220709T142310Z-001/2do año facultad/Arquitectura web/archivosCSV/productos.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				for(CSVRecord row: parser) {
				System.out.println("id = " + row.get("idProducto"));
				System.out.println("nombre" + row.get("nombre"));
				System.out.println("valor" + row.get("valor"));
				}
	}

}


