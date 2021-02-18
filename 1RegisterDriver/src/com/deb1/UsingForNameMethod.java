package com.deb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingForNameMethod {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:1521:orcl", "scott", "tiger");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from java14");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "===" + rs.getString(2));
		}
		conn.close();
	}
}
