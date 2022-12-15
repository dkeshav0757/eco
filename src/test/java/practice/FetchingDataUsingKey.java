package practice;

/*import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataUsingKey {
	
	
	public String fetchExcelData(String sheetName, String testCaseName, String ExpectedKey) throws EncryptedDocumentException, IOException
	{
		String value = "";
		FileInputStream fis=new FileInputStream("./src/test/resources/testscript (1).xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		DataFormatter DF=new DataFormatter();
		try {
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNumber = sheet.getRow(0).getLastCellNum();
		String expectedTestCaseName=testCaseName;
		String expectedKey=ExpectedKey;
		
		for(int i=0;i<=lastRowNum;i++)
		{
			String actualTestCase = sheet.getRow(i).getCell(0).toString();
			System.out.println(actualTestCase);
			if(actualTestCase.equals(expectedTestCaseName))
			{
				for(int j=1;j<lastCellNumber-1;j++)
				{
					String actualKey = sheet.getRow(i).getCell(j).toString();
					if(actualKey.equals(expectedKey))
					{
						value=DF.formatCellValue(sheet.getRow(i+1).getCell(j));		
						break;
					}
					
				}
				break;
			}}
			}
		
		finally {
			workbook.close();
			fis.close();
		}
		return value;
		
	}
		
	}
	*/


