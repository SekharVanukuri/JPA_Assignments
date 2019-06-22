package com.cg.library.util;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
static Connection con;
	
	static
	{
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream("jdbc.properties"));
			String driver = prop.getProperty("driver");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnect()
	{
		return con;
	}

}
