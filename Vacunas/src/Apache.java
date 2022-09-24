import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apache {
    //Código usado para crear el Excel la primera vez
	public static void crearExcel() {
		XSSFWorkbook wb = new XSSFWorkbook();
        
    //Crear un sheet
		XSSFSheet sheet = wb.createSheet("Hospitales");
		
		//Crear row
		XSSFRow row = sheet.createRow(0);
		
		//Crear cells
		Cell cell0 = row.createCell(0);
        cell0.setCellValue(9);



        try {
            FileOutputStream out = new FileOutputStream(new File("Datos.xlsx"));
            wb.write(out);
            out.close();

        } catch(Exception e) {
            Logger.getLogger(Apache.class.getName()).log(Level.SEVERE, null, e);

    }

}
}
