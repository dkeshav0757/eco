package com.safezoo.genericUtility;
/**
 * This enum contains all the key of property file
 * @author admin
 *
 */

public enum PropertyFileKeys {
	
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout"), RANDOMNMBERLIMIT("randomNmberLimit");
	
	private String Keys;
	
	//setter
	private PropertyFileKeys(String Keys) {
		this.Keys=Keys;
	}
	
	//getter
	public String convertToString()
	{
		return Keys.toString();
	}

}
