package j4t22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/22session-login"})
public class SessionLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		resp.setContentType("text/html");
		String name = "";
		printWriter.println("<form action='/HelloServlet/22session-login' method='post'>\n" + 
				"  <input type='text' name='username'><br>\n" + 
				"  <input type='password' name='password' ><br><br>\n" + 
				"  <input type='submit' value='Login'>\n" + 
				"</form> ");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username.equals("j4t") && password.equals("1234")) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("username", username);
			resp.sendRedirect("/HelloServlet/22wellcome-session");
		}else {
			resp.sendRedirect("/HelloServlet/22session-login");
		}
	}
}
