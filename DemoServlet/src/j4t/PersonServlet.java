package j4t;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/add-user"})
public class PersonServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String name = req.getParameter("name");
		String age= req.getParameter("age");
		String adress = req.getParameter("adress");
		
		printWriter.println("name\t"+name+"\tage\t"+age+"\tadress\t"+adress);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String name = req.getParameter("name");
		String age= req.getParameter("age");
		String adress = req.getParameter("adress");
		
		printWriter.println("byGet:"+"name\t"+name+"\tage\t"+age+"\tadress\t"+adress);
	}
}
