package com.deb1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import oracle.jdbc.OracleTypes;


public class CallableStmtDemo3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		CallableStatement cst=conn.prepareCall("{call getall(?)}");
		
		cst.registerOutParameter(1,OracleTypes.CURSOR);
		
		cst.execute();
		ResultSet rs=(ResultSet)cst.getObject(1);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"--______--"+rs.getString(2));
		}
	}
}
