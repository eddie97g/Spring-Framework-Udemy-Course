package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connected!!!");
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}
