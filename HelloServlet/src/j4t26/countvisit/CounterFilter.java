package j4t26.countvisit;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/22session-login", "/22wellcome-session", "/22logout" }, initParams = {
		@WebInitParam(name = "count", value = "1000") })
public class CounterFilter implements Filter {
	private int count = 0;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		count++;
		System.out.println("visited: " + count);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String c = filterConfig.getInitParameter("count");
		count = Integer.parseInt(c);
	}
}
