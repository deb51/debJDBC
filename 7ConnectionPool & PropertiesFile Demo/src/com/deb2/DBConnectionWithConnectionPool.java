package com.deb2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class DBConnectionWithConnectionPool {
public static void main(String[] args) throws SQLException {
	//create Oracle Connection pool DataSource Object
	OracleConnectionPoolDataSource ocp=new OracleConnectionPoolDataSource();
	
	//using Setter method to set Url,user,pass
	ocp.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
	ocp.setUser("scott");
	ocp.setPassword("tiger");
	
	//getting pool connection
	PooledConnection pc=ocp.getPooledConnection();
	
	//get logical connection
	Connection con=pc.getConnection();
	
	PreparedStatement ps=con.prepareStatement("select * from empram");
	ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	}
	
}
}
