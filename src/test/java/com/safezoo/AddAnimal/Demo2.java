package com.safezoo.AddAnimal;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.EditAnimalPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.MnageAnimals;
import com.safezoo.ObjectRefository.addAnimal;
import com.safezoo.ObjectRefository.commonPage;
import com.safezoo.genericUtility.BaseClass;
import com.safezoo.genericUtility.ExcelUtility;
import com.safezoo.genericUtility.FileUtility;
import com.safezoo.genericUtility.IConstuntPath;
import com.safezoo.genericUtility.JavaUtility;
import com.safezoo.genericUtility.PropertyFileKeys;
import com.safezoo.genericUtility.SheetName;
import com.safezoo.genericUtility.WebDriverUtility;

	public class Demo2 {
	
	@Test(dataProvider="getData")
	public void test3(String usename,String password) {
	
		System.out.println("usenename===>>"+usename+"pasword===>>"+password);
		
	
	
	}
	
	@DataProvider
	public String[][] getData() throws EncryptedDocumentException,IOException
	{
		
		ExcelUtility excelutility=new ExcelUtility();
		excelutility.openExcel(IConstuntPath.EXCEL_PATH);
		String[][] arr = excelutility.getDataFromExcel("logindata");
		return arr;
		
	}
	
}
		
	
