package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	String databaseName = "";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String username = "root";
	String password = "";
	
	private Connection conn = null;
	
	public DBUtil() {
		this.databaseName = "ad_recommand";
		this.url = url + databaseName;
	}
	
	public DBUtil(String dbName) {
		this.databaseName = dbName;
		this.url = url + databaseName;
	}
	
	public DBUtil(String databaseName, String username, String password) {
		this.databaseName = databaseName;
		this.url = url + databaseName;
		this.username = username;
		this.password = password;
	}
	
	public Connection openConnection() {
		try {
			Class.forName(driver);
			conn =  DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection() {
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
