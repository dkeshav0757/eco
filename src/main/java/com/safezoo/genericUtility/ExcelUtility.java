package com.safezoo.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	private Workbook workbook;
	private DataFormatter df;
	private FileInputStream fis;
	 private FileOutputStream fos;
	
	/**
	 * This method is used open the workbook
	 * 
	 */
	public void openExcel(String excelPath)
	{
	
		try {
			fis=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	
		try {
			workbook=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the data from excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
		public String getDataFromExcel(String sheetName,int rowNumber,int cellNumber) 
		{
	 df=new DataFormatter();
	String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
	return data;
	}
		
		/**
		 * This method is used to fetch data from excel based on key
		 * @param sheetName
		 * @param expectedTestCase
		 * @param expectedKey
		 * @return
		 */
		public String getDataFromExcel(String sheetName,String expectedTestCase,String expectedKey)
		{
			 
			Sheet sheet = workbook.getSheet(sheetName);
			int lastRowNumber = sheet.getLastRowNum();
			short lastCellNumber = sheet.getRow(0).getLastCellNum();
			String value = "";
			for(int i=0;i<=lastRowNumber;i++)
			{
				String actualTestCase = sheet.getRow(i).getCell(0).getStringCellValue();
				if(actualTestCase.equals(expectedTestCase))
				{
					for(int j=1;j<lastCellNumber;j++)
					{
						String actualKey = sheet.getRow(i).getCell(j).getStringCellValue();
						
						if(actualKey.equals(expectedKey))
						{
							value=sheet.getRow(i+1).getCell(j).getStringCellValue();
							break;
						}
					}
					break;
				}
			}
			return value;
		}
		
		/**
		 * This data is used to fetch multiple data from excel and store in String[][]
		 * @param sheetName
		 * @return
		 */
		
		public String[][] getDataFromExcel(String sheetName)
		{
			 df=new DataFormatter();
			Sheet sheet = workbook.getSheet(sheetName);
			int lastRowNumber = sheet.getLastRowNum();
			short lastCellNumber = sheet.getRow(0).getLastCellNum();
			String[][] arr =new String[lastRowNumber][lastCellNumber];
			for(int i=1;i<=lastRowNumber+1;i++)
			{
				for(int j=0;j<=lastCellNumber;j++) {
			
				arr[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
			
		    }
		return arr;
		}
		/**
		 * this method is used to get the last row number in excel
		 * @return
		 */

		public int getLastRowNumOfExcel(String sheetName)
		{

			int lastRowNumber = workbook.getSheet(sheetName).getLastRowNum();
			return lastRowNumber;
		}





		/**
		 * This method used to get the last cell number in excel
		 * @param sheetName
		 * @param rowNumber
		 * @return
		 */
		public int getLastCellNumOfExcel(String sheetName, int rowNumber)
		{
			int lastCellNumber = workbook.getSheet(sheetName).getRow(rowNumber).getLastCellNum();
			return lastCellNumber;		
		}
		
		/**
		 * This method is Used to write the Result data into excel
		 */
		public void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String result,String excelPath)
		{	
			workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).setCellValue(result);

			try {
				fos = new FileOutputStream(excelPath);
				try {
					workbook.write(fos);
				} catch (IOException e) {
				}
			} catch (FileNotFoundException e) {

			}
		}

}
