package com.safezoo.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Keshav K
 *
 */
public class FileUtility {
	private FileInputStream fis;
	private Properties property;
	/**
	 * This method is used to Open the proprty file
	 * Property file path
	 * @return 
	 * @return 
	 * @return 
	 * 
	 */
	public  void openPropertyFile(String propertyFilePath) 
	
	{
		
			
				try {
					fis=new FileInputStream(propertyFilePath);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
					property=new Properties();
		
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	/**
	 * This method is used to get the data from proprty file
	 * Property file path
	 * @return 
	 * @return 
	 * @return 
	 * 
	 */
			public String getDataFromPropertyFile(String Key) {
		
		String value = property.getProperty(Key);
		return value;
	}

	/**
	 * This method is used to close the proprty file
	 */
	
	public void closePropertyFile()   {
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
				
			

}

	
	


