package com.deb1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.driver.OracleDriver;

public class CallableStmtDemo1 {
	public static void main(String[] args) throws SQLException {

		Driver driver=new OracleDriver();
		DriverManager.registerDriver(driver);
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:1521:orcl","scott","tiger");
		//step 2
		CallableStatement cst=conn.prepareCall("{call addproc(?,?,?)}");
		
		//step3
		cst.setInt(1, 12);
		cst.setInt(2, 25);
		
		//step 4
		
		cst.registerOutParameter(3, Types.INTEGER);
		
		cst.execute();
		
		int result=cst.getInt(3);
		conn.close();
		System.out.println("The addition value is "+result);
		
	}
}
