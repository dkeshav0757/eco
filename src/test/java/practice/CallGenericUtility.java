package practice;

import com.safezoo.genericUtility.JavaUtility;

public class CallGenericUtility {

	public static void main(String[] args) {
		JavaUtility javaUtility=new JavaUtility();
		
		int l = (Integer)javaUtility.stringToAnyDataType("123", "int");
		System.out.println(l);

	}

}
