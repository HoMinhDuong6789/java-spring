package j4t;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

@WebServlet(urlPatterns = {"/form-user"})
public class FormPerson extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<form action='/HelloServlet/add-user' method='get'>\n" + 
			"  <label for='txtname'>Name:</label>" + 
			"  <input type='text' id='txtname' name='name'><br>\n" + 
			"  <label for='txtage'>Age:</label>" + 
			"  <input type='text' id='txtage' name='age' ><br><br>\n" + 
			"  <label for='txtadress'>Adress:</label>" + 
			"  <input type='text' id='txtadress' name='adress' ><br><br>\n" + 
			"  <input type='submit' value='Submit'>\n" + 
			"</form> ");
			
		}
	}
