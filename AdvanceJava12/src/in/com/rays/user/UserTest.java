package in.com.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTest {

	public static void main(String[] args) throws Exception{
		
		testAdd();
		
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
