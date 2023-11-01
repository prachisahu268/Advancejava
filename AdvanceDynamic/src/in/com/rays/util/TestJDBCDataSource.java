package in.com.rays.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class TestJDBCDataSource {
public static void main(String[] args)throws Exception {
	
	for (int i = 0; i < 50; i++) {
	
		System.out.println("Connection ="+i);
		testGet();
	}
	}


private static void testGet() throws SQLException {
Connection conn = JDBCDataSource.getConnection();
PreparedStatement ps = conn.prepareStatement("select * from marksheet1 where id =1");
ResultSet rs = ps.executeQuery();

while (rs.next()) {
	System.out.print(" "+rs.getInt(1));
	System.out.print(" "+ rs.getString(2));
	System.out.print(" "+ rs.getInt(3));
    System.out.print(" "+ rs.getInt(4));
    System.out.print(" "+ rs.getInt(5));
    System.out.println(" "+ rs.getInt(6));
}
}
}
