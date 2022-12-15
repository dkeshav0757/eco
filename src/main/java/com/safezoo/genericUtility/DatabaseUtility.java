package com.safezoo.genericUtility;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility {
	
	private Connection connection;
	private Driver dbdriver;
	/**
	 * This method is used to get the data from data base
	 * @param query
	 * @param coloumnName
	 * @return
	 * @throws SQLException 
	 * @throws SQL Exception
	 */
	
	public List<String>getDataFromDatabase(String query,String columnName) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
	 List<String> list=new ArrayList<String>();
	 while(result.next())
	 {
		 list.add(result.getString(columnName));
	 }
	
	return list;
		
}
	/**
	 * This method is used to open the db connection
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */
	
	public void openDBConnection(String dbURL,String dbUserName,String dbPassword)throws SQLException
	{
		 dbdriver=new Driver();
		DriverManager.registerDriver((dbdriver));
		connection=DriverManager.getConnection(dbURL,dbUserName,dbPassword);
	}
	/**
	 * To close the data base connection
	 * @throws SQLException
	 */
	
	public void closeDB() throws SQLException
	{
		connection.close();
	}
	/**
	 * To modify the data in data base
	 * @param query
	 * @throws SQLException
	 */

	public void modifyDataIntoDatabase(String query) throws SQLException
	{
		Statement statement = connection.createStatement();
		statement.executeQuery(query);
	}
	/**
	 * This method is used to verify the data in data base
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean verifyDataInDatabase(String querry,String columnName,String expectedData) throws SQLException
	{
		List<String> list=getDataFromDatabase(querry,columnName);
		boolean flage=false;
		if(list.contains(expectedData)) flage=true;
		return flage;
	}
	
	
	
}
