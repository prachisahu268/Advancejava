package in.com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;

public class MarksheetModel {
	 
	public Integer nextPk() throws Exception{
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marksheet","root","root");
		return null;
		
	}
	
	

}
