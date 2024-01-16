package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utilities {
	public String getExcelData(String sheetname,int RowNum,int CellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("D:\\MY Courses\\Advanced Selenium\\Testcases.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(RowNum);
		Cell cell = row.getCell(CellNum);
		
		String Exceldata = cell.getStringCellValue();
		return Exceldata;
	}
	public String getDataFormatterdata(String sheetname,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("D:\\MY Courses\\Advanced Selenium\\Testcases.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String Exceldata = format.formatCellValue(cell);
	
		return Exceldata;
	}
	public Object[][] readmultipledata(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("D:\\MY Courses\\Advanced Selenium\\Testcases.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		short lastcell = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				//obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
		
	}
}
