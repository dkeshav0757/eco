package com.safezoo.genericUtility;

/**
 * This Enum contains all sheet names
 * @author Keshav k
 *
 */

public enum SheetName {
	
	ANIMAL("Animal"),SEARCH("Search"),NORMALTICKET("NormalTicket"),SEARCHF("SearchF"),LOGINDATA("logindata"),LOGINGDATA("logindata");
	private String sheetName;
	
	private SheetName(String sheetName)
	{
		this.sheetName=sheetName;
	}

	//getter
	public String ConverToString()
	{
		return sheetName.toString();
	}
}
