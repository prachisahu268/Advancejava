package in.com.rays.bundle;

import java.util.ResourceBundle;


public class TestBundle {
	public static void main(String[] args) {
		ResourceBundle rb =  ResourceBundle.getBundle("in.com.rays.bundle.app");
		String driver = rb.getString("greeting");
		System.out.println(driver);
	}

}
