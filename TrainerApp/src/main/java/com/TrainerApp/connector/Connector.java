package com.TrainerApp.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection requestConnection() throws ClassNotFoundException, SQLException {
		//ducking concept [we will not handle the exception]
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/StudentApp";
		String user="root";
		String pwd="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		con=DriverManager.getConnection(url, user, pwd);
		return con;
	}

}
