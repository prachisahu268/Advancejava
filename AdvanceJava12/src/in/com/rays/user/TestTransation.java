package in.com.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransation {
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn	=DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");

try {
	conn.setAutoCommit(false);
	Statement stmt =conn.createStatement();
	int i = stmt.executeUpdate("insert into marksheet1 values(11,'gabbar',111,67,78,90)");
	i = stmt.executeUpdate("insert into marksheet1 values(12,'sagar',112,56,67,78)");
	i= stmt.executeUpdate("insert into marksheet1 values(13,'sawansir',113,45,56,67)");
   conn.commit();
   conn.close();
   System.out.println("Data inserted "+i);
	
} catch (Exception e) {
	conn.rollback();
}
}
}
