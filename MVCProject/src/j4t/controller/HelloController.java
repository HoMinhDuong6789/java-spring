package j4t.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j4t.model.User;

@WebServlet(urlPatterns = { "/hello", "/xinchao" })
public class HelloController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User("J4T", "Hoan Dieu, Da Nang");
		req.setAttribute("u", user);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("hello.jsp");
		dispatcher.forward(req, resp);
	}
}
