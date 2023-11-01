package in.com.rays.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;

public class UserTest {

	public static void main(String[] args) throws Exception{
		
		//testAdd();
	    	testdelete();
		
	}
	
	private static void testdelete() throws Exception{
      UserModel model=new UserModel();
      
      model.delete(2);
      
      
		
		
	}


	private static void testAdd()throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean=new UserBean();
		
		bean.setFirstName("tanna");
		bean.setLastName("sahu");
		bean.setLoginId("sahuprachi268@gmail.com");
		bean.setPassword("prachi@123");
		bean.setDob(sdf.parse("2023-10-11"));
		bean.setAddress("indore");
		
	UserModel model = new UserModel();
	model.add(bean);
		
	}
	
	
	
	
	
	
	
}
