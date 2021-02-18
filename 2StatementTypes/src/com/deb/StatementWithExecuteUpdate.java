package com.deb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class StatementWithExecuteUpdate {
	public static void main(String[] args) throws SQLException {

		Driver driver = new OracleDriver();
		DriverManager.registerDriver(driver);

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		Statement st = conn.createStatement();
		int count= st.executeUpdate("insert into java14 values(1,'sonu')");
		
		System.out.println(count+" row inserted");
		conn.close();

	}
}
