package com.deb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		PreparedStatement pst = con.prepareStatement("select * from emp");

		ResultSet rs = pst.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnDisplaySize(1));
		System.out.println(rsmd.getColumnLabel(1));
		System.out.println(rsmd.getColumnName(1));
		System.out.println(rsmd.getColumnType(1));
		System.out.println(rsmd.getColumnTypeName(1));
		
		System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3));
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		
		
	}
}
