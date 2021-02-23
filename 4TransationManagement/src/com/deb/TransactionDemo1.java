package com.deb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo1 {
public static void main(String[] args) {
	try {
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	con.setAutoCommit(false);
	Statement st=con.createStatement();
	st.execute("insert into java14 values(51,'Xavier')");
	st.execute("delete from java14 where sname='sonu'");
	con.commit();
	System.out.println("sucessfully done");
	}catch(SQLException e) {
		
	System.out.println("There is some problem");
	System.out.println(e);
}}
}
