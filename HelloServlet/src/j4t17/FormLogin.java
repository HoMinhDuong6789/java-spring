package j4t17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = {"/form-login"})
public class FormLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='/HelloServlet/login' method='post'>\n" + 
				"  <label for='txtname'>User:</label>" + 
				"  <input type='text' id='txtname' name='user'><br>\n" + 
				"  <label for='txtpassword'>password:</label>" + 
				"  <input type='password' id='txtpassword' name='password' ><br><br>\n" + 
				"  <input type='submit' value='Login'>\n" + 
				"</form> ");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
