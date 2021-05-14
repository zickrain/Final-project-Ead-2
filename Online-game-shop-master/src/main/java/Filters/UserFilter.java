package Filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="UserFilter", urlPatterns={"/user/*", "/GameList", "/BuyCartServlet", "/CartsServlet"})
public class UserFilter extends UserGenericFilter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
	ServletException{
		HttpSession userSession = ((HttpServletRequest)request).getSession(false);
		String userStatus = (String )userSession.getAttribute("userStatus");
		String userSessionCheck = (String)userSession.getAttribute("userSession");
		String user = (String)userSession.getAttribute("user");
		response.setContentType("text/html");
		
		if(userSessionCheck != null && !userStatus.equals("false") && user.equals("user")){
			chain.doFilter(request, response);
		}else{
			((HttpServletResponse) response).sendRedirect("../Login.jsp");
		}
		
	}

}
