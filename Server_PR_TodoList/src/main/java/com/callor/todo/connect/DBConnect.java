package com.callor.todo.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static Connection dbConn;
	
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/todolist";
		String username = "ToDoList";
		String password = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
			dbConn = DriverManager.getConnection(url,username,password);
			System.out.println("mysql ���ӿϷ�");
			
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc ��� ����");
		} catch (SQLException e) {
			System.out.println("url,username,password�� Ȯ���ϼ���.");
		}
		
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}

}

