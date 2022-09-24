import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;


public class Apache {
    //Actualiza el excel de Cliente que almacena información del objeto Cliente
	public static void leer() {
		
		try {
			FileInputStream file = new FileInputStream(new File("Libro2.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			
			XSSFSheet sheetClientes = wb.getSheetAt(1);
			
			//Establece el número de filas
			
				XSSFRow fila = sheetClientes.getRow(0);
				if(fila==null)
					fila = sheetClientes.createRow(0);
				
				//Establece el número de celdas por fila y guarda su valor
				
					XSSFCell celda = fila.createCell(0);
						celda.setCellValue("1"); 
			
			
			file.close();
			FileOutputStream output = new FileOutputStream("/Vacunas/src/Libro2.xlsx");
			wb.write(output);
            wb.close();
			output.close();

		} catch(FileNotFoundException e) {
			//Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		} catch(Exception e) {
			Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

		}
	}
    //Código usado para crear el Excel la primera vez
	public static void crearExcel() {  
        System.out.println("todo");

		XSSFWorkbook wb = new XSSFWorkbook();
        System.out.println("Done");

        try {
            FileOutputStream out = new FileOutputStream(new File("Datos.xlsx"));
            wb.write(out);
            out.close();

        } catch(Exception e) {
            //Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

    }

}

public static void main(String[] args) {
    System.out.println("KKK");
    Apache.crearExcel();
    Apache.leer();
}
}
