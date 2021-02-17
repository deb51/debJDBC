package com.deb1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cm.deb1.DataConn;

public class Check {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn=DataConn.DBCon();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from java14");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"===="+rs.getString(2));
		}
	}
}
