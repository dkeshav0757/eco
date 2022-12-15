package com.safezoo.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 
 * This method contains java reusable methods
 * @author keshav k
 *
 */

public class JavaUtility {
	/**
	 * 
	 * This method is used for convert to String to lomg datatype
	 * @author keshav k
	 */
public Object stringToAnyDataType(String s,String stratergy)
{
	Object convertedData = null;
	
	if(stratergy.equals("int"))
	{
		convertedData=Integer.parseInt(s);
	}
	
	else if(stratergy.equals("long"))
	{
		convertedData=Long.parseLong(s);//converted data will be return in the form of Object
	}
	return convertedData;
}


/**
 * This method is used to generate random Number
 * @param limit
 * @return
 */

   public int getRandomNumber(int limit)
  {
	int randomNumber=new Random().nextInt(limit);
	return randomNumber;
  }
   public void verifyUsingIF_Else(String actual,String expected,String printstatement) {
  if(actual.equals(expected))
  {
	System.out.println("Tc Pass=======>"+printstatement);
  }
  else {
	System.out.println("Tc Fail");
  }

  }

  public String[] splitString(String s,String statergy)
  {
	return s.split(statergy);

 }
  public int getMonthInMMFormat(String s)
 {
	return DateTimeFormatter.ofPattern("MMMM")
			.withLocale(Locale.ENGLISH)
			.parse(s)
			.get(ChronoField.MONTH_OF_YEAR);
	
 }
  
  public String getDateTime() {
	  Date date = new Date();
	  SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HH_mm_sss");
	  String d = sdf.format(date);
	return d;
  }
}

