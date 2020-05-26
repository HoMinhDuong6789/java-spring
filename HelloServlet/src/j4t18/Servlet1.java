package j4t18;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet1"})
public class Servlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter  printWriter= resp.getWriter();
		String jdbc = getServletContext().getInitParameter("jdbc");
		printWriter.println("wellcome j4t\t"+jdbc);
		
		getServletContext().setAttribute("name", "J4t\t");
	}
}
