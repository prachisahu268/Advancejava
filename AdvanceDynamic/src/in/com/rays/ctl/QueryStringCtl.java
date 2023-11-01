package in.com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QueryStringCtl")
public class QueryStringCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in QueryStringCtl do get....!!!");
		
		String name1 = req.getParameter("Name");
		
		System.out.println("name = "+ name1);
		
	String add = 	req.getParameter("Address");
		System.out.println("address ="+add);
	
	//multiple values hold []arrey
		String []Address =req.getParameterValues("Address");
		
		for (String add1 : Address) {
			System.out.println(add1);
			
			
		}
	}
	
	
		
	}


