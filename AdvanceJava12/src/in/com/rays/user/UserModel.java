package in.com.rays.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class UserModel {
	
public Integer nextPk()throws Exception {
	int pk = 0;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
	
	PreparedStatement ps = conn.prepareStatement("select max(Id) from student");
	
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		pk = rs.getInt(1);
	}
	return pk+1;
	
}



public UserBean authenticate(String loginId, String password) throws Exception {

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/sunrays", "root", "root");

	PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ?");

	ps.setString(1, loginId);
	ps.setString(2, password);

	ResultSet rs = ps.executeQuery();

	UserBean bean = null;

	while (rs.next()) {
		bean = new UserBean();
		bean.setId(rs.getInt(1));
		bean.setFirstName(rs.getString(2));
		bean.setLastName(rs.getString(3));
		bean.setLoginId(rs.getString(4));
		bean.setPassword(rs.getString(5));
		bean.setDob(rs.getDate(6));
		bean.setAddress(rs.getString(7));
	}
	return bean;

}
public void add(UserBean bean)throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
	
	PreparedStatement ps = conn.prepareStatement("insert into student values (?,?,?,?,?,?,?)");
	
	ps.setInt(1, nextPk());
	ps.setString(2, bean.getFirstName());
	ps.setString(3, bean.getLastName());
	ps.setString(4, bean.getLoginId());
	ps.setString(5, bean.getPassword());
	ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
	ps.setString(7, bean.getAddress());
	
	int i = ps.executeUpdate();
	System.out.println("Data inserted"+i);
	
}
	public List search(UserBean bean,int pageNo,int pageSize)throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
		
		StringBuffer sql = new StringBuffer("select * from student where 1=1");
	
		if(bean !=null) {
			
			if(bean.getFirstName()!=null&& bean.getFirstName().length()>0) {
				
				sql.append(" and name like '"+bean.getFirstName()+"%'");
				
			}
			if(bean.getId()>0) {
             sql.append(" and id ="+bean.getId());
             
			}
		}
		if(pageSize>0) {
			pageNo = (pageNo -1)*pageSize;
			sql.append(" limit" +pageNo+","+pageSize);
			
		}
		System.out.println("sql=" +sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list=new ArrayList();
		
		while (rs.next()) {
			bean= new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getTime(6));
			bean.setAddress(rs.getString(7));
			
			
			list.add(bean);
			
			
		}
		return list;
	}

}
