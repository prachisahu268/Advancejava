package in.com.raystec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CRUDTest {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun", "root", "root");

//		PreparedStatement ps = conn.prepareStatement("insert into emp values(6,'ritika',45000)");

		//int i = ps.executeUpdate();
		//System.out.println("Data Inserted" + i);

		
		PreparedStatement ps = conn.prepareStatement("insert into emp values (?,?,?)");
		
		ps.setInt(1, 8);
		ps.setString(2, "aryan");
		ps.setInt(3, 3000);
		
		int i = ps.executeUpdate();
		System.out.println("Data Inserted"+i);
      
		
	
	}

}
