package cm.deb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConn {
	static Connection conn = null;

	public static Connection DBCon() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		System.out.println("the conn is: "+conn);
		return conn;
	}

}
