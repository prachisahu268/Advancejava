package in.com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
		//resp.sendRedirect("LoginView.jsp");	
		String op=req.getParameter("operation");
		if( op !=null) {
			HttpSession session = req.getSession();
			session.invalidate();
			req.setAttribute("msg", "Logout successfully");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String loginId = req.getParameter("loginId");
	String password = req.getParameter("password");
	String uri = req.getParameter("uri");
	
	
	UserModel model = new UserModel();
	
   try {
	UserBean bean = model.authenticate(loginId, password);
	if (bean != null) {
//		req.setAttribute("bean", bean);
//		RequestDispatcher rd = req.getRequestDispatcher("WelcomeCtl");
//		rd.forward(req, resp);
		
		HttpSession session = req.getSession();
		session.setAttribute("user", bean);
		if (uri.equalsIgnoreCase("null")) {
			resp.sendRedirect("WelcomeCtl");
		}
			
		else {
			resp.sendRedirect(uri);
		}
	}else {
		req.setAttribute("msg","login & password is invalid...");
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req , resp);
	}
} catch (Exception e) {
	e.printStackTrace(); 
}
   
	}
}
