package DDF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel1 {
public static void main(String[] args) throws Throwable {
//create object of fileinputstream class
	FileInputStream fise=new FileInputStream("C:\\Users\\ABHISHEK\\OneDrive\\Documents\\eclipse\\Advancedselenium\\Externalresources\\TDdata.xlsx");
	//workbook factory open excel sheet
	Workbook wb = WorkbookFactory.create(fise);
	//String data = wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
	//double data = wb.getSheet("Sheet1").getRow(0).getCell(1).getNumericCellValue();
	boolean data = wb.getSheet("Sheet1").getRow(0).getCell(2).getBooleanCellValue();
	System.out.println(data);
}	
}
