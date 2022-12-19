package com.safezoo.genericUtility;

import org.testng.Assert;

public class ValidateTest {
	private ExcelUtility excelutility;

		/**
		 *  This class is used to REPORT the pass testcase Status
		 * @param sheetName
		 * @param testCaseName
		 * @param excel
		 */
		public void passStatus(String sheetName, String ExpectedtestCaseName,String excelPath)
		{
			excelutility=new ExcelUtility();
			for (int i = 0; i <excelutility.getLastRowNumOfExcel(sheetName); i++) 
			{
				String actualTestCaseName = excelutility.getDataFromExcel(sheetName, i, i+1);

				if(actualTestCaseName.equals(ExpectedtestCaseName))
				{
					excelutility.setDataIntoExcel(sheetName, i+1,excelutility.getLastRowNumOfExcel(sheetName)-1, "PASSED", excelPath);
					break;
				}
				Assert.assertTrue(true);

			}
		}



		/**
		 *  This class is used to REPORT the fail testcase Status
		 * @param sheetName
		 * @param testCaseName
		 * @param excel
		 */
		public void failStatus(String sheetName, String ExpectedtestCaseName,String excelpath)
		{
			excelutility=new ExcelUtility();

			for (int j = 0; j <excelutility.getLastRowNumOfExcel(sheetName); j++) 
			{
				String actualTestCaseName = excelutility.getDataFromExcel(sheetName, j, 1);

				actualTestCaseName = excelutility.getDataFromExcel(sheetName, j, 1);

				if(actualTestCaseName.equals(ExpectedtestCaseName))
				{
					excelutility.setDataIntoExcel(sheetName, j+1,excelutility.getLastCellNumOfExcel(sheetName, 0)-1, "FAILED", excelpath);
					break;

				}
			}
			Assert.fail("FAILED");


		}


		/**
		 *  This class is used to validate the testcase Status
		 * @param actual
		 * @param expected
		 * @param sheetName
		 * @param testCaseName
		 * @param excel
		 */
		public void validateStatus(String actual , String expected,String sheetName, String ExpectedtestCaseName)
		{
			excelutility=new ExcelUtility();
			ValidateTest validatetest= new ValidateTest();
			if(actual.contains(expected))
			{
				validatetest.passStatus(sheetName, ExpectedtestCaseName,IConstuntPath.EXCEL_PATH);
			}
			else

			{
				validatetest.failStatus(sheetName, ExpectedtestCaseName,IConstuntPath.EXCEL_PATH);
			}
			
			Assert.assertTrue(actual.contains(expected));
		}

	}




