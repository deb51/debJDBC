package com.deb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RsultSetForwardOnlyDemo {
	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		PreparedStatement pst=con.prepareStatement
				("select * from java14",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=pst.executeQuery();
	
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"==="+rs.getString(2));
		}
	}
}
