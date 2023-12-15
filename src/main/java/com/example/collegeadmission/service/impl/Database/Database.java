package com.example.collegeadmission.service.impl.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
public static Connection getConnection() {
	//variable
	Connection con=null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3307/empmgm", "root", "root");	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	//Returning connection
	return con;
	}
public static void main(String[] args) 
{
	Connection conn =getConnection();
	try {
	 if(conn!=null)
	 {
		 System.out.println("Connection successful");
		 
	 }
else
{
	 System.out.println("Connection not successful");
}
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}


	


