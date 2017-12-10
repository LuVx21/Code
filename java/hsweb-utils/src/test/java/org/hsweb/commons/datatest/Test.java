package org.hsweb.commons.datatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott", "root", "1121");
			stmt = conn.createStatement();
			boolean b = stmt.execute("select * from user");
			if (b) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println("--------------------");
					System.out.println(rs.getObject("id"));
					System.out.println(rs.getObject("username"));
					System.out.println(rs.getObject("password"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}