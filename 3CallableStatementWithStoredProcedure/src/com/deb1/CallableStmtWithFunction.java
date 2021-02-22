package com.deb1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStmtWithFunction {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

	CallableStatement cst=conn.prepareCall("{?=call avgsal(?,?)}");
	cst.setInt(2, 7499);
	cst.setInt(3, 7369);
	cst.registerOutParameter(1, Types.FLOAT);
	
	cst.execute();
	System.out.println();
	System.out.println("The avg salary is "+cst.getFloat(1));
	conn.close();
	}
}
