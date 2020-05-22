package j4t;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/xin-chao","/hello"})
public class HelloServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("init Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("Service servlet"+ req.getMethod());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get ");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Hello - Xin Chao</h1>");
		writer.close();
		System.out.println("phuong thuc cua request\t"+req.getMethod());
		System.out.println("ontent type\t"+req.getContentType());
		System.out.println("cookie\t"+req.getCookies());
		System.out.println("Server name\t"+req.getServerName());
		Enumeration<String> keys = req.getHeaderNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			System.out.println(key+"\t"+req.getHeader(key));
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy servlet");
	}
	
}
