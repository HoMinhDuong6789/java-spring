package j4t17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String user = req.getParameter("user");
		printWriter.println("wellcome\t"+ user);
		if(user.equals("j4t")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/wellcome");
			dispatcher.forward(req, resp);
		}else {
			printWriter.println("user not corect");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/form-login");
			dispatcher.include(req, resp);
		}
	}
}
