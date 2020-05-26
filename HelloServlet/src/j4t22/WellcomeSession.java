package j4t22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/22wellcome-session" })
public class WellcomeSession extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		resp.setContentType("text/html");
		String name = "";
		HttpSession httpSession = req.getSession();
		Object object = httpSession.getAttribute("username");
		if (object != null) {
			name = String.valueOf(object);
		} else {
			resp.sendRedirect("/HelloServlet/22session-login");
		}
		printWriter.println("Wellcome \t" + name);
		printWriter.println("<br><a href='/HelloServlet/22logout'>logout</a>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
