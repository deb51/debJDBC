package com.deb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class UsingStatementInterface {
public static void main(String[] args) throws SQLException {
	//Driver driver = new OracleDriver();
	//DriverManager.registerDriver(driver);

	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select * from java14");
	while (rs.next()) {
		System.out.println(rs.getInt(1) + "===" + rs.getString(2));
	}
	conn.close();
}
}
