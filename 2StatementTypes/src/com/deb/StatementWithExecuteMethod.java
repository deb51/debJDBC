package com.deb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class StatementWithExecuteMethod {
public static void main(String[] args) throws SQLException {
	

	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

	Statement st = conn.createStatement();
	boolean bo = st.execute("select * from java14");
	
	System.out.println("Always return true if select statement:::::::: "+bo);
	
	//To get ResultSet Value or insert update using execut method
	if(bo) {
		ResultSet rs=st.getResultSet();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		
	}
	else {
		int count=st.getUpdateCount();
	}
	conn.close();
}
}
