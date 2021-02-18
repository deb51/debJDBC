package com.deb1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class StatementOfPreparedStatementType {
public static void main(String[] args) throws SQLException {
	

	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

	PreparedStatement st = conn.prepareStatement("select * from java14");
	ResultSet rs = st.executeQuery();
	while (rs.next()) {
		System.out.println(rs.getInt(1) + "===" + rs.getString(2));
	}
	conn.close();
}
}
