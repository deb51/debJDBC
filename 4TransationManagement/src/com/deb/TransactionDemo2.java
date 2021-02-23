package com.deb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo2 {
	public static void main(String[] args) {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			count1 = st.executeUpdate("insert into java14 values(51,'Xavier')");
			System.out.println(count1 + "record inserted");
			Thread.sleep(15000);
			count2 = st.executeUpdate("update java14 set sid=sid-100 where sid>100");
			System.out.println(count2 + "record updated");
			Thread.sleep(15000);
			count3 = st.executeUpdate("delete from java14 where sname='ZZZZ'");
			System.out.println(count3 + "record deleted");
			Thread.sleep(15000);
			if (count1 >= 1 && count2 >= 1 && count3 >= 1) {
				System.out.println("if block");
				con.commit();
			} else {
				System.out.println("else block");
				con.rollback();
			}
		} catch (Exception e) {
			System.out.println("outer catch block");
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("inner catch block");
				e1.printStackTrace();
			}
		}
	}
}
