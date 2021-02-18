package com.deb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementOfPreparedStatementDynamic {
	public static void main(String[] args) throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
	
	PreparedStatement ps=conn.prepareStatement("insert into java14 values(?,?)");
		ps.setInt(1, 82);
		ps.setString(2, "RAAAA");
		int count=ps.executeUpdate();
		System.out.println(count+" rows inserted");
		conn.close();
		
	
	}
}
