package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
public String readDatafromExcel(String Sheetname,int rownum,int cellnum) throws Throwable {
	//FileInputStream fise=new FileInputStream("C:\\Users\\ABHISHEK\\OneDrive\\Documents\\eclipse\\Advancedselenium\\src\\test\\resources\\TDdata.xlsx");
	FileInputStream fise=new FileInputStream(IconstantUtility.excelpath);
	Workbook wb = WorkbookFactory.create(fise);
	String value = wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	return value;
}
}
