package in.com.raystec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAdd {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * Class.forName("com.mysql.cj.jdbc.Driver");
		 * 
		 * Connection
		 * conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sun","root",
		 * "root"); Statement stmt=conn.createStatement();
		 * 
		 * int i= stmt.executeUpdate("insert into emp values(1,'prachi',89593697)"); int
		 * i1= stmt.executeUpdate("insert into emp values(2,'shruti',42386879)");
		 * System.out.println("data inserted" +i1 );
		 * 
		 * 
		 * int i2=stmt.executeUpdate("delete from emp where id =1");
		 * System.out.println("Data inserted"+i2);
		 */
	
	add(6,"shiv",5000);
	System.out.println("inserted");
	

	}

	private static void add(int id, String name,int salary)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sun","root","root");
		
		Statement stmt=conn.createStatement();
		
		int i = stmt.executeUpdate("update emp set name='janvi' where id = 5");
		
		System.out.println("Data inserted"+i);
		
	}
}

	
	
	