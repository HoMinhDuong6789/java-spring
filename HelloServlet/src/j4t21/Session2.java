package j4t21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/21session2" })
public class Session2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		resp.setContentType("text/html");
		String name = "";
		HttpSession httpSession = req.getSession();
		Object object = httpSession.getAttribute("name");
		if(object!=null) {
			name = String.valueOf(object);
		}else {
			resp.sendRedirect("/HelloServlet/21hello-session");
		}
		printWriter.println("wellcome\t"+name);
	}
}
