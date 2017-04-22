package me.xieren;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.JdbcUtil;

public class Test1 {
	public static void main(String[] args) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.getResultSet();
		boolean b = stmt.execute("select * from user");
		if (b) {
			while (rs.next()) {
				System.out.println("--------------------");
				System.out.println(rs.getObject("id"));
				System.out.println(rs.getObject("username"));
				System.out.println(rs.getObject("password"));
			}
		}
		JdbcUtil.release(rs, stmt, conn);
	}
}
