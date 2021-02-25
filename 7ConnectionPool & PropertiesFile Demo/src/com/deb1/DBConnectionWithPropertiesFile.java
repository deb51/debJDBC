package com.deb1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnectionWithPropertiesFile {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		FileInputStream f = new FileInputStream("oracleDB.properties");

		Properties p = new Properties();
		p.load(f);
		String driver = p.getProperty("driver");
		String user = p.getProperty("username");
		String pass = p.getProperty("password");
		String url=p.getProperty("url");
		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,user,pass);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from empram");
		
		ResultSetMetaData rsmd=rs.getMetaData();
		System.out.println(rsmd.getColumnName(1)+"\t"+rsmd.getColumnName(2)+"\t"+rsmd.getColumnName(3));
		while(rs.next()) {

			System.out.println(rs.getString(1)+"\t"+rs.getNString(2)+"\t"+rs.getNString(3));
		}

	}
}
