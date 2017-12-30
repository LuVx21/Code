package org.luvx.utilsTest;

import org.junit.Test;
import org.luvx.utils.Poolc3p0Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Poolc3p0UtilsTest {

    @Test
    public void run01() throws SQLException {
        Connection conn = Poolc3p0Utils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM User");
        while (rs.next()) {
            System.out.println(rs.getObject(2));
        }
        Poolc3p0Utils.release(rs, stmt, conn);
    }
}
