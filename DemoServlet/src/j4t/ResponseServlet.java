package j4t;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test-response"})
public class ResponseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		resp.setContentType("text/html");
		PrintWriter printWriter= resp.getWriter();
		printWriter.println("<h1>Hello J4t</h1>");
		
		resp.addCookie(new Cookie("j4t", "Java Four Tranning"));
		resp.addHeader("a", "kkkkkkkk");
		resp.sendError(200);
	}
}
