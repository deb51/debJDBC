package com.deb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetSensitiveReadOnly {
	public static void main(String[] args) throws SQLException {


		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery("select eno,ename,sal,dept from empram");
		while(rs.next()){
			System.out.println(rs.getInt("eno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal")+"\t"+rs.getString("dept"));
		}
		System.out.println("==========================");
		while(rs.previous()){
			System.out.println(rs.getInt("eno")+"\t"+rs.getString("ename")+"\t"+rs.getInt("sal")+"\t"+rs.getString("dept"));
		}
	}

	
	}

