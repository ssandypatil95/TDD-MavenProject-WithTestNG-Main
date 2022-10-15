package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String readdata(int row,int column) throws IOException
	{
		String path = System.getProperty("user.dir")+"\\TestData.xlsx";
		
		File src = new File(path);
		
	// Loading the Excel Sheet	
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh1 = wb.getSheet("sheet1");                                 // use of name of sheet as a string,this method will be used
//		XSSFSheet sh1 = wb.getSheetAt(0);                                     // use of index position of sheet,this method will be used 
		
		
//	 	To read the only string value from the excel sheet
		
//		String value = sh1.getRow(4).getCell(1).getStringCellValue();	
//		System.out.println(value);
		
		
		DataFormatter df = new DataFormatter();                                        // Use only this method for all types data
		
		String value = df.formatCellValue(sh1.getRow(row).getCell(column));
		
		System.out.println(value);
		
		return value;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		ExcelReader er = new ExcelReader();
		
		er.readdata(2, 1);
		
	}
}
