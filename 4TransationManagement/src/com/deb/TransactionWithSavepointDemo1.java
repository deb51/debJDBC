package com.deb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionWithSavepointDemo1 {
	public static void main(String[] args) {
		try {
		Savepoint sp = null;
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		
			st.execute("insert into java14 values(85,'VVV')");
			System.out.println("OP1");
			st.execute("insert into java14 values(84,'XXX')");
			System.out.println("OP2");
			sp = con.setSavepoint();
			st.execute("insert into java14 values(45,'DBABA')");
			System.out.println("OP3");
			st.execute("insert into java14 values(99,'KHABA')");
			System.out.println("OP4");
			con.rollback(sp);
			
			st.execute("insert into java14 values(88,'SamBA')");
			System.out.println("OP5");
			con.commit();
			System.out.println("All Commited");

		} catch (SQLException e) {

			System.out.println("Check the sql");
		}
	}
}
