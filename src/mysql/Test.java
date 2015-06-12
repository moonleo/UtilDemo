package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {
	
	static String sql = "select * from user;";
	
	public static void main(String[] args) {
		
		DBUtil dbUtil = new DBUtil("myutil");
		Connection conn = dbUtil.openConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				System.out.println(id + ":" + name + ":" + password + ";");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeConnection();
		}
	}

}
