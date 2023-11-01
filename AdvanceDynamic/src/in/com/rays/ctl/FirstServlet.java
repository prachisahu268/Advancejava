//url me name and address or multiple values like address indore bhopAL -arrey

package in.com.rays.ctl;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is first servlet do get..!!");
		
		//changes
		//resp.sendRedirect("/FirstServlet");
		
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");

		rd.forward(req, resp);

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
		System.out.println("this is my second method do post..!!!!!");
		
		//redirect
//		resp.sendRedirect("/FirstServlet");
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");

		rd.forward(req, resp);
	
    
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pwd = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		
		UserBean bean = new UserBean();
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(login);
		bean.setPassword(pwd);
        try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
      bean.setAddress(address);
      
      UserModel model = new UserModel();
      try {
		model.add(bean);
	} catch (Exception e) {
		e.printStackTrace();
	}
      
      
      
      
    resp.setContentType("text/html");
     PrintWriter out= resp.getWriter();
     out.write("<h1> hellow guyes....!!!!!</h1>");
     out.close();
	}
	
	

}
